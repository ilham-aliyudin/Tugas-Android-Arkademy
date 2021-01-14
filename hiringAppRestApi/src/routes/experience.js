const express = require('express');
const experienceController = require('../controller/experience')
const router = express.Router()


router.post('/experience', experienceController.postExperience)
router.get('/experiences', experienceController.getAllExperience)
router.delete('/experience/:id', experienceController.deleteExperience)
router.put('/experience/:id', experienceController.updateExperience)


module.exports = router