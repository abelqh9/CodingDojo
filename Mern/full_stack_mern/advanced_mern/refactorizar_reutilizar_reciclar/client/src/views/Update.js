import React, { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom'
import ProductForm from '../components/ProductForm/ProductForm';
import axios from 'axios'
import { useNavigate } from 'react-router-dom';

function Update() {

    let { id } = useParams();

    let navigate = useNavigate();

    const [product, setProduct] = useState("");

    useEffect(() => {
        axios.get('http://localhost:8000/api/products/' + id)
            .then(res => setProduct(res.data[0]))
    }, [])

    function submitHandler(e) {
        e.preventDefault();
        let {title, price, description} = e.target
        axios.put('http://localhost:8000/api/products/' + id, {title: title.value, price: price.value, description: description.value})
        .then(res => navigate("/products"))
        .catch(err=> console.log(err))
    }

    return (
        <>
            <h2>Edit {product.title} Product</h2>
            {product && (
                <ProductForm  titleInitialValue={product.title} priceInitialValue={product.price} descriptionValue={product.description} submitHandler={submitHandler}/>
            )}
        </>
    )
}

export default Update