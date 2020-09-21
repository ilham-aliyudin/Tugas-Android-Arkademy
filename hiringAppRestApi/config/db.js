const mysql = require('mysql')

const conn = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: '',
  database: 'db_hiring_app'
})

conn.connect((err) => { 
  if (!err) {
    console.log('Database Terkoneksi') 
  } else {
    console.log('Database Gagal Terkoneksi')
  }
})

module.exports = conn