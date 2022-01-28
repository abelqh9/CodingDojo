from books_app  import app
from flask import redirect, render_template, request
from books_app.models.author import Author

# TEMPLATES RENDERING 
@app.route("/authors")
def authors():
    authors = Author.get_all()
    return render_template("authors.html", authors = authors)

@app.route("/authors/<author_id>")
def see_author(author_id):
    author = Author.get_one({"author_id": author_id})
    books = author.get_fav_and_nofav_books()

    return render_template(
        "show_author.html", author = author, fav_books = books["fav_books"], no_fav_books = books["no_fav_books"]
    )

# PROCESSES
@app.route("/authors/new", methods = ["POST"])
def add_author():
    Author.add_author({"name": request.form["author_name"]})
    return redirect("/authors")
    
@app.route("/authors/<author_id>/add_fav_book", methods = ["POST"])
def add_fav_book(author_id):
    Author.add_fav_book({"author_id":author_id, "book_id": request.form["book_id"] })
    return redirect("/authors/" + author_id)