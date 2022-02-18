
let register_form = document.getElementById("register_form")
let login_form = document.getElementById("login_form")

document.addEventListener("submit", e => {
    e.preventDefault()
    if (e.target === register_form || e.target === login_form){
        let process = e.target === register_form ? "register" : "login"
        fetch(`http://localhost:5000/${process}`, {method: "POST", body: new FormData(e.target)})
        .then( response => response.json() ).then( data => {
            if (data.errors.length>0) {
                let errors_container = document.querySelector(`.${process}_section .errors_container`) 
    
                if (!errors_container) {
                    errors_container = document.createElement("div")
                    errors_container.classList.add("errors_container")
                    e.target.insertAdjacentElement("beforebegin", errors_container)
                }
                else{
                    errors_container.innerHTML = ``
                }
                
                for (const e of data.errors) {
                    let error = document.createElement("p")
                    error.textContent = e 
                    errors_container.appendChild(error)
                }
            }else{
                window.location.replace("http://localhost:5000/dashboard");
            }
        })
    }
})