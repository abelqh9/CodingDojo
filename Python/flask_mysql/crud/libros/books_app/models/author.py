from books_app.config.mysqlconnection import connectToMySQL
from books_app.models import book

class Author:
    def __init__(self, data):
        self.id = data["id"]
        self.name = data["name"]
        self.created_at = data["created_at"]
        self.updated_at = data["updated_at"]

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM authors"
        authors_from_db = connectToMySQL().query_db(query)
        authors = []
        for author in authors_from_db:
            authors.append(cls(author))
        return authors

    @classmethod
    def get_one(cls, data):
        query = "SELECT * FROM authors WHERE id = %(author_id)s"
        author_from_db = connectToMySQL().query_db(query, data)
        return cls(author_from_db[0])

    @classmethod
    def add_author(cls, data):
        query = "INSERT INTO authors (name, created_at, updated_at) VALUES (%(name)s, NOW(), NOW())"
        connectToMySQL().query_db(query, data)

    @classmethod
    def add_fav_book(cls, data):
        query = "INSERT INTO favorites (author_id, book_id) VALUES (%(author_id)s, %(book_id)s)"
        connectToMySQL().query_db(query, data)

    def get_fav_and_nofav_books(self):
        query = f"SELECT books.id, books.title, books.num_of_pages, books.created_at, books.updated_at FROM authors JOIN favorites ON authors.id = favorites.author_id JOIN books ON favorites.book_id = books.id WHERE authors.id = {self.id}"
        fav_books = []
        fav_books_titles = []
        fav_books_from_db = connectToMySQL().query_db(query)
        for i in fav_books_from_db:
            fav_books.append(book.Book(i))
        for i in fav_books: 
            fav_books_titles.append(i.title)

        no_fav_books = []
        for book_of_all in book.Book.get_all():
            if (book_of_all.title not in fav_books_titles):
                no_fav_books.append(book_of_all)

        return {
            "fav_books": fav_books,
            "no_fav_books":no_fav_books
        }