const {getAllRecruiterModel, getRecruiterModelById, createRecruiterModel, deleteRecruiterModel, updateRecruiterModel} = require('../models/recruiter')

module.exports = {
  getAll: (req, res) => {
    getAllRecruiterModel(result => {
      res.send({message: result});
    })
  },

  getRecruiterById: (req, res) => {
    const id = req.params.id
    getRecruiterModelById(id, result => {
      if(result.length) {
        res.send({result});
      } else {
        res.send({message: `Data tidak ditemukan`});
      }
    })
  },

  createRecruiter: (req, res) => {
    let {nama, bidang, lokasi, deskripsi, email, kontak, jabatan} = req.body
    createRecruiterModel([nama, bidang, lokasi, deskripsi, email, kontak, jabatan], result => {
      return res.send({message: `Data berhasil ditambahkan`});
    })
  },

  deleteRecruiter: (req, res) => {
    let id = req.params.id
    deleteRecruiterModel(id, result => {
      if(result.affectedRows) {
        res.send({message: `Data di id ${id} telah dihapus`});
      } else {
        res.send({message: `Data tidak ditemukan`});
      }
    })
  },

  updateRecruiter: (req, res ) => {
    const id = req.params.id
    const {nama, bidang, lokasi, deskripsi, email, kontak, jabatan} = req.body
    updateRecruiterModel([nama, bidang, lokasi, deskripsi, email, kontak, jabatan], id, result => {
      if(result.affectedRows) {
        res.send(({message: `Data di id ${id} berhasil dirubah`}));
      }else {
        res.send({messagse: `Data tidak ditemukan`});
      }
    })
  }
}