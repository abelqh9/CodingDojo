import React, { useState, useEffect } from 'react'
import axios from 'axios';
import ProductAddForm from '../components/ProductAddForm/ProductAddForm'
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

    function removeProductFromDom(id) {
        setProducts(oldState=>oldState.filter(product => product._id !== id));
    }
    
    return (
        <>
            <h1>Product Maneger</h1>
            <ProductAddForm addProductToDom={addProductToDom}/>
            <ProductsList products={products} removeProductFromDom={removeProductFromDom}/>
        </>
    )
}

export default Main