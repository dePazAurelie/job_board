var express = require("express");

// Créé une nouvelle application grace à express
var app     = express();
var path    = require("path");

//Installe sqlite (je suppose que tu as utilisé sqlite)
var sqlite3 = require('sqlite3').verbose();

//on utilise le port 8080 donc pour te connecter à ton site tu dois entrer l'adresse dans ton navigateur : localhost:8080
app.listen(8080);

//On vérifie qu'on est bien connecté au serveur
console.log("Running at Port 8080");

//On se connecte à la base de données data.db (change le chemin si nécessaire)
var db = new sqlite3.Database('../data.db', sqlite3.OPEN_READWRITE,  (err) => {
  if (err) {
    return console.error(err.message);
  }
  console.log('Connected to the MyJob SQlite database.');
});

//on ajoute à l'application qu'on a créé le html, le css et le js. Vérifie également bien les chemins ici. j'ai été obligé de créer des dossiers /js et /css pour que ça marche. le server.js par contre reste en dehors de ces deux dossiers.
//le '/' signifie que le html est dans le même dossier que server.js
app.get('/',function(req,res){
  res.sendFile(path.join(__dirname +'/index.html'));
  app.use("/js", express.static(__dirname + '/js'));
  app.use("/css", express.static(__dirname + '/css'));
});

//on créé une nouvelle route : localhost:8080/advertisements qui permet d'accéder à la table advertisements de la database et renvoie un JSON. Si tu entre localhost:8080/advertisements dans ton navigateur tu verras la liste des advertisements contenus dans ta table. 
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