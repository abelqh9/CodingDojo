from flask import Flask, render_template, request, redirect
app = Flask(__name__)  

@app.route('/')
def index():
    return render_template("index.html")

@app.route('/checkout', methods=['POST'])
def checkout():
    strawberry = int(request.form["strawberry"])
    raspberry = int(request.form["raspberry"])
    apple = int(request.form["apple"])

    first_name = request.form["first_name"]
    last_name = request.form["last_name"]

    if request.form["student_id"]:
        student_id = request.form["student_id"]
    else:
        student_id = "---------"

    fruitsTotal = strawberry + raspberry + apple

    return render_template("checkout.html", fruitsTotal=fruitsTotal, strawberry=strawberry, raspberry=raspberry, apple=apple, first_name= first_name, last_name=last_name, student_id=student_id)

@app.route('/fruits')
def fruits():
    return render_template("fruits.html")

if __name__=="__main__":   
    app.run(debug=True)    