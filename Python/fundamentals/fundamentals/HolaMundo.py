# 1. TAREA: imprime "Hola, mundo"
print( "Hola, mundo" )
# 2. imprime "Hola, Noelle" con el nombre en una variable
name = "Noelle"
print( "Hola,", name )	# con una coma
print( "Hola, " + name )	# con un +
# 3. imprimir "Hola 42!" con el número en una variable
name = 42
print( "Hola,", name, "!" )	# con una coma
print( "Hola, " + str(name) + "!" )	# con una +	-- este debería arrojar un error!
# 4. imprimir "Amo comer sushi y pizza" con las comidas en variables
fave_food1 = "sushi"
fave_food2 = "pizza"
print( "Amo comer {} y {}".format(fave_food1, fave_food2) ) # con .format()
print(f"Amo comer {fave_food1} y {fave_food2}" ) # con una cadena f