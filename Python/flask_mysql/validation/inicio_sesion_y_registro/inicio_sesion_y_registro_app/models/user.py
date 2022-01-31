from inicio_sesion_y_registro_app import app
from inicio_sesion_y_registro_app.config.mysqlconnection import connectToMySQL
from flask_bcrypt import Bcrypt
import re

bcrypt = Bcrypt(app)

class User:
    def __init__(self, data):
        self.id = data["id"]
        self.first_name = data["first_name"]
        self.last_name = data["last_name"]
        self.email = data["email"]

    # GET FUNCTIONS
    @classmethod
    def get_user(cls, data):
        query = "SELECT id, first_name, last_name, email FROM users WHERE users.id = %(id)s"
        user_db =  connectToMySQL().query_db(query, data)
        return cls(user_db[0])

    @classmethod
    def get_user_id_by_email(cls, data):
        query = "SELECT id FROM users WHERE users.email = %(email)s"
        user_db =  connectToMySQL().query_db(query, data)
        return user_db[0]["id"]

    @classmethod
    def get_user_password_by_email(cls, data):
        query = "SELECT password FROM users WHERE users.email = %(email)s"
        user_db =  connectToMySQL().query_db(query, data)
        return user_db[0]["password"]

    @classmethod
    def get_all_emails(cls):
        query = "SELECT email FROM users"
        emails_db = connectToMySQL().query_db(query)
        emails = []
        for e in emails_db: emails.append(e["email"])
        return emails

    # VALIDATION FUNCTIONS
    @classmethod
    def first_name_is_valid(cls, data):
        EMAIL_REGEX = re.compile(r"^[a-zA-Z]{2,}[a-zA-Z\s]*$")
        return (EMAIL_REGEX.match(data["first_name"]))

    @classmethod
    def last_name_is_valid(cls, data):
        EMAIL_REGEX = re.compile(r"^[a-zA-Z]{2,}[a-zA-Z\s]*$")
        return (EMAIL_REGEX.match(data["last_name"]))

    @classmethod
    def email_is_valid(cls, data):
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        return (EMAIL_REGEX.match(data["email"]))
            
    @classmethod
    def email_exist(cls, data):
        return (data["email"] in cls.get_all_emails())

    @classmethod
    def password_is_valid(cls, data):
        PASSWORD_REGEX = re.compile(r"^(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$")
        return PASSWORD_REGEX.match(data["password"])

    @classmethod
    def password_is_correct(cls, data):
        password_db = cls.get_user_password_by_email(data)
        return bcrypt.check_password_hash(password_db, data["password"])

    # CREATE FUNCITONS
    @classmethod
    def add_user(cls, data):
        query = "INSERT INTO users (first_name, last_name, email, password, created_at, updated_at) VALUES (%(first_name)s, %(last_name)s, %(email)s, %(password)s, NOW(), NOW())"
        return connectToMySQL().query_db(query, data)

    @classmethod
    def create_password(cls, data):
        return bcrypt.generate_password_hash(data["password"])