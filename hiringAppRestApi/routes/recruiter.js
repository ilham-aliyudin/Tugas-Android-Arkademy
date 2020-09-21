const express = require('express');
const recruiterController = require('../controller/recruiter')
const router = express.Router();

// localhost:8080/
router.get('/recruiters', recruiterController.getAll)
router.get('/recruiter/:id', recruiterController.getRecruiterById)
router.post('/recruiter/register', recruiterController.createRecruiter)
router.delete('/recruiter/:id', recruiterController.deleteRecruiter)
router.put('/recruiter/:id', recruiterController.updateRecruiter)

module.exports = router