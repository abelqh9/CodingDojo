from recetas_app import app
from recetas_app.models.user import User
from recetas_app.models.recipe import Recipe 
from flask import render_template, request, redirect, session, flash, jsonify

# TEMPLATES RENDERING
@app.route("/")
def index():
    print("/", session)
    # session.clear()
    if "user_id" in session:
        return redirect("/dashboard")
    else:
        return render_template("index.html")

@app.route("/dashboard")
def dashboard():
    print("dashboard", session)
    if "user_id" in session:
        user_data = {"user_id": session["user_id"]}
        return render_template(
            "dashboard.html",
            user = User.get_user(user_data),
            recipes = Recipe.get_all_recipes_for_user(user_data)
        )
    else:
        return redirect("/")

# PROCESSES
@app.route("/register", methods=["POST"])
def register():
    is_valid = True
    errors = []
    form_data = {
        "first_name": request.form["first_name"].strip(),
        "last_name": request.form["last_name"].strip(),
        "email": request.form["email"].strip(),
        "password": request.form["password"].strip(),
        "confirm_password": request.form["confirm_password"].strip()
    }
    if not User.first_name_is_valid(form_data):
        errors.append("Your first name must be at least 2 characters.")
        is_valid = False
    if not User.last_name_is_valid(form_data):
        errors.append("Your last name must be at least 2 characters.")
        is_valid = False
    if not User.email_is_valid(form_data):
        errors.append("The email must be in email format.")
        is_valid = False
    if User.email_exist(form_data):
        errors.append("The email alredy exist.")
        is_valid = False
    if not User.password_is_valid(form_data):
        errors.append("The password must be at least 8 characters (minimum 1 number and 1 capital letter).")
        is_valid = False
    if not form_data['password'] == form_data['confirm_password']:
        errors.append("Passwords are not the same.")
        is_valid = False

    if is_valid:
        password_hash = User.create_password(form_data)
        user_id = User.add_user({
            "first_name": form_data["first_name"],
            "last_name": form_data["last_name"],
            "email": form_data["email"],
            "password": password_hash
        })
        session['user_id'] = user_id
        # return redirect("/dashboard")
    
    json_data = jsonify(errors = errors)
    json_data.headers.add('Access-Control-Allow-Origin', '*')
    return json_data

@app.route("/login", methods=["POST"])
def login():
    is_valid = True
    errors = []
    form_data = {
        "email": request.form["email"].strip(),
        "password": request.form["password"].strip()
    }
    if not User.email_exist(form_data):
        errors.append("The email does not exist.")
        is_valid = False
    elif not User.password_is_correct(form_data):
        errors.append("Incorrect password.")
        is_valid = False

    if is_valid:
        session['user_id'] = User.get_user_id_by_email(form_data)

    json_data = jsonify(errors = errors)
    json_data.headers.add('Access-Control-Allow-Origin', '*')
    return json_data

@app.route("/logout", methods=["POST"])
def logout():
    print("Adfalsfmaskodnfkojsdnfioksdfni")
    session.clear()
    return redirect("/")