from encuesta_dojo_app import app
from flask import render_template, request, redirect, session
from encuesta_dojo_app.models.ninja_comment import NinjaComment

# TEMPLATES RENDERING 
@app.route("/")
def index():
    return render_template("index.html")

@app.route("/result")
def result():
    comment = NinjaComment.get_last_ninja_comment()
    return render_template("result.html", comment = comment)

# PROCESSES
@app.route("/process", methods=["POST"])
def process():
    data = {
        "name": request.form["name"],
        "dojo_location": request.form["dojo_location"],
        "favorite_language": request.form["favorite_language"],
        "comment": request.form["comments"]
    }

    if not NinjaComment.validate_comment(data):
        return redirect('/')

    NinjaComment.add_ninja_comment(data)

    return redirect("/result")