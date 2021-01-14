const express = require('express');
const recruiterController = require('../controller/recruiter')
const router = express.Router();
const auth = require('../../middleware/auth')

// localhost:8080/
router.get('/recruiters', auth.authorization, recruiterController.getAll)
router.get('/recruiter/:id', recruiterController.getRecruiterById)
router.post('/recruiter',  recruiterController.createRecruiter)
router.delete('/recruiter/:id', auth.authorization, recruiterController.deleteRecruiter)
router.put('/recruiter/:id', auth.authorization, recruiterController.updateRecruiter)

module.exports = router