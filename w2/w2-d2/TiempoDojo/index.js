let cookiesAlertTag = document.querySelector(".cookiesAlert"),
temperatureSelectTag = document.getElementById("temperatureSelect"),
dayCards = document.querySelectorAll(".dayCard")

document.addEventListener("click", e =>{
    if (e.target.matches("nav li")) {
        alert("Loading weather report...")
    }
    if (e.target.matches(".cookiesAlert button")) {
        cookiesAlertTag.classList.add("dNone")
    }
})

temperatureSelectTag.addEventListener("change", e=>{
    dayCards.forEach(card=>{
        let maxTempTag = card.children[3].children[0],
        minTempTag = card.children[3].children[1],
        maxTempNum = Number(maxTempTag.textContent.slice(0,-1)),
        minTempNum = Number(minTempTag.textContent.slice(0,-1));

        if (e.target.value==="f"){
            maxTempTag.textContent = (Math.round(maxTempNum*(9/5)+32))+"°"
            minTempTag.textContent = (Math.round(minTempNum*(9/5)+32))+"°"
        }
        if (e.target.value==="c"){
            maxTempTag.textContent = (Math.round((maxTempNum-32)/(9/5)))+"°"
            minTempTag.textContent = (Math.round((minTempNum-32)/(9/5)))+"°"
        }
    })
    
})

