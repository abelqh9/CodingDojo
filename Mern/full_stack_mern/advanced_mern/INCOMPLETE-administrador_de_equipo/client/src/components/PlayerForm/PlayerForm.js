import React, { useState } from 'react'
import "./PlayerForm.css"

function PlayerForm(props) {

    let { nameInitialValue, submitHandler } = props

    const [name, setName] = useState(nameInitialValue)
    const [position, setPosition] = useState(positionInitialValue)

    return (
        <form className="AuthorForm" onSubmit={e=>{submitHandler(e); setName("");}}>
            <div>
                <label htmlFor="name">Player Name: </label>
                <input type="text" name='name' id='name' value={name} onChange={e=>setName(e.target.value)}/>
            </div>
            <div>
                <label htmlFor="position">Preferred Position: </label>
                <input type="text" name='position' id='position' value={position} onChange={e=>setPosition(e.target.value)}/>
            </div>
            <button className='btn btn-success' type="submit">Create</button>
         </form>
    )
}

export default PlayerForm