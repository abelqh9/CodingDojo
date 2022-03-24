import axios from 'axios'
import React from 'react'
import { Link } from 'react-router-dom'
import './ProductsList.css'

function ProductsList(props) {

    let { products, removeProductFromDom } = props

    function deleteProduct(id) {
        axios.delete("http://localhost:8000/api/products/"+id)
        .then(result=>removeProductFromDom(id))
        .catch(err=>console.log(err))
    }

    return (
        <div className='ProductsList'>
            <h2>All Products</h2>
            <ul>
                {products.map((p, i) => { 
                    return <li key={i}>
                        <Link style={{width:"5rem"}} to={p._id} t>{p.title}</Link>
                        -
                        <Link to={p._id+"/edit"} t>edit</Link>
                        -
                        <button className='btn btn-danger' onClick={e=>deleteProduct(p._id)}>Delete</button>
                    </li>
                })}
            </ul>
        </div>
    )
}

export default ProductsList