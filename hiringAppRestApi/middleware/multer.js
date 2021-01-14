const multer = require('multer')


const storage = multer.diskStorage({
  destination: (req, file, cb) => {
    cb(null, './upload')
  },

  filename: (req, file, cb) => {
    cb(null, file.fieldname + '-' + Date.now() + '-' + file.originalname)
  }
})

const fileFilter = (req, file, cb) => {
  if (file.mimetype === 'image/jpeg' || file.mimetype === 'image/png') {
    cb(null, true)
  } else {
    return cb(new Error('Gambar harus berupad JPEG atau PNG'), false)
  }
}

const limits = {filesizes: 1024*1024*1}

let upload = multer({storage, fileFilter, limits}).single('image')

const uploadFilter = (req, res, next) => {
  upload(req, res, err => {
    if (err instanceof multer.MulterError) {
      res.status(400).send({
        status: false,
        message: err.message
      });
    } else if (err) {
      res.status(400).send({
        status: false,
        message: err.message
      });
    }
    next()
  })
}

module.exports = uploadFilter