import React, { useState } from 'react'
import './ColorForm.css'

export default function ColorForm(props) {

    let { setBoxes } = props;

    const [color, setColor] = useState("")

    function formHandler(e) {
        e.preventDefault();
        if (color) { setBoxes(boxes=>[...boxes, color]) }
        setColor("");
    }

    return (
        <form className='ColorForm' onSubmit={formHandler}>
            <label htmlFor="color">Color</label>
            <input id="color" name="color" type="text" value={color} onChange={e=>setColor(e.target.value)}/>
            <button type="submit">Add</button>
        </form>
    )
}
