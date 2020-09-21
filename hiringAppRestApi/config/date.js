module.exports = (req, entity) => {
  const date = new Date()

  if(req.method === 'POST') {
    entity['createdAt'] = date
    entity['updatedAt'] = date
  }

  if(req.method === 'PUT' ) {
    entity['updatedAt'] = date
  }
}