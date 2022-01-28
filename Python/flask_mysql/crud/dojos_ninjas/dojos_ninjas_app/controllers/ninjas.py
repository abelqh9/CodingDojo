from dojos_ninjas_app  import app
from flask import redirect, render_template, request
from dojos_ninjas_app.models.dojo import Dojo
from dojos_ninjas_app.models.ninja import Ninja

# TEMPLATES RENDERING 
@app.route("/ninjas")
def add_ninjas():
    dojos = Dojo.get_all()
    return render_template("ninja.html", dojos = dojos)

# PROCESSES
@app.route("/ninjas/new", methods = ["POST"])
def create_ninja():
    Ninja.add({
        "first_name": request.form["f_name"],
        "last_name": request.form["l_name"],
        "age": request.form["age"],
        "dojo_id": int(request.form["dojo"])
    })
    return redirect("/dojos/" + request.form["dojo"])