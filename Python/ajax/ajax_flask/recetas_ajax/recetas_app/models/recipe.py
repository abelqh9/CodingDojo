from recetas_app import app
from recetas_app.config.mysqlconnection import connectToMySQL
import re

class Recipe:
    def __init__(self, data):
        self.id = data["id"]
        self.name = data["name"]
        self.description = data["description"]
        self.under_30_minutes = bool(data["under_30_minutes"])
        self.instructions = data["instructions"]
        self.created_at = data["created_at"]
        self.updated_at = data["updated_at"]
        self.user_id = data["user_id"]

    # GET FUNCTIONS
    # @classmethod
    # def get_user_messages(cls, data):
    #     query = "SELECT messages.id, messages.text, messages.created_at, messages.updated_at, messages.transmitter_id, messages.receiver_id FROM messages JOIN users ON messages.receiver_id = users.id WHERE messages.receiver_id = %(user_id)s"
    #     messages_db =  connectToMySQL().query_db(query, data)
    #     messages = []
    #     for m in messages_db: messages.append(cls(m))
    #     return messages

    # @classmethod
    # def get_number_of_messages_sent(cls, data):
    #     query = "SELECT * FROM messages WHERE messages.transmitter_id = %(user_id)s"
    #     messages_db =  connectToMySQL().query_db(query, data)
    #     return len(messages_db)

    @classmethod
    def get_all_recipes_for_user(cls, data):
        query = "SELECT * FROM recipes"
        recipes_db = connectToMySQL().query_db(query)
        recipes = []
        for m in recipes_db: recipes.append(cls(m))
        def map_function(recipe):
            if recipe.user_id == data["user_id"]:
                recipe.created_by_user = True
            else:
                recipe.created_by_user = False
            return recipe
        return list(map(map_function, recipes))

    # @classmethod
    # def get_message(cls, data):
    #     query = "SELECT * FROM messages WHERE messages.id = %(message_id)s"
    #     message_db =  connectToMySQL().query_db(query, data)
    #     return cls(message_db[0])

    # VALIDATION FUNCTIONS
    @classmethod
    def at_least_3_characters(cls, text):
        return len(text)>3

    # @classmethod
    # def user_can_delete_message(cls, data):
    #     return cls.get_message(data).receiver_id == data["user_id"]

    # CREATE FUNCTIONS
    @classmethod
    def add_recipe(cls, data):
        query = "INSERT INTO recipes (name, description, instructions, date_made_on, created_at, updated_at, under_30_minutes, user_id) VALUES (%(name)s, %(description)s, %(instructions)s, %(date_made_on)s, NOW(), NOW(), %(under_30_minutes)s, %(user_id)s)"
        return connectToMySQL().query_db(query, data)

    # DELETE FUNCTIONS
    @classmethod
    def delete_recipe(cls, data):
        query = "DELETE FROM recipes WHERE id = %(recipe_id)s"
        connectToMySQL().query_db(query, data)