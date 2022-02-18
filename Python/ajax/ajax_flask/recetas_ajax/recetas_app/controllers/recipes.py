from recetas_app import app
from recetas_app.models.recipe import Recipe
from recetas_app.models.user import User
from flask import render_template, request, redirect, session, flash, jsonify

# TEMPLATES RENDERING
@app.route("/recipes/<recipe_id>")
def show_recipe(recipe_id):
    if "user_id" in session:
        user_data = { "user_id": session["user_id"] }
        return render_template(
            "show_recipe.html",
            recipe = Recipe.get_all_recipes_from_user(user_data),
            user = User.get_user(user_data)
        )
    else:
        return redirect("/")

# PROCESSES
@app.route("/recipes/new", methods=["POST"])
def new_recipe_process():
    if "user_id" in session:
        is_valid = True
        errors = []
        recipe_id = 0
        print(request.form)
        data = {
            "name": request.form["name"].strip(),
            "description": request.form["description"].strip(),
            "instructions": request.form["instructions"].strip(),
            "date_made_on": request.form["created_at"],
            "under_30_minutes": int(request.form["under_30_minutes"]),
            "user_id": session["user_id"]
        }

        if not Recipe.at_least_3_characters(data["name"]):
            errors.append("The name content should be at least 3 characters long")
            is_valid = False
        if not Recipe.at_least_3_characters(data["description"]):
            errors.append("The description content should be at least 3 characters long")
            is_valid = False
        if not Recipe.at_least_3_characters(data["instructions"]):
            errors.append("The instructions content should be at least 3 characters long")
            is_valid = False

        if is_valid:
            recipe_id = Recipe.add_recipe(data)

        json_data = jsonify(ok = is_valid, errors = errors, recipe_id = recipe_id)
        json_data.headers.add('Access-Control-Allow-Origin', '*')
        return json_data
    else:
        return redirect("/")

@app.route("/recipes/delete", methods=["POST"])
def delete():
    if "user_id" in session:
        recipe_id = {
            "recipe_id": request.form["recipe_id"],
        }
        Recipe.delete_recipe(recipe_id)

        json_data = jsonify(ok = True)
        json_data.headers.add('Access-Control-Allow-Origin', '*')
        return json_data
    else:
        return redirect("/")