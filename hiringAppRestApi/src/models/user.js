const db = require('../../config/db')

module.exports = {
  registerUserModel: (setData) => {
    return new Promise((resolve, reject) => {
      db.query('INSERT INTO user SET ?', setData, (err, result) => {
        if(!err) {
          const newResult = {
            id: result.insertedId,
            ...setData
          }
          delete newResult.user_password
          resolve(newResult)
        }else {
          reject(new Error(err))
        }
      })
    })
  },

  checkUserModel: (email) => {
    return new Promise((resolve, reject) => {
      db.query(`SELECT id, user_name, user_email, phone, user_password, user_role, user_status FROM user WHERE user_email = '${email}'`, (err, result) => {
        if (!err) {
          resolve(result)
        } else {
          reject(new Error(err))
        }
      })
    })
  }
}