from inicio_sesion_y_registro_app import app
from inicio_sesion_y_registro_app.models.user import User
from flask import render_template, request, redirect, session, flash

# TEMPLATES RENDERING 
@app.route("/")
def index():
    # print(session)
    # print("--------------------holaaa1-----------")
    if "user_id" in session:
        return redirect("/dashboard")
    else:
        # print("--------------------holaaa2-----------")
        return render_template("index.html")

@app.route("/dashboard")
def dashboard():
    # print("--------------------holaaa3-----------")
    if "user_id" in session:
        return render_template("dashboard.html", user = User.get_user({"id": session["user_id"]}))
    else:
        return redirect("/")

# PROCESSES
@app.route("/register", methods=["POST"])
def register():
    is_valid = True
    form_data = {
        "first_name": request.form["first_name"].strip(),
        "last_name": request.form["last_name"].strip(),
        "email": request.form["email"].strip(),
        "password": request.form["password"].strip(),
        "confirm_password": request.form["confirm_password"].strip()
    }
    if not User.first_name_is_valid(form_data):
        flash("Your first name must be at least 2 characters.", "register_error")
        is_valid = False
    if not User.last_name_is_valid(form_data):
        flash("Your last name must be at least 2 characters.", "register_error")
        is_valid = False
    if not User.email_is_valid(form_data):
        flash("The email must be in email format.", "register_error")
        is_valid = False
    if User.email_exist(form_data):
        flash("The email alredy exist.", "register_error")
        is_valid = False
    if not User.password_is_valid(form_data):
        flash("The password must be at least 8 characters (minimum 1 number and 1 capital letter).", "register_error")
        is_valid = False
    if not form_data['password'] == form_data['confirm_password']:
        flash("Passwords are not the same", "register_error")
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
        return redirect("/dashboard")
    else:
        return redirect("/")

@app.route("/login", methods=["POST"])
def login():
    is_valid = True
    form_data = {
        "email": request.form["email"].strip(),
        "password": request.form["password"].strip()
    }
    if not User.email_exist(form_data):
        flash("The email does not exist.", "login_error")
        is_valid = False
    elif not User.password_is_correct(form_data):
        flash("Incorrect password.", "login_error")
        is_valid = False
    if is_valid:
        session['user_id'] = User.get_user_id_by_email(form_data)
        return redirect("/dashboard")
    else:
        return redirect("/")

@app.route("/logout", methods=["POST"])
def logout():
    session.clear()
    return redirect("/")