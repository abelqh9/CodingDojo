import random
from flask import Flask, render_template, session, request, redirect

app = Flask(__name__)
app.secret_key = "helloooooo"

@app.route("/")
def index():
    session["numberToGuess"] = random.randint(1, 100) 
    session["intentos"] = 0

    print(session["numberToGuess"])

    return render_template("index.html")

@app.route("/guess", methods=["POST"])
def guess():
    print(request.form["number"])

    session["number"] = int(request.form["number"])

    if session["numberToGuess"] > session["number"]:
        session["result"] = "Low"
    elif  session["numberToGuess"] < session["number"]:
        session["result"] = "High"
    else:
        session["result"] = "Win"
    
    session["intentos"] += 1

    return redirect("/result")
    
@app.route("/result")
def result():
    return render_template("result.html", result = session["result"], number = session["number"], intentos=session["intentos"])

if __name__ == "__main__":
    app.run(debug=True)