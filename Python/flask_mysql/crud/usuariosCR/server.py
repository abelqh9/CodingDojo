from flask import Flask, redirect, render_template, request
from mysqlconnection import connectToMySQL

app = Flask(__name__)

@app.route("/users")
def users_Template():
    query = "SELECT * FROM users"

    users = connectToMySQL("usuarios").query_db(query)
    return render_template("users.html", users = users)

@app.route("/users/new")
def newUser_Template():
    return render_template("newUser.html")

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

if __name__ == "__main__":
    app.run(debug=True)