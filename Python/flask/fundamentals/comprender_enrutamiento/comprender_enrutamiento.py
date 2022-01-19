from flask import Flask  # Importa Flask para permitirnos crear nuestra aplicación
app = Flask(__name__)    # Crea una nueva instancia de la clase Flask llamada "app"

@app.route('/')          # El decorador "@" asocia esta ruta con la función inmediatamente siguiente
def hola_mundo():
    return '¡Hola Mundo!'  # Devuelve la cadena '¡Hola Mundo!' como respuesta

@app.route('/dojo')
def dojo():
    return '¡Dojo!'

@app.route('/say/<name>')
def hola_name(name):
    return f'¡Hola, {str(name)}!'

@app.route('/repeat/<num>/<word>')
def repeat_word(num, word):
    text = ""
    for i in range(int(num)):
        text += f"<h1><strong>{str(word)}<strong/></h1>"
    return text

if __name__=="__main__":   # Asegúrate de que este archivo se esté ejecutando directamente y no desde un módulo diferente    
    app.run(debug=True)    # Ejecuta la aplicación en modo de depuración