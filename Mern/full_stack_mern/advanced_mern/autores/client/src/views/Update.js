import React, { useState, useEffect } from 'react'
import { Link, useParams } from 'react-router-dom'
import AuthorForm from '../components/AuthorForm/AuthorForm';
import axios from 'axios'
import { useNavigate } from 'react-router-dom';
import ErrorList from '../components/ErrorList/ErrorList';

function Update() {

    let { id } = useParams();

    let navigate = useNavigate();

    const [author, setAuthor] = useState(false);
    const [errors, setErrors] = useState([])

    useEffect(() => {
        axios.get('http://localhost:8000/api/authors/' + id)
            .then(res => setAuthor(res.data[0]))
            .catch(err => navigate("/notFound"))
    }, [])

    function submitHandler(e) {
        e.preventDefault();
        let { name } = e.target
        axios.put('http://localhost:8000/api/authors/' + id, { name: name.value })
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
            <p>Edit this author</p>
            {errors.length > 0 && <ErrorList errors={errors}/>}
            {author && <AuthorForm  nameInitialValue={author.name} submitHandler={submitHandler}/>}
        </main>
    )
}

export default Update