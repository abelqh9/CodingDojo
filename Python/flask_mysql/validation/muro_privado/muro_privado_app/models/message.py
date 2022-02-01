from muro_privado_app import app
from muro_privado_app.config.mysqlconnection import connectToMySQL
import re

class Message:
    def __init__(self, data):
        self.id = data["id"]
        self.text = data["text"]
        self.created_at = data["created_at"]
        self.updated_at = data["updated_at"]
        self.transmitter_id = data["transmitter_id"]
        self.receiver_id = data["receiver_id"]

    # GET FUNCTIONS
    @classmethod
    def get_user_messages(cls, data):
        query = "SELECT messages.id, messages.text, messages.created_at, messages.updated_at, messages.transmitter_id, messages.receiver_id FROM messages JOIN users ON messages.receiver_id = users.id WHERE messages.receiver_id = %(user_id)s"
        messages_db =  connectToMySQL().query_db(query, data)
        messages = []
        for m in messages_db: messages.append(cls(m))
        return messages

    @classmethod
    def get_number_of_messages_sent(cls, data):
        query = "SELECT * FROM messages WHERE messages.transmitter_id = %(user_id)s"
        messages_db =  connectToMySQL().query_db(query, data)
        return len(messages_db)

    @classmethod
    def get_message(cls, data):
        query = "SELECT * FROM messages WHERE messages.id = %(message_id)s"
        message_db =  connectToMySQL().query_db(query, data)
        return cls(message_db[0])

    # VALIDATION FUNCTIONS
    @classmethod
    def text_is_valid(cls, data):
        return len(data["text"])>5

    @classmethod
    def user_can_delete_message(cls, data):
        return cls.get_message(data).receiver_id == data["user_id"]

    # CREATE FUNCTIONS
    @classmethod
    def add_message(cls, data):
        query = "INSERT INTO messages (text, created_at, updated_at, transmitter_id, receiver_id) VALUES (%(text)s, NOW(), NOW(), %(transmitter_id)s, %(receiver_id)s)"
        return connectToMySQL().query_db(query, data)

    # DELETE FUNCTIONS
    @classmethod
    def delete_message(cls, data):
        query = "DELETE FROM messages WHERE messages.id = %(message_id)s"
        connectToMySQL().query_db(query, data)