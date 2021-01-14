const e = require('express')
const db = require('../../config/db')

module.exports = {
  getAllHireModels: () => {
    return new Promise((resolve, reject) => {
      const query = `SELECT * FROM hire`
      db.query(query, (err, result) => {
        if (!err) {
          resolve(result)
        } else {
          reject(new Error(err))
        }
      })
    })
  },
  
  getHireByIdEngineerModel: (id) => {
    return new Promise((resolve, reject) => {
      const query = `SELECT nama, project_name, description, price, deadline, confirm_status FROM hire JOIN project ON hire.id_project = project.id_project JOIN engineer ON hire.id_engineer = engineer.id WHERE id_engineer= ${id}`
      db.query(query, id, (err, result) => {
        if(!err) {
          resolve(result)
        } else {
          reject(new Error(err))
        }
      })
    })
  },

  updateHireByIdEngineerModel: (id, setData) => {
    return new Promise((resolve, reject) => {
      const query = `UPDATE hire SET (confirm_status) = setData WHERE id = ${id}`
    })
  }
}