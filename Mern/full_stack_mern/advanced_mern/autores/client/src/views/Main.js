import React, { useState, useEffect } from 'react'
import axios from 'axios';
import { Link } from 'react-router-dom';
import AuthorsTable from '../components/AuthorsTable/AuthorsTable';

function Main() {

    const [authors, setAuthors] = useState([])

    useEffect(() => {
        axios.get("http://localhost:8000/api/authors")
            .then(authors=>setAuthors(authors.data))
            .catch(err=>console.log(err))
    }, [])

    function removeAuthorFromDom(id) {
        setAuthors(oldState=>oldState.filter(author => author._id !== id));
    }
    
    return (
        <main>
            <Link to={"new"}>Add a author</Link>
            <p>We have quotes by:</p>
            <AuthorsTable authors={authors} removeAuthorFromDom={removeAuthorFromDom}/>
        </main>
    )
}

export default Main