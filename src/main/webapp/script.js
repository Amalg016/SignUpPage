/**
 * 
 */

let jsonData;
let url="http://localhost:8080/SignUpPage/signin"
fetch(url)
    .then(response => response.json())
    .then(data => {
        jsonData = data;
        console.log(jsonData.uname);
    })
    .catch(error => {
        console.error('Error:',error);
    });
    
    
