import React from 'react'
import { Link } from 'react-router-dom'

function NotFound() {
    return (
        <>
            <p style={{color:"red"}}>Sorry, we cannot find the search author. ¿do you want to add this author to the db?</p>
            <Link to={"/authors/new"}>Add an author</Link>
        </>
    )
}

export default NotFound