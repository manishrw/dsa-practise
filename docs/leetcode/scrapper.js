require('dotenv').config();
var path = require('path');
var fs = require('fs');

var fileName = process.env.FILE_NAME || 'google_30d_dec2024.json';
var filePath = path.join(__dirname, '.dump/' + fileName);
console.log('filePath:', filePath);

var data = fs.readFileSync(filePath, 'utf8');
var json = JSON.parse(data);
console.log('json:', json);

json.data.favoriteQuestionList.questions.forEach(function (item) {
    console.log("Difficulty:", item.difficulty, "Question:", item.questionFrontendId, item.title);
});