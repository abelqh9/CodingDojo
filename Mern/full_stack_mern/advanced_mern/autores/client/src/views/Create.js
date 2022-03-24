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
        axios.post("http://localhost:8000/api/authors/new", { name: name.value })
        .then(res => navigate("/authors"))
        .catch(err => {
            let errorResponse = err.response.data.errors, errorsArr = [];
            for (const key in errorResponse) {errorsArr.push(errorResponse[key].message)}
            setErrors(errorsArr);
        })
    }

    return (
        <main>
            <Link to={"/authors"}>Home</Link>
            <p>Add a new author: </p>
            {errors.length > 0 && <ErrorList errors={errors}/>}
            <AuthorForm nameInitialValue={""} submitHandler={submitHandler}/>
        </main>
    )
}

export default Create