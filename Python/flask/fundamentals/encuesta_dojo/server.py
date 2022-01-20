from flask import Flask, render_template, session, request, redirect
import random

app = Flask(__name__)
app.secret_key = "helloooooo"

@app.route("/")
def index():
    return render_template("index.html")


@app.route("/process", methods=["POST"])
def process():
    session["submittedInfo"] = {
        "name": request.form["name"],
        "dojoLocation": request.form["dojoLocation"],
        "favLanguage": request.form["favLanguage"],
        "comments": request.form["comments"]
    }
    return redirect("/result")

@app.route("/result")
def result():
    return render_template("result.html", submittedInfo = session["submittedInfo"])
    
if __name__ == "__main__":
    app.run(debug=True)