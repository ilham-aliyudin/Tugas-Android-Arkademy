const express = require('express');
const hireController = require('../controller/hire')
const router = express.Router();

router.get('/hiring', hireController.getAllHire)
router.get('/hiring/:id', hireController.getHireByIdEngineer)

module.exports = router