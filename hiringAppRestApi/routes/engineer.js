const express = require('express');
const engineerController = require('../controller/engineer')
const router = express.Router();

router.get('/engineers', engineerController.getAll)
router.get('/engineer/:id', engineerController.getEngineerById)
router.get('/engineer', engineerController.getEngineerByParam )
router.post('/engineer/register', engineerController.crateEngineer)
router.delete('/engineer/:id', engineerController.deleteEngineer)
router.put('/engineer/:id', engineerController.updateEngineer)

module.exports = router
