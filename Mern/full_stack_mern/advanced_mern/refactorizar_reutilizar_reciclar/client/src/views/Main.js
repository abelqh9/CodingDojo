import React, { useState, useEffect } from 'react'
import axios from 'axios';
import ProductsList from '../components/ProductsList/ProductsList'
import ProductForm from '../components/ProductForm/ProductForm';

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

    function submitHandler(e) {
        e.preventDefault();
        let {title, price, description} = e.target;
        axios.post("http://localhost:8000/api/products/new", {title: title.value, price: price.value, description: description.value})
        .then(res => addProductToDom(res.data))
        .catch(err => console.log(err))
    }
    
    return (
        <>
            <h1>Product Maneger</h1>
            <h2>Add A Product</h2>
            <ProductForm titleInitialValue={""} priceInitialValue={0} descriptionValue={""} submitHandler={submitHandler}/>
            <ProductsList products={products} removeProductFromDom={removeProductFromDom}/>
        </>
    )
}

export default Main