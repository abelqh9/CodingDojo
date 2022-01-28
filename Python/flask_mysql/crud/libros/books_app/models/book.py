from books_app.config.mysqlconnection import connectToMySQL
from books_app.models import author

class Book:
    def __init__(self, data):
        self.id = data["id"]
        self.title = data["title"]
        self.num_of_pages = data["num_of_pages"]
        self.created_at = data["created_at"]
        self.updated_at = data["updated_at"]

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM books"
        books_from_db = connectToMySQL().query_db(query)
        books = []
        for book in books_from_db:
            books.append(cls(book))
        return books

    @classmethod
    def get_one(cls, data):
        query = "SELECT * FROM books WHERE id = %(book_id)s"
        book_from_db = connectToMySQL().query_db(query, data)
        return cls(book_from_db[0])

    @classmethod
    def add_book(cls, data):
        query = "INSERT INTO books (title, num_of_pages, created_at, updated_at) VALUES (%(title)s, %(num_of_pages)s, NOW(), NOW())"
        connectToMySQL().query_db(query, data)

    @classmethod
    def add_fav_author(cls, data):
        query = "INSERT INTO favorites (author_id, book_id) VALUES (%(author_id)s, %(book_id)s)"
        connectToMySQL().query_db(query, data)

    def get_fav_and_nofav_authors(self):
        query = f"SELECT authors.id, authors.name, authors.created_at, authors.updated_at FROM books JOIN favorites ON books.id = favorites.book_id JOIN authors ON favorites.author_id = authors.id WHERE books.id = {self.id}"
        fav_authors = []
        fav_authors_names = []
        fav_authors_from_db = connectToMySQL().query_db(query)
        for i in fav_authors_from_db: 
            fav_authors.append(author.Author(i))
        for i in fav_authors: 
            fav_authors_names.append(i.name)

        no_fav_authors = []
        for i in author.Author.get_all():
            if (i.name not in fav_authors_names):
                no_fav_authors.append(i)

        print(fav_authors)
        return {
            "fav_authors": fav_authors,
            "no_fav_authors":no_fav_authors
        }