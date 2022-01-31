from val_email_app import app
from val_email_app.models.email import Email
from flask import redirect, render_template, request

@app.route("/")
def index():
    return render_template("index.html")

@app.route("/success")
def success():
    return render_template("success.html", emails = Email.get_all())

@app.route("/process", methods=["POST"])
def process():
    email = request.form["email"]
    if Email.validate_email(email):
        Email.add_one({"email": email})
        return redirect("/success")
    else:
        return redirect("/")
    