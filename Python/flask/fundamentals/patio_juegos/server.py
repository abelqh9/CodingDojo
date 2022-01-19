from flask import Flask, render_template

app = Flask(__name__)

@app.route("/play")
@app.route("/play/<num>")
@app.route("/play/<num>/<color>")
@app.route("/play//")
def index3(num=3, color="rgb(76, 219, 219)"):
    return render_template("index3.html", num = int(num), color = color)

if __name__ == "__main__":
    app.run(debug = True)