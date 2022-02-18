document.addEventListener("submit", e => {
    let add_recipe_form = document.getElementById("add_recipe_form"),
    recipes_container = document.getElementById("recipes_container"),
    delete_forms = Array.from(document.querySelectorAll(".delete_form"))

    if (e.target === add_recipe_form){
        e.preventDefault()
        fetch(`http://localhost:5000/recipes/new`, {method: "POST", body: new FormData(e.target)})
        .then( response => response.json() ).then( data => {
            if (!data.ok) {
                let errors_container = document.querySelector(`.add_recipes_section .errors_container`) 
    
                if (!errors_container) {
                    errors_container = document.createElement("div")
                    errors_container.classList.add("errors_container")
                    add_recipe_form.insertAdjacentElement("beforebegin", errors_container)
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
                recipes_container.innerHTML +=  `
                    <tr>
                        <td>${add_recipe_form.name.value}</td>
                        <td>${add_recipe_form.under_30_minutes.value?"True":"False"}</td>
                        <td class="actions_td">
                            <a href="/recipes/${data.recipe_id}">view instructions</a>
                            <a href="/recipes/${data.recipe_id}">edit</a>
                            <form class="delete_form" method="post">
                                <input type="hidden" name="recipe_id" value=${data.recipe_id}>
                                <input class="link_style" type="submit" value="delete">
                            </form>
                        </td>
                    </tr>
                `
            }
        })
    }

    if (delete_forms.includes(e.target)){
        e.preventDefault()
        fetch(`http://localhost:5000/recipes/delete`, {method: "POST", body: new FormData(e.target)})
        .then( data => {
            e.target.closest("tr").remove()
        })
    }
})