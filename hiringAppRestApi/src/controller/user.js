const {registerUserModel, checkUserModel} = require('../models/user')
const bcrypt = require('bcryptjs')
const jwt = require('jsonwebtoken')
require('dotenv').config()


module.exports = {
  registerUser: async(req, res) => {
    const {user_name, user_password, user_email, phone, user_role, user_status} = req.body
    const salt = bcrypt.genSaltSync()
    const passEncrypt = bcrypt.hashSync(user_password, salt)
    const setData = {
      user_name,
      user_password: passEncrypt,
      user_email,
      phone,
      user_role,
      user_status,
      created_at: new Date()
    }
    try {
      const result = await registerUserModel(setData)
      res.send({
        status: `true`,
        message: `Data berhasil ditambahkan`,
        data: result
      });
    } catch (error) {
      res.status(500).send({
        status: `false`,
        message: `Data gagal ditambahkan`
      });
    }
  },

  loginUser: async(req, res) => {
    try {
      const { user_email, user_password} = req.body
      const checkUserData = await checkUserModel(user_email)
      if(checkUserData.length >= 1) {
        const checkPassword = bcrypt.compareSync(user_password, checkUserData[0].user_password)
        if(checkPassword) {
          const {id, user_name, user_password, phone, user_email, user_role, user_status} = checkUserData[0]
          let payload = {
            id,
            user_name,
            user_password,
            phone,
            user_email,
            user_role,
            user_status
          }
          const token = jwt.sign(payload, process.env.JWT_KEY, {expiresIn: "0.5h"})
          payload = {...payload, token}
          res.status(200).send({
            status: 'true',
            message: payload
          });
        } else {
          res.status(400).send({
            status: 'false',
            message: 'Password Salah'
          });
        }
      } else {
        res.status(404).send({
          status: 'false',
          message: 'Email Belum Terdaftar'
        });
      }
    } catch (error) {
      res.status(500).send({
        status: `false`,
        message: error.message
      });
    }
  }
}