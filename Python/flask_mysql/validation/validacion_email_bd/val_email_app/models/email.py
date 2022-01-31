from val_email_app.config.mysqlconnection import connectToMySQL
from flask import flash
import re

class Email:
    def __init__(self, data):
        self.id = data["id"]
        self.email = data["email"]
        self.created_at = data["created_at"]
        self.updated_at = data["updated_at"]

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM emails"
        emails_db = connectToMySQL().query_db(query)
        emails = []
        for email in emails_db: emails.append(cls(email))
        return emails

    @classmethod
    def add_one(cls, data):
        print(data)
        query = "INSERT INTO emails (email, created_at, updated_at) VALUES (%(email)s, NOW(), NOW())"
        return connectToMySQL().query_db(query, data)

    @classmethod
    def validate_email( cls, email ):
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$') 
        is_valid = True
        if EMAIL_REGEX.match(email):
            for e in cls.get_all():
                if email == e.email:
                    flash("The email address already exist", "error")
                    is_valid = False
                    return is_valid
            flash("The email address you entered (" + email + ") is a VALID email address! Thank you!", "success")
        else:
            flash("Invalid email address!", "error")
            is_valid = False
        return is_valid