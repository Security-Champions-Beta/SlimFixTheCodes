var express = require('express');
var safe = require('safe-regex');
var vm = require("vm");
var util = require("util");
var app = express();

function validateName(name){
  return /^([a-zA-Z0-9]+\s?)+$/.test(name)
}

// name = 'nbdnbasdnasdbasbdasdbhasgd4545624654*'
app.get('/', function(req, res){
    var name = req.query.name;    
    let validated = validateName(name)
    if (validated){
      res.send({"name":name});
    }
});

app.get('/test', function(req, res){
  var regex = '^([a-zA-Z0-9]+\s?)+$';   
  res.send({"safe":safe(regex)});
});

app.get("/timeout", function(req, res) {
  var name = req.query.name;
  var matchObject = {
    regex: /^([a-zA-Z0-9]+\s?)+$/,
    string: name,
    result: null,
  }
  var context = vm.createContext(matchObject);
  console.log("Sandbox has been initialized: " + vm.isContext(matchObject));
  var sandboxScript = new vm.Script("result = regex.test(string);");
  try {
    sandboxScript.runInContext(context, { timeout: 10000 });
  } catch(e) {
    console.log("ReDOS can happen", e)
    res.status(400).send({
      "error": "failed input validation because of timeout"
    })
  }
  if (context.result == true) {
    res.send({
      "success": "input validation is successful"
    })
  } else {
    res.status(400).send({
      "error": "unable to validate input"
    })
  }
  
})

app.listen(6000);
console.log("Server started at port 5000");