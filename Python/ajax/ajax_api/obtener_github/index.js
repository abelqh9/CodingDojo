btn = document.getElementById("principal_button")

btn.addEventListener("click", e=>{
    // console.log(6565675);
    fetch("https://api.github.com/users/abelqh9")
    .then(res => res.json())
    .then(res =>
        btn.insertAdjacentHTML("afterend", `
            <h1>${res.name} has ${res.followers} followers</h1>
            <img src="https://avatars.githubusercontent.com/u/79228339?v=4" alt="avatar img">
        `)
    )
})
