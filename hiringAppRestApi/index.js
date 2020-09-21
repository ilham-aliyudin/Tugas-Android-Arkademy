const express = require('express');
const bodyParser = require('body-parser')
const routeRecruiter = require('./routes/recruiter')
const routeEngineer = require('./routes/engineer')
const app = express()

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

app.use('/hire', routeRecruiter, routeEngineer);

app.listen(8000, () => {
  console.log(`Server started on port`);
});


