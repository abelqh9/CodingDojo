from flask import Flask, render_template, request, redirect, session

app = Flask(__name__)
app.secret_key = "secretKey2002"

@app.route("/")
def index():
    if len(session):
        session["visits"] += 1
    else:
        session["visits"] = 1
    return render_template("index.html", visits = session["visits"])

@app.route("/destroy_session", methods=["POST"])
def destroy():
    session["visits"] = 0
    return redirect("/")

@app.route("/add_2", methods=["POST"])
def add_2():
    session["visits"] += 1 
    return redirect("/")

if __name__ == "__main__":
    app.run(debug=True)