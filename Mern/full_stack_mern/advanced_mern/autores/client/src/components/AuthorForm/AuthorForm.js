import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import "./AuthorForm.css"

function AuthorForm(props) {

    let navigate = useNavigate()

    let { nameInitialValue, submitHandler } = props

    const [name, setName] = useState(nameInitialValue)

    return (
        <form className="AuthorForm" onSubmit={e=>{submitHandler(e); setName("");}}>
            <div>
                <label htmlFor="name">Name: </label>
                <input type="text" name='name' id='name' value={name} onChange={e=>setName(e.target.value)}/>
            </div>
            <div>
                <button className='btn btn-danger' type="button" onClick={e=>navigate("/authors")}>Cancel</button>
                <button className='btn btn-primary' type="submit">Create</button>
            </div>
         </form>
    )
}

export default AuthorForm