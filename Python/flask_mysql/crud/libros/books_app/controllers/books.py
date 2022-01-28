from books_app  import app
from flask import redirect, render_template, request
from books_app.models.book import Book

# TEMPLATES RENDERING 
@app.route("/books")
def books():
    all_books = Book.get_all()
    return render_template("books.html", all_books = all_books)

@app.route("/books/<book_id>")
def see_book(book_id):
    book = Book.get_one({"book_id": book_id})
    authors = book.get_fav_and_nofav_authors()
    return render_template(
        "show_book.html", book = book, fav_authors = authors["fav_authors"], no_fav_authors = authors["no_fav_authors"]
    )

# PROCESSES
@app.route("/books/new", methods = ["POST"])
def add_book():
    Book.add_book({"title": request.form["book_title"], "num_of_pages": request.form["book_pages"]})
    return redirect("/books")

@app.route("/books/<book_id>/add_fav_author", methods = ["POST"])
def add_fav_author(book_id):
    Book.add_fav_author({"book_id": book_id , "author_id": request.form["author_id"]})
    return redirect("/books/" + book_id)