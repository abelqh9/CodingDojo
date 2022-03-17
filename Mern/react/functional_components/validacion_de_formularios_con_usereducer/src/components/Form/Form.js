import React, { useReducer } from 'react'
import './Form.css'

const initialState = {
    firstName: "",
    lastName: "",
    email: ""
};

function reducer(state, action) {
    console.log(action);
    return {
        ...state,
        [action.type]: action.payload
    };
}

const Form = () => {

    const [state, dispatch] = useReducer(reducer, initialState);

    function handleChange(e) {
        const { name, value } = e.target;
        dispatch({
            type: name,
            payload: value
        });
    }

    // INPUT ONCHANGE HANDLERS
    function handleFirstNameError() {
        let value = state.firstName;
        if (value.length > 0) {
            if (value.length < 2) {
                return "First Name must be 2 characters";
            }
        }
    }
    function handleLastNameError() {
        let value = state.lastName;
        if (value.length > 0) {
            if (value.length < 2) {
                return "Last Name must be 2 characters"
            }
        }
    }
    function handleEmailError() {
        let value = state.email;
        if (value.length > 0) {
            if (value.length < 5) {
                return "Email must be 5 characters"
            }
        }
    }

    return (
        <form>
            <p style={{color:'red'}}> { handleFirstNameError() } </p>
            <div>
                <label>First Name: </label> 
                <input type="text" name="firstName" value={ state.firstName } onChange={ handleChange } />
            </div>

            <p style={{color:'red'}}> { handleLastNameError() } </p>
            <div>
                <label>Last Name: </label> 
                <input type="text" name="lastName" value={ state.lastName } onChange={ handleChange } />
            </div>

            <p style={{color:'red'}}> { handleEmailError() } </p>
            <div>
                <label>Email Address: </label> 
                <input type="email" name="email" value={ state.email } onChange={ handleChange } />
            </div>
        </form>
    )
}

export default Form