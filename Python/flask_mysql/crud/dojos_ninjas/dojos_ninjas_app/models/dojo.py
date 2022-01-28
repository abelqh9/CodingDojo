from dojos_ninjas_app.config.mysqlconnection import connectToMySQL
from dojos_ninjas_app.models.ninja import Ninja

class Dojo:
    def __init__(self, data):
        self.id = data["id"]
        self.name = data["name"]
        self.created_at = data["created_at"]
        self.updated_at = data["updated_at"]

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM dojos"
        dojos_from_db = connectToMySQL().query_db(query)
        dojos = []
        for dojo in dojos_from_db:
            dojos.append(cls(dojo))
        return dojos

    @classmethod
    def get_one(cls, data):
        query = "SELECT * FROM dojos WHERE id = %(id)s"
        dojo_from_db = connectToMySQL().query_db(query, data)
        return cls(dojo_from_db[0])

    @classmethod
    def get_ninjas(cls, data):
        query = "SELECT * FROM ninjas WHERE dojo_id = %(id)s"
        ninjas_from_db = connectToMySQL().query_db(query, data)
        ninjas = []
        for ninja in ninjas_from_db:
            ninjas.append(Ninja(ninja))
        return ninjas

    @classmethod
    def add(cls, data):
        query = "INSERT INTO dojos (name, created_at, updated_at) VALUES (%(name)s, NOW(), NOW())"
        connectToMySQL().query_db(query, data)