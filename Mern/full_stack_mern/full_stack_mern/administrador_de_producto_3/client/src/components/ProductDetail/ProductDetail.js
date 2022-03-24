import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'

function ProductDetail(props) {
    
    let navigate = useNavigate();

    let { id } = props

    const [product, setProduct] = useState({})


    useEffect(() => {
        axios.get(`http://localhost:8000/api/products/${id}`)
            .then(product=>setProduct(product.data[0]))
            .catch(err=>console.log(err))
    }, [])

    function deleteProduct(id) {
        axios.delete("http://localhost:8000/api/products/"+id)
        .then(result=>navigate("/products"))
        .catch(err=>console.log(err))
    }

    return (
        <div>
            <h2>{product.title}</h2>
            <ul>
                <li>Price: ${product.price}</li>
                <li>Description: {product.description}</li>
            </ul>
            <button className='btn btn-danger' onClick={e=>deleteProduct(product._id)}>Delete</button>
        </div>
    )
}

export default ProductDetail