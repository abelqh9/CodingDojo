print("------------- 1 -------------")
# 1) Actualizar valores en diccionarios y listas
x = [ [5,2,3], [10,8,9] ] 
estudiantes = [
    {'first_name':  'Michael', 'last_name' : 'Jordan'},
    {'first_name' : 'John', 'last_name' : 'Rosales'}
]
directorio_deportes = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'fútbol' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]

# 1.1) Cambia el valor 10 en x a 15. Una vez que hayas terminado, x ahora debería ser [ [5,2,3], [15,8,9] ].
x[1][0] = 15
print(x)

# 1.2) Cambia el "apellido” del primer alumno de 'Jordan' a 'Bryant'.
estudiantes[0]["last_name"] = 'Bryant'
print(estudiantes)

# 1.3) En el directorio_deportes, cambia "Messi" por "Andrés".
directorio_deportes['fútbol'][0] = "Andrés"
print(directorio_deportes)

# 1.4) Cambia el valor 20 en z a 30.
z[0]["y"]=30
print(z)


print("------------- 2 -------------")
# 2) Iterar a través de una lista de diccionarios
estudiantes = [
    {'first_name':  'Michael', 'last_name' : 'Jordan'},
    {'first_name' : 'John', 'last_name' : 'Rosales'},
    {'first_name' : 'Mark', 'last_name' : 'Guillen'},
    {'first_name' : 'KB', 'last_name' : 'Tonel'}
]
def iterateDictionary(lst):
    for i in lst:
        print(f'first_name - {i["first_name"]}, last_name - {i["last_name"]}') 
iterateDictionary(estudiantes) 
# debería devolver: (está bien si cada par clave-valor termina en 2 líneas separadas;
# un bonus para que aparezcan exactamente como se muestra a continuación)
# first_name - Michael, last_name - Jordan
# first_name - John, last_name - Rosales
# first_name - Mark, last_name - Guillen
# first_name - KB, last_name - Tonel


print("------------- 3 -------------")
# 3) Obtener valores de una lista de diccionarios
def iterateDictionary2(key_name, some_list):
    for i in some_list:
        print(i[key_name])
iterateDictionary2('first_name', estudiantes)
iterateDictionary2('last_name', estudiantes)


print("------------- 4 -------------")
# 4) Iterar a través de un diccionarios con valores de lista
dojo = {
   'ubicaciones': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
   'instructores': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}
def printInfo(some_dict):
    for i in some_dict.keys():
        print(f'{len(some_dict[i])} {i.upper()}')
        for y in some_dict[i]:
            print(y)
        print(" ")
printInfo(dojo)