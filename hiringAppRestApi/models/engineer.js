const db = require('../config/db')

module.exports = {
  getAllEngineerModel: (cb) => {
    db.query(`SELECT * FROM engineer`, (err, result) => {
      cb(result)
    })
  },

  getEngineerModelById: (id, cb) => {
    db.query(`SELECT * FROM engineer WHERE id=${id}`, (err, result) => {
      cb(result)
    })
  },

  createEgineerModel: (arr, cb) => {
    let sql = `INSERT INTO engineer (nama, jobdesc, lokasi, status, deskripsi, skill) VALUES ('${arr[0]}', '${arr[1]}', '${arr[2]}', '${arr[3]}', '${arr[4]}', '${arr[5]}')`
    db.query(sql, (err, result) => {
      cb(result)
    })
  },

  deleteEngineerModel: (id, cb) => {
    let sql = `DELETE FROM engineer WHERE id=${id}`
    db.query(sql, (err, result) => {
      cb(result)
    })
  },

  updateEngineerModel: (arr, id, cb) => {
    let sql = `UPDATE engineer SET nama = '${arr[0]}', jobdesc='${arr[1]}', lokasi='${arr[2]}', status='${arr[3]}', deskripsi='${arr[4]}', skill='${arr[5]}' WHERE id=${id}`
    db.query(sql, (err, result) => {
      cb(result)
    })
  },

  getEngineerModelByParams: (paramKey, paramValue, cb) => {
    let sql = `SELECT * FROM engineer WHERE ${paramKey} LIKE '%${paramValue}'`
    db.query(sql, (err, result) => {
      cb(result)
    })
  }
}