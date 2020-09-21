const{getAllEngineerModel, 
  getEngineerModelById, 
  createEgineerModel, 
  deleteEngineerModel, 
  updateEngineerModel,
  getEngineerModelByParams,
  sortEngineerModelByName} = require('../models/engineer')
const baseDate = require('../config/date');
const { getAll } = require('./recruiter');

module.exports = {
  getAll: (req, res) => {
    getAllEngineerModel(result => {
      if(result.length) {
        res.send({data: result});
      }else{
        res.send({message: `Data tidak ditemukan`});
      }  
    })
  },

  getEngineerById: (req, res) => {
    const id = req.params.id
    getEngineerModelById(id, result => {
      if(result.length){
        res.send({data: result}); 
      } else {
        res.send({message: `Id tidak ditemukan`});
      }
      
    })
  },

  crateEngineer: (req, res) => {
    const {nama, jobdesc, lokasi, status, deskripsi, skill} = req.body
    const entity = req.body
    baseDate(req, entity)
    createEgineerModel([nama, jobdesc, lokasi, status, deskripsi, skill], result => {
      res.send({message: `Data ditambahkan`, entity});
    })
  },

  deleteEngineer: (req, res) => {
    const id = req.params.id
    deleteEngineerModel(id, result => {
      if(result.affectedRows) {
        res.send({message: `Data di id ${id} dihapus`});
      } else {
        res.status(404).send({message: `Data tidak ditemukan`});
      }
    })
  },

  updateEngineer: (req, res) => {
    const id = req.params.id
    const {nama, jobdesc, lokasi, status, deskripsi, skill} = req.body
    const entity = req.body
    baseDate(req, entity)
    updateEngineerModel([nama, jobdesc, lokasi, status, deskripsi, skill], id, result => {
      if(result.affectedRows) {
        res.send({message: `Data di id ${id} berhasil diupdate`, entity});
      } else {
        res.send({message: `Data tidak ditemukan`});
      }
    })
  },

  getEngineerByParam: (req, res) => {
    let param = req.query
    let paramKey = ''
    let paramValue = ''

    if(typeof param == 'object') {
      paramKey = Object.keys(param)[0]
      paramValue = Object.values(param)[0]
    } else {
      paramKey = 'nama'
      paramValue = param || ''

    }

    getEngineerModelByParams(paramKey, paramValue,  result => {
      if(result.length) {
        res.send({data: result});
      } else {
        res.send({message: `Data tidak ditemukan`});
      }
    })
  }
}