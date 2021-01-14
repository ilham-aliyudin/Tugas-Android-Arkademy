const db = require('../../config/db')

module.exports = {
  postSkillModel: (setData) => {
    return new Promise((resolve, reject) => {
      db.query('INSERT INTO skill SET ?', setData, (err, result) => {
        if (!err) {
          resolve(result)
        } else {
          reject(new Error(err))
        }
      })
    })
  },

  getAllSkillModel: () => {
    return new Promise((resolve, reject) => {
      const sqlQuery = 'SELECT * FROM skill'
      db.query(sqlQuery, (err, result) => {
        if(!err) {
          resolve(result)
        }
        reject(new Error(err))
      })
    })
  },

  deleteSkillModel: (id) => {
    return new Promise((resolve, reject) => {
      const sqlQuery = `DELETE FROM skill WHERE id_skill = ${id}`
      db.query(sqlQuery, (err, result) => {
        if(!err) {
          resolve(result)
        }
        reject(new Error(err))
      })
    })
  },

  updateSkillModel: (setData, id) => {
    return new Promise((resolve, reject) => {
      const sqlQuery = `UPDATE skill SET ? WHERE id_skill = ${id}`
      db.query(sqlQuery, setData, (err, result) => {
        if(!err) {
          resolve(result)
        }
        reject(new Error(err))
      })
    })
  }
}