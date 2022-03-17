import React, { useState } from 'react'
import './Form.css'

const Form = () => {

    // INPUT VALUE STATES
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [cPassword, setCPassword] = useState("");

    // INPUT ONCHANGE HANDLERS
    function handleFirstNameError() {
        let value = firstName;
        if (value.length > 0) {
            if (value.length < 2) {
                return "First Name must be 2 characters";
            }
        }
    }
    function handleLastNameError() {
        let value = lastName;
        if (value.length > 0) {
            if (value.length < 2) {
                return "Last Name must be 2 characters"
            }
        }
    }
    function handleEmailError() {
        let value = email;
        if (value.length > 0) {
            if (value.length < 5) {
                return "Email must be 5 characters"
            }
        }
    }
    function handlePasswordError() {
        let value = password;
        if (value.length > 0) {
            if(value !== cPassword){
                return "Passwords must be equals"
            }else if (value.length < 8) {
                return "Password must be 8 characters"
            }
        }
    }
    function handleCPasswordError() {
        let value = cPassword;
        if (value.length > 0) {
            if(value !== password){
                return "Passwords must be equals"
            }else if (value.length < 8) {
                return "Password must be 8 characters"
            }
        }
    }

    return (
        <form>
            <p style={{color:'red'}}> { handleFirstNameError() } </p>
            <div>
                <label>First Name: </label> 
                <input type="text" value={ firstName } onChange={ e => setFirstName(e.target.value) } />
            </div>

            <p style={{color:'red'}}> { handleLastNameError() } </p>
            <div>
                <label>Last Name: </label> 
                <input type="text" value={ lastName } onChange={ e => setLastName(e.target.value) } />
            </div>

            <p style={{color:'red'}}> { handleEmailError() } </p>
            <div>
                <label>Email Address: </label> 
                <input type="email" value={ email } onChange={ e => setEmail(e.target.value) } />
            </div>

            <p style={{color:'red'}}> { handlePasswordError() } </p>
            <div>
                <label>Password: </label>
                <input type="password" value={ password } onChange={ e => setPassword(e.target.value) } />
            </div>

            <p style={{color:'red'}}> { handleCPasswordError() } </p>
            <div>
                <label>Confirm Password: </label>
                <input type="password" value={ cPassword } onChange={ e => setCPassword(e.target.value) } />
            </div>
        </form>
    )
}

export default Form