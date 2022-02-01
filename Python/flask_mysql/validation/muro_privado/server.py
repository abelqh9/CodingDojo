from muro_privado_app import app
from muro_privado_app.controllers import users
from muro_privado_app.controllers import messages

if __name__ == "__main__":
    app.run(debug=True)