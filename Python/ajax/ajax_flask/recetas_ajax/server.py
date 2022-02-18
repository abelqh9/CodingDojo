from recetas_app import app
from recetas_app.controllers import users
from recetas_app.controllers import recipes

if __name__ == "__main__":
    app.run(debug=True)