const db = require('../../config/db')


module.exports = {
  postPortfolioModel: (setData) => {
    return new Promise((resolve, reject) => {
      const sqlQuery = 'INSERT INTO portfolio SET ?'
      db.query(sqlQuery, setData, (err, result) => {
        if(!err) {
          resolve(result)
        }
        reject(new Error(err))
      })
    })
  },

  getAllPortfolioModel: () => {
    return new Promise((resolve, reject) => {
      const sqlQuery = 'SELECT * FROM portfolio'
      db.query(sqlQuery, (err, result) => {
        if(!err) {
          resolve(result)
        }
        reject(new Error(err))
      })
    })
  },

  deletePortfolioModel: (id) => {
    return new Promise((resolve, reject) => {
      const sqlQuery = `DELETE FROM portfolio WHERE id = ${id}`
      db.query(sqlQuery, (err, result) => {
        if(!err) {
          resolve(result)
        }
        reject(new Error(err))
      })
    })
  },

  updatePortfolioModel: (setData, id) => {
    return new Promise((resolve, reject) => {
      const sqlQuery = `UPDATE portfolio SET ? WHERE id = ${id}`
      db.query(sqlQuery, setData, (err, result) => {
        if(!err) {
          resolve(result)
        }
        reject(new Error(err))
      })
    })
  },

  getPortfolioByIdEngineerModel: (id) => {
    return new Promise((resolve, reject) => {
      const query = `SELECT * FROM portfolio WHERE id_engineer = ${id}`
      db.query(query, (err, result) => {
        if(!err) {
          resolve(result)
        }
        reject(new Error(err))
      })
    })
  }
}