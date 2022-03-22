import React, { useState, useEffect } from 'react'
import './App.css';
import ListForm from './components/ListForm/ListForm';
import ListView from './components/ListVIew/ListView';

function App() {

    const [todos, setTodos] = useState([])

    useEffect(() => {
        let todosInLocal = localStorage.getItem("todos");
        if (todosInLocal!==null) setTodos(JSON.parse(todosInLocal));
    }, [])
    
    useEffect(() => {
        localStorage.setItem("todos", JSON.stringify(todos))
    }, [todos])
    

    function addTodo(name) {
        setTodos(t=>[...t, {name, done:false}])
    }
    function deleteTodo(name) {
        setTodos(todos=>todos.filter((todo)=>todo.name!==name))
    }
    function doneTodo(name) {
        setTodos(todos=>{
            return todos.map(todo=>{
                if (todo.name === name) todo.done = true
                return todo
            })
        })
    }
    function undoneTodo(name) {
        setTodos(todos=>{
            return todos.map(todo=>{
                if (todo.name === name) todo.done = false
                return todo
            })
        })
    }

    return (
        <div className="App">
            <ListView todos={todos} deleteTodo={deleteTodo} doneTodo={doneTodo} undoneTodo={undoneTodo}/>
            <ListForm addTodo={addTodo}/>
        </div>
    );
}
export default App;
