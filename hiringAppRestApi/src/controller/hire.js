const {getAllHireModels, getHireByIdEngineerModel} = require('../models/hire')

module.exports = {
  getAllHire: async(req, res) => {
    try {
      const result = await getAllHireModels()
      if (result.length) {
        res.status(200).send({
          status: true,
          data: result
        });
      } else {
        res.status(404).send({
          message: 'Data tidak ditemukan'
        });
      }
    } catch (error) {
      res.status(404).send({
        message: error.message
      });
    }
  },

  getHireByIdEngineer: async(req, res) => {
    const id = req.params.id
    try {
      const result = await getHireByIdEngineerModel(id)
      if (result.length) {
        res.status(200).send({
          status: true,
          data: result
        });
      } else {
        res.status(404).send({
          message: 'Data tidak ditemukan'
        });
      }
    } catch (error) {
      res.status(404).send({
        message: error.message
      });
    }
  }
}
