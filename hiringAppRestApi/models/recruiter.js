const db = require('../config/db')


module.exports = {
  getAllRecruiterModel: (cb) => {
    let sql = `SELECT * FROM recruiter`
    db.query(sql, (err, result) => {
      cb(result)
    })
  },

  getRecruiterModelById: (id, cb) => {
    db.query(`SELECT * FROM recruiter WHERE id=${id}`, (err, result, next) => {
       cb(result)
    })
  },

  createRecruiterModel: (arr, cb) => {
    const sql = `INSERT INTO recruiter (nama, bidang, lokasi, deskripsi, email, kontak, jabatan) VALUES ('${arr[0]}', '${arr[1]}', '${arr[2]}', '${arr[3]}', '${arr[4]}', '${arr[5]}', '${arr[6]}')`
    db.query(sql, (err, result) => {
      cb(result)
    })
  },

  deleteRecruiterModel: (id, cb) => {
  db.query(`DELETE FROM recruiter WHERE id=${id}`, (err, result) => {
    cb(result)
  })
  },

  updateRecruiterModel: (arr, id, cb) => {
    db.query(`UPDATE recruiter SET nama = '${arr[0]}', bidang='${arr[1]}', lokasi='${arr[2]}', deskripsi='${arr[3]}', email='${arr[4]}', kontak='${arr[5]}', jabatan='${arr[6]}' WHERE id=${id}`, (err, result) => {
      if (err) throw err
      cb(result)
    })
  },

  patchREcruiterModel: (id, cb) => {
    db.query(``)
  }
}
