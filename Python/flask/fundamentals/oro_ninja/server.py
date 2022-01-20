from flask import Flask, render_template, session, request, redirect
import random
import datetime

app = Flask(__name__)
app.secret_key = "helloooooo"

@app.route("/")
def index():

    if not("ninja_gold" in session.keys()):
        session["ninja_gold"] = 0
        session["activities_texts"] = []

    return render_template("index.html", ninja_gold = session["ninja_gold"], activities_texts = session["activities_texts"])

@app.route("/process_money", methods=["POST"])
def process_money():

    time = datetime.datetime.now().strftime("%Y/%m/%d %I:%M %p")

    def append_good_text(amount):
        session["activities_texts"].append([True, f' Earned {amount} golds from the {request.form["building"]}! ({time})'])

    def append_bad_text(amount):
        session["activities_texts"].append([False, f'Entered a casino and lost {amount} golds... Ouch.. ({time})'])

    if request.form["building"] == "farm":
        amount = random.randint(10, 20)
        session["ninja_gold"] += amount
        append_good_text(amount)
    elif request.form["building"] == "cave":
        amount = random.randint(5, 10)
        session["ninja_gold"] += amount
        append_good_text(amount)

    elif request.form["building"] == "house":
        amount = random.randint(2, 5)
        session["ninja_gold"] += amount
        append_good_text(amount)

    elif request.form["building"] == "casino":
        amount = random.randint(0, 50)
        destiny = random.randint(0, 1)
        if destiny:
            session["ninja_gold"] += amount
            append_good_text(amount)

        else:
            session["ninja_gold"] -= amount
            append_bad_text(amount)

    return redirect("/")

if __name__ == "__main__":
    app.run(debug=True)