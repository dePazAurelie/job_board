var express = require("express");
var app     = express();
var path    = require("path");
var sqlite3 = require('sqlite3').verbose();

app.listen(8080);
console.log("Running at Port 8080");

var db = new sqlite3.Database('../data.db', sqlite3.OPEN_READWRITE,  (err) => {
  if (err) {
    return console.error(err.message);
  }
  console.log('Connected to the MyJob SQlite database.');
});

app.get('/',function(req,res){
  res.sendFile(path.join(__dirname +'/index.html'));
  //app.use("/images", express.static(__dirname + '/images'));
  app.use("/js", express.static(__dirname + '/js'));
  app.use("/css", express.static(__dirname + '/css'));
});

app.get('/advertisements', function (req, res) {
    db.all("SELECT * FROM advertisements" , function (err, data) {
        res.end( JSON.stringify(data));
    });
});



// packages
/*const http = require('http');
const fs = require('fs');
// server properties
const hostname = '127.0.0.1';
const port = 3000;
const timer = 300;

//should trigger atualize function every timer parameter
let htmlfile = '';
let cssfile = '';
let jsfile = '';

read();

function read()
{
   fs.readFile('./index.html', function (err, html) {
    if (err) {
      throw err; 
    }       
    htmlfile = html;
  });

   fs.readFile('./style.css', function (err, html) {
    if (err) {
      throw err; 
    }       
    cssfile = html;
  });

  // should read js file from the disk
  fs.readFile('./jobBoard.js', function (err, html) {
    if (err) {
      throw err; 
    }       
    jsfile = html;
  });
}


const server = http.createServer((req, res) => {
  res.statusCode = 200;

  // should send css and js
  if(req.url.indexOf('.css') != -1){ //req.url has the pathname, check if it conatins '.js'
   res.writeHead(200, {'Content-Type': 'text/css'});
   res.write(cssfile);
   res.end();
   return;
  }
  if(req.url.indexOf('.js') != -1){ //req.url has the pathname, check if it conatins '.js'
   res.writeHead(200, {'Content-Type': 'text/javascript'});
   res.write(jsfile);
   res.end();
   return;
  }
  // should send html file via request
  res.writeHeader(200, {"Content-Type": "text/html"});  
  res.write(htmlfile);
  res.end();
});

// should send css and js 

server.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
});*/