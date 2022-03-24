import React, { useState, useEffect } from 'react'
import axios from 'axios';
import ProductForm from '../components/ProductForm/ProductForm'
import ProductsList from '../components/ProductsList/ProductsList'

function Main() {

    const [products, setProducts] = useState([])

    useEffect(() => {
        axios.get("http://localhost:8000/api/products")
            // .then(products=>console.log(products.data))
            .then(products=>setProducts(products.data))
            .catch(err=>console.log(err))
    }, [])

    function addProductToDom(product) {
        setProducts(oldState => [...oldState, product])
    }
    
    return (
        <>
            <h1>Product Maneger</h1>
            <ProductForm addProductToDom={addProductToDom}/>
            <ProductsList products={products}/>
        </>
    )
}

export default Main