from encuesta_dojo_app.config.mysqlconnection import connectToMySQL
from flask import flash

class NinjaComment:
    def __init__(self, data):
        self.id = data["id"]
        self.name = data["name"]
        self.dojo_location = data["dojo_location"]
        self.favorite_language = data["favorite_language"]
        self.comment = data["comment"]

    @classmethod
    def add_ninja_comment(cls, data):
        query = "INSERT INTO ninja_comments (name, dojo_location, favorite_language, comment) VALUES (%(name)s, %(dojo_location)s, %(favorite_language)s, %(comment)s)"
        return connectToMySQL().query_db(query, data)

    @classmethod
    def get_ninja_comment(cls, data):
        query = "SELECT * FROM ninja_comments WHERE ninja_comments.id = %(comment_id)s"
        ninja_comment_db =  connectToMySQL().query_db(query, data)
        return cls(ninja_comment_db[0])

    @classmethod
    def get_last_ninja_comment(cls):
        query = "SELECT * FROM ninja_comments ORDER BY id DESC LIMIT 1"
        ninja_comment_db =  connectToMySQL().query_db(query)
        return cls(ninja_comment_db[0])

    @staticmethod
    def validate_comment(comment_data):
        is_valid = True
        if len(comment_data['name']) < 3:
            flash("Name must be at least 3 characters.")
            is_valid = False
        if len(comment_data['dojo_location']) < 3:
            flash("Dojo Location must be at least 3 characters.")
            is_valid = False
        if len(comment_data['favorite_language']) < 1:
            flash("Favorite Language must be at least 1 characters.")
            is_valid = False
        if len(comment_data['comment']) < 20:
            flash("Comment must be at least 20 characters.")
            is_valid = False
        return is_valid