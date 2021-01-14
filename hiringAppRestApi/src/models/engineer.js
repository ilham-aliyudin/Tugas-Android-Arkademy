const db = require('../../config/db')

module.exports = {
  getAllEngineerModel: ( orderFormat, order, limit, page, cb) => {
    db.query(`SELECT * FROM engineer ORDER BY ${order} ${orderFormat} LIMIT ${limit} OFFSET ${page}`, (err, result) => {
      cb(result)
    })
  },

  getEngineerModelById: (id, cb) => {
    db.query(`SELECT engineer.id, id_user, nama, jobdesc, lokasi, status, deskripsi, skill, phone, user_email FROM engineer JOIN user ON engineer.id_user = user.id WHERE id_user=${id}`, (err, result) => {
      cb(result)
    })
  },

  createEgineerModel: (setData) => {
    return new Promise((resolve, reject) => {
      let sql = `INSERT INTO engineer SET?`
      db.query(sql, setData, (err, result) => {
        if(!err) {
          resolve(result)
        } else {
          reject(new Error(err))
        } 
      })
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