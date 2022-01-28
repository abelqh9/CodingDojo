from amistades_app  import app
from flask import redirect, render_template, request
from amistades_app.models.user import User

# TEMPLATES RENDERING 
@app.route("/friendships")
def see_all_friendships():
    all_users = User.get_all()
    all_friendships = User.get_all_friendships()
    return render_template("friendships.html", all_users = all_users, all_friendships = all_friendships)

# PROCESSES
@app.route("/friendships/add_user", methods = ["POST"])
def add_user():
    User.add_user({
        "first_name": request.form["first_name"], 
        "last_name": request.form["last_name"]
    })
    return redirect("/friendships")

@app.route("/friendships/create_friendship", methods = ["POST"])
def create_friendship():
    print({
        "user_id": request.form["user_id"], 
        "friend_id": request.form["friend_id"]
    })
    User.add_friendship({
        "user_id": request.form["user_id"], 
        "friend_id": request.form["friend_id"]
    })

    return redirect("/friendships")