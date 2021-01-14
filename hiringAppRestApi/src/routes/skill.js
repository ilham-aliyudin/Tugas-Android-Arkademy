const express = require('express');
const skillController = require('../controller/skill')
const router = express.Router();

router.post('/skill', skillController.postSkill)
router.get('/skills', skillController.getAllSkill)
router.put('/skill/:id', skillController.updateSkill)
router.delete('/skill/:id', skillController.deleteSkill)

module.exports = router