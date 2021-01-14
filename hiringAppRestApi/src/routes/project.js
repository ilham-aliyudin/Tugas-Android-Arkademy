const express = require('express');
const projectController = require('../controller/project')
const router = express.Router()
const uploadImage = require('../../middleware/multer')

router.post('/project', uploadImage, projectController.createProject)
router.get('/projects', projectController.getAllProject )

module.exports = router