import React, { useContext } from 'react'
import { NameContext } from '../../context/NameContext/NameContext';

function Form() {

    let {name, setName} = useContext(NameContext)

    return (
        <form style={{textAlign:"center", display:'flex', justifyContent:"center",gap:"1rem"}}>
            <label htmlFor="name">Your Name:</label>
            <input type="text" id='name' value={name} onChange={e=>setName(e.target.value)}/>       
        </form>
    )
}

export default Form