import React from 'react'
import axios from 'axios'
import "./DeleteProductButton.css"

function DeleteProductButton(props) {

    let { id, successCallback  } = props

    function deleteProduct() {
        axios.delete("http://localhost:8000/api/products/" + id)
        .then(result => successCallback())
        .catch(err => console.log(err))
    }

    return (
        <button className='btn btn-danger' onClick={e=>deleteProduct()}>Delete</button>
    )
}

export default DeleteProductButton