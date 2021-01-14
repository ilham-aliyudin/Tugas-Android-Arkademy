const db = require('../../config/db')


module.exports = {
  getAllRecruiterModel: (cb) => {
    let sql = `SELECT * FROM recruiter`
    db.query(sql, (err, result) => {
      cb(result)
    })
  },

  getRecruiterModelById: (id, cb) => {
    db.query(`SELECT recruiter.id, id_user, user_name, user_email, nama, bidang, lokasi, deskripsi, kontak, jabatan, linked_in FROM recruiter JOIN user ON id_user = user.id AND recruiter.id=${id}`, (err, result, next) => {
      cb(result)
    })
  },

  createRecruiterModel: (setData) => {
    return new Promise((resolve, reject) => {
      const query = 'INSERT INTO recruiter SET ?'
      db.query(query, setData, (err, result) => {
        if (!err) {
          resolve(result)
        } else {
          reject(new Error(err))
        }
      })
    })
  },

  deleteRecruiterModel: (id, cb) => {
    db.query(`DELETE FROM recruiter WHERE id=${id}`, (err, result) => {
      cb(result)
    })
  },

  updateRecruiterModel: (setData, id) => {
    return new Promise((resolve, reject) => {
      const query = `UPDATE recruiter SET ? WHERE id = ${id}`
      db.query(query, setData, (err, result) => {
        if(!err) {
          resolve(result)
        } else {
          reject(new Error(err))
        }
      })
    })
  }
}