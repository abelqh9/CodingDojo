import React from 'react'
import axios from 'axios'
import "./DeleteAuthorButton.css"

function DeleteAuthorButton(props) {

    let { id, successCallback  } = props

    function deleteAuthor() {
        axios.delete("http://localhost:8000/api/authors/" + id)
        .then(result => successCallback())
        .catch(err => console.log(err))
    }

    return (
        <button className='btn btn-danger' onClick={e=>deleteAuthor()}>Delete</button>
    )
}

export default DeleteAuthorButton