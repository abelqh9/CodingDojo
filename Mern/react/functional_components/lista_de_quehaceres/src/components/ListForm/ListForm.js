import React, { useState } from 'react'
import './ListForm.css'

function ListForm(props) {

    const [input, setInput] = useState("")

    let { addTodo } = props

    function submitHandler(e){
        e.preventDefault();
        if (input) addTodo(input)
        setInput("")
    }

    return (
        <form onSubmit={submitHandler}>
            <input type="text" value={input} onChange={e=>setInput(e.target.value)}/>
            <button className='add_btn' type="submit">Add</button>
        </form>
    )
}

export default ListForm