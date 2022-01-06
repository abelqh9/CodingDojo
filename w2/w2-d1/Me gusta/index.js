let likes = {
    neil: 9,
    nichole: 12,
    jim: 9
}

document.addEventListener("click", e =>{
    if (e.target.hasAttribute("data-userName")) {
        let userName = e.target.getAttribute("data-userName"),
        userCounter = document.getElementById(userName)
        
        likes[userName]+=1
        userCounter.textContent = `${likes[userName]} likes(s)`;
    }
})