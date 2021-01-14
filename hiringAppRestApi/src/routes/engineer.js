const express = require('express');
const engineerController = require('../controller/engineer')
const router = express.Router();
const auth = require('../../middleware/auth')

router.get('/engineers', engineerController.getAll)
router.get('/engineer/:id', engineerController.getEngineerById)
router.get('/engineer',auth.authorization, engineerController.getEngineerByParam )
router.post('/engineer/register', engineerController.crateEngineer)
router.delete('/engineer/:id', auth.authorization, engineerController.deleteEngineer)
router.put('/engineer/:id', auth.authorization, engineerController.updateEngineer)

module.exports = router
