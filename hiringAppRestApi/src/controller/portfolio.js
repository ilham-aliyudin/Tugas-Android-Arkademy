const {postPortfolioModel, getAllPortfolioModel, deletePortfolioModel, updatePortfolioModel, getPortfolioByIdEngineerModel} = require('../models/portfolio')

module.exports = {
  postPortfolio: async(req, res) => {
    try {
      const {nama_app, link_github, deskripsi} = req.body
      const setData = {
        nama_app,
        link_github,
        deskripsi,
        image: req.file === undefined ? '' : req.file.filename
    }
    const result = await postPortfolioModel(setData)
    res.status(200).send({
      status: true,
      message: 'Gambar ditambahkan'
    });
    } catch (error) { 
      res.status(403).send({
        status: false,
        message: error.message
      });
    }
  },

  getAllPortfolio: async(req, res) => {
    try {
      const result = await getAllPortfolioModel()
      if(result.length) {
        res.status(200).send({
          result
        });
      }
      res.status(404).send({
        message: 'Data Kosong'
      });
    } catch (error) {
      res.send({
        message: error.message
      });
    }
  },

  deletePortfolio: async(req, res) => {
    const id = req.params.id
    try {
      const result = await deletePortfolioModel(id)
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

  updatePortfolio: async(req, res) => {
    const id = req.params.id
    const {nama_app, link_github, deskripsi} = req.body
    const setData = {
      nama_app,
        link_github,
        deskripsi,
        image: req.file === undefined ? '' : req.file.filename
    }
    try {
      const result = await updatePortfolioModel(setData, id)
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
  },

  getPortfolioByIdEngineer: async(req, res) => {
    try {
      const id = req.params.id
      const result = await getPortfolioByIdEngineerModel(id)
      if (result.length) {
        res.status(200).send({
          status: true,
          data: result
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
  }
}