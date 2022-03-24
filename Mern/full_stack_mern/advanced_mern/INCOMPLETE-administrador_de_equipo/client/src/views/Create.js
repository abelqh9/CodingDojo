import React, { useState } from 'react'
import axios from "axios"
import { Link, useNavigate } from 'react-router-dom';
import AuthorForm from '../components/AuthorForm/AuthorForm'
import ErrorList from '../components/ErrorList/ErrorList';

function Create() {

    let navigate = useNavigate();

    const [errors, setErrors] = useState([])

    function submitHandler(e) {
        e.preventDefault();
        let { name } = e.target;
        axios.post("http://localhost:8000/api/players/new", { name: name.value, position: position.value })
        .then(res => navigate("/players/list"))
        .catch(err => {
            let errorResponse = err.response.data.errors, errorsArr = [];
            for (const key in errorResponse) {errorsArr.push(errorResponse[key].message)}
            setErrors(errorsArr);
        })
    }

    return (
        <main>
            <h1>
                <NavLink 
                    to={"/players/list"} 
                    style={({ isActive }) => isActive ? {fontWeight:"bold"} : undefined}>
                    List
                </NavLink>
                <NavLink 
                    to={"/players/addplayer"} 
                    style={({ isActive }) => isActive ? {fontWeight:"bold"} : undefined}>
                    List
                </NavLink>
            </h1>
            <h2>Add Player</h2>
            {errors.length > 0 && <ErrorList errors={errors}/>}
            <AuthorForm nameInitialValue={""} positionInitialValue={""} submitHandler={submitHandler}/>
        </main>
    )
}

export default Create