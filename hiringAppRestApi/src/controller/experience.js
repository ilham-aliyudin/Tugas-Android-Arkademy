const {postExperienceModel, getAllExperienceModel, deleteExperienceModel, updateExperienceModel} = require('../models/experience')

module.exports = {
  postExperience: async(req, res) => {
    const {company_name, position, start_periode, end_periode, description} = req.body
    const setData = {
      company_name,
      position, 
      start_periode,
      end_periode,
      description
    }
    try {
      const result = await postExperienceModel(setData)
      res.status(200).send({
        status: true,
        message: 'Berhasil ditambahkan'
      });;
    } catch (error) {
      res.status(403).send({
        status: false,
        message: error.message
      });
    }
  },

  getAllExperience: async(req, res) => {
    try {
      const result = await getAllExperienceModel()
      if (result.length) {
        res.status(200).send({
          status: true,
          data: result
        });
      }
    } catch (error) {
      res.status(404).send({
        status: false,
        message: 'Data Kosong'
      });
    }
  },

  deleteExperience: async(req, res) => {
    const id = req.params.id
    try {
      const result = await deleteExperienceModel(id)
      if(result.affectedRows) {
        res.status(200).send({
          status: true,
          message: `Data di id ${id} telah dihapus`
        });
      } else {
        res.status(404).send({
          status: false,
          message: `Data tidak ditemukan`
        });
      }
    } catch (error) {
      res.status(403).send({
        status: false,
        message: error.message
      });
    }
  },

  updateExperience: async(req, res) => {
    const id = req.params.id
    const {company_name, position, start_periode, end_periode, description} = req.body
    const setData = {
      company_name,
      position, 
      start_periode,
      end_periode,
      description
    }
    try {
      const result = await updateExperienceModel(setData, id)
      if(result.affectedRows) {
        res.status(200).send({
          status: true,
          message: 'Berhasil diupdate'
        });;
      } else {
        res.status(404).send({
          status: false,
          message: `Data tidak ditemukan`
        });
      }
    } catch (error) {
      res.status(403).send({
        status: false,
        message: error.message
      });
    }
  }
}