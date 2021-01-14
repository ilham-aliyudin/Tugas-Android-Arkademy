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

  createRecruiter: async(req, res) => {
    let {id_user, nama, lokasi, bidang, deskripsi, kontak, jabatan, linked_in} = req.body
    const setData ={id_user, nama, lokasi, bidang, deskripsi, kontak, jabatan, linked_in}
    try {
      const result = await createRecruiterModel(setData)
      if (result) {
        res.status(200).send({
          status: true,
          message: 'Data Berhasil Ditambahkan',
          data: req.body
        });
      } else {
        res.status(403).send({
          status: false,
        });
      }
    } catch(error){
      res.send({status: false, message: error});
    }
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

  updateRecruiter: async(req, res ) => {
    const id = req.params.id
    const {id_user, nama, lokasi, bidang, deskripsi, kontak, jabatan, linked_in} = req.body
    const setData ={id_user, nama, lokasi, bidang, deskripsi, kontak, jabatan, linked_in}
    try{
      const result = await updateRecruiterModel(setData, id)
      res.send({status: true, message:`Berhasil di update`});
    } catch (error) {
      res.send({status: false, message: error.message});
    }
  }
}