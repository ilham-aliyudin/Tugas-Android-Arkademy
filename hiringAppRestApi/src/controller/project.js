const {createProjectModel, getAllProjectModel} = require('../models/project')

module.exports = {
  createProject: async(req, res) => {
    try {
      const {project_name, description, deadline, image, id_recruiter} = req.body
      const setData = {
        project_name,
        description,
        deadline,
        image: req.file === undefined ? '' : req.file.filename, 
        id_recruiter
      }
      const result = await createProjectModel(setData)
      res.status(200).send({
        status: true,
        message: "Data ditambahkan"
      });
    } catch (error) {
      res.status(403).send({
        status: false,
        message: error.message
      });
    }
  },

  getAllProject: async(req, res) => {
    try {
      const result = await getAllProjectModel()
      if(result.length) {
        res.status(200).send({
          status: true,
          message: result
        });
      } else {
        res.status(404).send({
          status: false,
          message: 'Data tidak ditemukan'
        });
      }
    } catch(error) {
      res.status(403).send({
        status: false,
        message: error.message
      });
    }
  }
}

