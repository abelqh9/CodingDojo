import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import DeleteProductButton from '../DeleteProductButton/DeleteProductButton';

function ProductDetail(props) {
    
    let navigate = useNavigate();

    let { id } = props

    const [product, setProduct] = useState({})

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
            <DeleteProductButton id={ id } successCallback={()=> navigate("/products")}/>
        </div>
    )
}

export default ProductDetail