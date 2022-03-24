import React from 'react'
import axios from 'axios'
import "./DeletePlayerButton.css"

function DeletePlayerButton(props) {

    let { id, successCallback  } = props

    function deletePlayer() {
        axios.delete("http://localhost:8000/api/players/" + id)
        .then(result => successCallback())
        .catch(err => console.log(err))
    }

    return (
        <button className='btn btn-danger' onClick={e=>deletePlayer()}>Delete</button>
    )
}

export default DeletePlayerButton