import React from 'react'

const UserForm = (props) => {

    let { firstName, setFirstName, lastName, setLastName, email, setEmail, password, setPassword, cPassword, setCPassword, createUser } = props;

    return (
        <form onSubmit={ createUser }>
            <div>
                <label>First Name: </label> 
                <input type="text" value={ firstName } onChange={ (e) => setFirstName(e.target.value) } />
            </div>
            <div>
                <label>Last Name: </label> 
                <input type="text" value={ lastName } onChange={ (e) => setLastName(e.target.value) } />
            </div>
            <div>
                <label>Email Address: </label> 
                <input type="email" value={ email } onChange={ (e) => setEmail(e.target.value) } />
            </div>
            <div>
                <label>Password: </label>
                <input type="password" value={ password } onChange={ (e) => setPassword(e.target.value) } />
            </div>
            <div>
                <label>Confirm Password: </label>
                <input type="password" value={ cPassword } onChange={ (e) => setCPassword(e.target.value) } />
            </div>
        </form>
    )
}

export default UserForm