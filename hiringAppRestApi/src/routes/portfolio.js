const express = require('express');
const portfolioController = require('../controller/portfolio')
const router = express.Router()
const uploadImage = require('../../middleware/multer')


router.post('/portfolio', uploadImage, portfolioController.postPortfolio)
router.get('/portfolios', portfolioController.getAllPortfolio )
router.put('/portfolio/:id', uploadImage, portfolioController.updatePortfolio)
router.delete('/portfolio/:id', portfolioController.deletePortfolio)
router.get('/portfolio/:id', portfolioController.getPortfolioByIdEngineer)


module.exports = router