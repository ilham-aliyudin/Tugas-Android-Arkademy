const jwt = require('jsonwebtoken')
require('dotenv').config()

module.exports = {
  authorization: (req, res, next) => {
    let token = req.headers.authorization
    if(token) {
      token = token.split(' ')[1]
      jwt.verify(token, process.env.JWT_KEY, (err, result) => {
        if((err && err.name === 'JsonWebTokenError') || (err && err.name === 'JsonExpiredError' )) {
          res.status(403).send({
            status: false,
            message: err.message
          });
        } else {
          req.token = result
          next()
        }
      })
    } else {
      res.status(400).send({
        status: false,
        message: 'Please login first'
      });
    }
  }
}

