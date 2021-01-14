const db = require('../../config/db')


module.exports = {
  postExperienceModel: (setData) => {
    return new Promise((resolve, reject) => {
      const sqlQuery = 'INSERT INTO experience SET ?'
      db.query(sqlQuery, setData, (err, result) => {
        if(!err) {
          resolve(result)
        }
        reject(new Error(err))
      })
    })
  },

  getAllExperienceModel: () => {
    return new Promise((resolve, reject) => {
      const sqlQuery = 'SELECT * FROM experience'
      db.query(sqlQuery, (err, result) => {
        if(!err) {
          resolve(result)
        }
        reject(new Error(err))
      })
    })
  },

  deleteExperienceModel: (id) => {
    return new Promise((resolve, reject) => {
      const sqlQuery = `DELETE FROM experience WHERE id = ${id}`
      db.query(sqlQuery, (err, result) => {
        if(!err) {
          resolve(result)
        }
        reject(new Error(err))
      })
    })
  },

  updateExperienceModel: (setData, id) => {
    return new Promise((resolve, reject) => {
      const sqlQuery = `UPDATE experience SET ? WHERE id = ${id}`
      db.query(sqlQuery, setData, (err, result) => {
        if(!err) {
          resolve(result)
        }
        reject(new Error(err))
      })
    })
  }
}