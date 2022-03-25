import React, { useState } from 'react'
import "./Register.css"

function Register(props) {

    let { setUser } = props;

    const [name, setName] = useState("");

    return (
        <main className='Register'>
            <h2>Get started right now!</h2>
            <form onSubmit={e=>setUser({ name })}>
                <label htmlFor="name">I want to start chatting with the name...</label>
                <div>
                    <input type="text" id='name' value={name} onChange={e=>setName(e.target.value)}/>
                    <button className='btn btn-success' type="submit">Start Chatting</button>
                </div>
            </form>
        </main>
    )
}

export default Register