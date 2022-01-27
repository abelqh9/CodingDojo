from flask_app import app
from flask import redirect, render_template, request
from flask_app.config.mysqlconnection import connectToMySQL

# TEMPLATES RENDERING
@app.route("/users")
def users_Template():
    query = "SELECT * FROM users"

    users = connectToMySQL("usuarios").query_db(query)

    return render_template("users.html", users = users)

@app.route("/users/new")
def newUser_Template():
    return render_template("newUser.html")

@app.route("/users/<userId>")
def seeProfile(userId):
    query = "SELECT * FROM users WHERE users.id = %(userIdData)s"
    data = {"userIdData": int(userId)}
    user_data = connectToMySQL("usuarios").query_db(query, data)
    return render_template("user_profile.html", user_data = user_data)

@app.route("/users/<userId>/edit")
def editProfile(userId):
    query = "SELECT * FROM users WHERE users.id = %(userIdData)s"
    data = {"userIdData": int(userId)}
    user_data = connectToMySQL("usuarios").query_db(query, data)
    return render_template("edit_user.html", user_data = user_data)

# PROCESSES
@app.route("/users/new/process", methods=["POST"])
def newUser_process():
    query = "INSERT INTO users (first_name, last_name, email, created_at, updated_at) VALUES (%(fName)s, %(lName)s, %(email)s, NOW(), NOW())"
    data = {
        "fName": request.form["fName"],
        "lName": request.form["lName"],
        "email": request.form["email"]
    }

    connectToMySQL("usuarios").query_db(query, data)
    return redirect("/users")

@app.route("/users/<userId>/edit/process", methods=["POST"])
def editUser_process(userId):
    query = "UPDATE users SET first_name = %(fName)s, last_name = %(lName)s, email = %(email)s, updated_at = NOW() WHERE id = %(userIdData)s"
    data = {
        "userIdData": int(userId),
        "fName": request.form["fName"],
        "lName": request.form["lName"],
        "email": request.form["email"],
    }

    connectToMySQL("usuarios").query_db(query, data)
    return redirect("/users")

@app.route("/users/<userId>/delete", methods=["POST"])
def deleteUser_process(userId):
    query = "DELETE FROM users WHERE id = %(userIdData)s"
    data = { "userIdData": int(userId) }

    connectToMySQL("usuarios").query_db(query, data)
    return redirect("/users")