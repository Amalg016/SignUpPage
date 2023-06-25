
let jsonData;
let url="http://localhost:8080/SignUpPage/signin"

let NameLabel=document.getElementById("name");
jsonData=document.getElementById("jsonData").value;
console.log(jsonData);
var UserDetails=JSON.parse(jsonData);

NameLabel.textContent=UserDetails.uname;

document.getElementById("editname").value = UserDetails.uname;
document.getElementById("editemail").value = UserDetails.uemail;
document.getElementById("editdob").value = UserDetails.udob;
document.getElementById("editmob").value = UserDetails.umob;


// jsonData='<%= request.getAttribute("jsonData") %>';
// console.log(jsonData);
// var userDetails=JSON.parse(jsonData);
// NameLabel.textContent=userDetails.name;

// fetch(url)
//     .then(response => response.json())
//     .then(data => {
//         jsonData = data;
//         NameLabel.textContent=jsonData;
//     })
//     .catch(error => {
//         console.error('Error:',error);
//     });


    
    
