import axios from 'axios'
import React, { useEffect, useState } from 'react'

function ProductDetail(props) {

    const [product, setProduct] = useState({})

    let { id } = props

    useEffect(() => {
        axios.get(`http://localhost:8000/api/products/${id}`)
            .then(product=>setProduct(product.data[0]))
            .catch(err=>console.log(err))
    }, [])

    return (
        <div>
            <h2>{product.title}</h2>
            <ul>
                <li>Price: ${product.price}</li>
                <li>Description: {product.description}</li>
            </ul>
        </div>
    )
}

export default ProductDetail