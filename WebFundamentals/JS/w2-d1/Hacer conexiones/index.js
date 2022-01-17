let connectionRequests = 2,
yourConnections = 418

let conectionRequestsCounter = document.getElementById("conectionRequestsCounter"),
yourConnectionsCounter = document.getElementById("yourConnectionsCounter"),
userNameTag = document.getElementById("userName"); 

document.addEventListener("click", e=>{
    if (e.target.getAttribute("data-function")==="acceptUser") {
        e.target.closest(".user").classList.add("dNone")
        conectionRequestsCounter.textContent = --connectionRequests
        yourConnectionsCounter.textContent = ++yourConnections
    }

    if (e.target.getAttribute("data-function")==="rejectUser") {
        e.target.closest(".user").classList.add("dNone")
        conectionRequestsCounter.textContent = --connectionRequests
    }
    
    if (e.target === document.getElementById("editProfileBtn")) {
        userNameTag.textContent = userNameTag.textContent==="Jane Doe"
        ?"Abel Quezada":"Jane Doe"
    }
})