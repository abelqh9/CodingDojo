from amistades_app.config.mysqlconnection import connectToMySQL

class User:
    def __init__(self, data):
        self.id = data["id"]
        self.first_name = data["first_name"]
        self.last_name = data["last_name"]
        self.created_at = data["created_at"]
        self.updated_at = data["updated_at"]

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM users"
        books_from_db = connectToMySQL().query_db(query)
        books = []
        for book in books_from_db:
            books.append(cls(book))
        return books

    @classmethod
    def get_all_friendships(cls):
        query = "SELECT users.first_name as user_first_name, users.last_name as user_last_name, users2.first_name as friend_first_name, users2.last_name as friend_last_name FROM users JOIN friendships ON users.id = friendships.user_id JOIN users AS users2 ON friendships.friend_id = users2.id order by users.last_name"
        friendships_from_db = connectToMySQL().query_db(query)
        return friendships_from_db

    @classmethod
    def add_user(cls, data):
        query = "INSERT INTO users (first_name, last_name, created_at, updated_at) VALUES (%(first_name)s, %(last_name)s, NOW(), NOW())"
        connectToMySQL().query_db(query, data)

    @classmethod
    def add_friendship(cls, data):
        query = "INSERT INTO friendships (created_at, updated_at, user_id, friend_id) VALUES (NOW(), NOW(), %(user_id)s, %(friend_id)s)"
        connectToMySQL().query_db(query, data)