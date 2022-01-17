num1 = 42 # variable declaration, initialize, Numbers
num2 = 2.3 # variable declaration, initialize, Numbers
boolean = True # variable declaration, initialize, Boolean
string = 'Hello World' # variable declaration, initialize, Strings
pizza_toppings = ['Pepperoni', 'Sausage', 'Jalepenos', 'Cheese', 'Olives'] # variable declaration, initialize, List
person = {'name': 'John', 'location': 'Salt Lake', 'age': 37, 'is_balding': False} # variable declaration, initialize, Dictionary
fruit = ('blueberry', 'strawberry', 'banana') # variable declaration, initialize, Tuples
print(type(fruit)) # log statement, type check, Tuples
print(pizza_toppings[1]) # log statement, List, access value
pizza_toppings.append('Mushrooms') # log statement, List, add value
print(person['name']) # log statement, Dictionary, access value
person['name'] = 'George' # log statement, Dictionary, change value
person['eye_color'] = 'blue' # log statement, Dictionary, add value
print(fruit[2]) # log statement, Tuples, access value

if num1 > 45: # if
    print("It's greater") # log statement
else: # else
    print("It's lower") # log statement

if len(string) < 5: # if, length check
    print("It's a short word!") # log statement
elif len(string) > 15: # else if, length check
    print("It's a long word!") # log statement
else: # else
    print("Just right!") # log statement

for x in range(5): # for loop
    print(x) # log statement
for x in range(2,5): # for loop
    print(x) # log statement
for x in range(2,10,3): # for loop
    print(x) # log statement
x = 0 # variable declaration, initialize, Numbers
while(x < 5): # while loop
    print(x) # log statement
    x += 1 # increment

pizza_toppings.pop() # List, delete value
pizza_toppings.pop(1) # List, delete value

print(person) # log statement, Dictionary
person.pop('eye_color') # Dictionary, delete value
print(person) # log statement, Dictionary

for topping in pizza_toppings: # for loop, List
    if topping == 'Pepperoni': # if
        continue # continue
    print('After 1st if statement') #log statement
    if topping == 'Olives': # if
        break # break

def print_hello_ten_times(): # function
    for num in range(10): # for loop
        print('Hello') #log statement

print_hello_ten_times() # function, log statement

def print_hello_x_times(x): # function, argument
    for num in range(x): # for loop, argument
        print('Hello') #log statement

print_hello_x_times(4) # function, log statement, argument

def print_hello_x_or_ten_times(x = 10): # function, argument
    for num in range(x): # for loop, argument
        print('Hello') #log statement

print_hello_x_or_ten_times() # function, log statement
print_hello_x_or_ten_times(4) # function, log statement, argument


"""
Bonus section
"""

print(num3) # NameError: name <variable name> is not defined
num3 = 72 # variable declaration, initialize, Numbers
fruit[0] = 'cranberry' # TypeError: 'tuple' object does not support item assignment
print(person['favorite_team']) # KeyError: 'favorite_team'
print(pizza_toppings[7]) # IndexError: list index out of range
  print(boolean) # IndentationError: unexpected indent
fruit.append('raspberry') # AttributeError: 'tuple' object has no attribute 'append'
fruit.pop(1) # AttributeError: 'tuple' object has no attribute 'pop'