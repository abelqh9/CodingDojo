from dojos_ninjas_app  import app
from flask import redirect, render_template, request
from dojos_ninjas_app.models.dojo import Dojo

# TEMPLATES RENDERING 
@app.route("/dojos")
def add_see_dojos():
    dojos = Dojo.get_all()
    return render_template("dojo.html", dojos = dojos)

@app.route("/dojos/<dojo_id>")
def see_dojo(dojo_id):
    dojo = Dojo.get_one({"id": dojo_id})
    ninjas = Dojo.get_ninjas({"id": dojo_id})

    return render_template("dojo_show.html", dojo = dojo, ninjas = ninjas)

# PROCESSES
@app.route("/dojos/new", methods = ["POST"])
def create_dojo():
    Dojo.add({ "name": request.form["dojo_name"] })
    return redirect("/dojos")