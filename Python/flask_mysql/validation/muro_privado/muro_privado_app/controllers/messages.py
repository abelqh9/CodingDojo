from muro_privado_app import app
from muro_privado_app.models.message import Message
from flask import render_template, request, redirect, session, flash

# PROCESSES
@app.route("/messages/send", methods=["POST"])
def send():
    if "user_id" in session:
        form_data = {
            "text": request.form["message"].strip(),
            "transmitter_id": str(session["user_id"]),
            "receiver_id": request.form["other_user_id"],
        }
        print(form_data)
        if Message.text_is_valid(form_data):
            Message.add_message(form_data)
        else:
            flash("The message content should be at least 5 characters long")
        return redirect("/dashboard")
    else:
        return redirect("/")

@app.route("/messages/delete", methods=["POST"])
def delete():
    if "user_id" in session:
        form_data = {
            "message_id": request.form["message_id"],
            "user_id": session["user_id"],
        }
        if Message.user_can_delete_message(form_data):
            Message.delete_message(form_data)
        return redirect("/dashboard")
    else:
        return redirect("/")