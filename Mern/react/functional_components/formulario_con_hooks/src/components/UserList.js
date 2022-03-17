import React from 'react'

const UserList = (props) => {

    let { firstName, lastName, email, password, cPassword } = props;

    return (
        <ul>
            <li><b>First Name: </b>{firstName}</li>
            <li><b>Last Name: </b>{lastName}</li>
            <li><b>Email Address: </b>{email}</li>
            <li><b>Password: </b>{password}</li>
            <li><b>Confirm Password: </b>{cPassword}</li>
        </ul>
    )
}

export default UserList