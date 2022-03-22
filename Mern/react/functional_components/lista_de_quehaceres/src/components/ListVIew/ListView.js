import React from 'react'
import './ListView.css'

function ListView(props) {

    let { todos, deleteTodo, doneTodo, undoneTodo } = props

    return (
        <ul>
            { todos.map((t,i) => {
                return !t.done 
                ? <li key={i}> 
                    <span>{t.name}</span> 
                    <button className='done_btn' onClick={e=>doneTodo(t.name)}>Done</button> 
                    <button onClick={e=>deleteTodo(t.name)} className='delete_btn'>Delete</button>
                </li>
                : <li key={i}>
                    <span className='done'>{t.name}</span>
                    <button className='unDone_btn' onClick={e=>undoneTodo(t.name)}>UnDone</button> 
                    <button onClick={e=>deleteTodo(t.name)} className='delete_btn'>Delete</button>
                </li>
            })}
        </ul>
    )
}

export default ListView