import React, { useState } from 'react'
import UserForm from './UserForm';
import UserList from './UserList';

const Wrapper = () => {

    const [firstName, setFirstName] = useState("")
    const [lastName, setLastName] = useState("")
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");  
    const [cPassword, setCPassword] = useState("");

    function createUser(e) { e.preventDefault() }

    return (
        <>
            <UserForm 
                firstName={firstName} setFirstName={setFirstName}
                lastName={lastName} setLastName={setLastName}
                email={email} setEmail={setEmail}
                password={password} setPassword={setPassword}
                cPassword={cPassword} setCPassword={setCPassword}
                createUser={createUser}
            />

            <UserList 
                firstName={firstName}
                lastName={lastName}
                email={email}
                password={password}
                cPassword={cPassword}
            />
        </>
    )
}

export default Wrapper