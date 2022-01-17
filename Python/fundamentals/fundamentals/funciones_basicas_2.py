# Cuenta regresiva: crea una función que acepte un número como entrada. Devuelve una lista nueva que cuente de uno en uno, desde el número (como elemento 0) hasta 0 (como último elemento). 
# Ejemplo: countdown(5) debería devolver [5,4,3,2,1,0]

# def countdown(start):
#     lst = []
#     for i in range(start, -1, -1):
#         lst.append(i)
#     return lst
# print("valor retornado:", countdown(5))

# Imprimir y devolver: crea una función que reciba una lista con dos números. Imprime el primer valor y devuelve el segundo.
# Ejemplo: imprimir_y_devolver([1,2]) debe imprimir 1 y devolver 2

# def imprimir_y_devolver(lst):
#     print(lst[0])
#     return lst[1]
# print("valor retornado:", imprimir_y_devolver([1,2]))

# Primero más longitud: crea una función que acepte una lista y devuelva la suma del primer valor de la lista, más la longitud de la lista.
# Ejemplo: primero_mas_longitud([1,2,3,4,5]) debe devolver 6 (primer valor: 1 +length: 5)

# def primero_mas_longitud(lst):
#     return lst[0] + len(lst)
# print("valor retornado:", primero_mas_longitud([1,2,3,4,5]))

# Valores mayores que el segundo: escribe una función que acepte una lista y cree una nueva que contenga solo los valores de la lista original que sean mayores que su segundo valor. Imprime cuántos valores son y luego devuelve la lista nueva. Si la lista tiene menos de 2 elementos, has que la función devuelva False
# Ejemplo: valores_mayores_que_el_segundo([5,2,3,2,1,4]) debe imprimir 3 y devolver [5,3,4]
# Ejemplo: valores_mayores_que_el_segundo([3]) debe devolver False

# def valores_mayores_que_el_segundo(lst):
#     if (len(lst)>1):
#         newList = []
#         for i in lst:
#             if (i != lst[1] and i>lst[1]):
#                 newList.append(i)
#             else:
#                 continue
#         print(len(newList))
#         return newList
#     else:
#         return False
# print("valor retornado:", valores_mayores_que_el_segundo([5,2,3,2,1,4]))
# print("valor retornado:", valores_mayores_que_el_segundo([3]))

# Esta longitud, ese valor: escribe una función que acepte dos enteros como parámetros: tamaño y valor. La función debe crear y devolver una lista cuya longitud sea igual al tamaño dado, y cuyos valores sean todos el valor dado.
# Ejemplo: length_and_value(4,7) debe devolver [7,7,7,7]
# Ejemplo: length_and_value(6,2) debe devolver [2,2,2,2,2,2]

# def length_and_value(length, value):
#     lst = []
#     for i in range(length):
#         lst.append(value)
#     return lst
# print("valor retornado:", length_and_value(4,7))
# print("valor retornado:", length_and_value(6,2))