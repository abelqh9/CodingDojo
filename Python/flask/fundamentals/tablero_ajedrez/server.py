from flask import Flask, render_template

app = Flask(__name__)

@app.route("/")
@app.route("/<y>")
@app.route("/<x>/<y>")
@app.route("/<x>/<y>/<oddColor>/")
@app.route("/<x>/<y>/<oddColor>/<evenColor>")
def index(x=8, y=8, oddColor="black", evenColor="red"):
    return render_template("index.html", x = int(x), y = int(y), oddColor=oddColor, evenColor=evenColor)

if __name__ == "__main__":
    app.run(debug = True)