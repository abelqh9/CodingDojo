let authBtn = document.getElementById("authBtn"),
addDefinitionBtn = document.getElementById("addDefinitionBtn")


document.addEventListener("click", (e)=>{
    if (e.target === authBtn) {
        authBtn.textContent = authBtn.textContent==="Login"?"Logout":"Login"
    }

    if (e.target === addDefinitionBtn) {
        addDefinitionBtn.classList.add("visibility-h") 
    }

    if (e.target.classList.contains("wordCont-btn")){
        alert("Ninja was liked")
    }
})