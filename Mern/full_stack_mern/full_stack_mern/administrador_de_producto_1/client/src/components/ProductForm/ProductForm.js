import React, { useState } from 'react'
import axios from 'axios'
import "./ProductForm.css"

function ProductForm() {

    const [title, setTitle] = useState("");
    const [price, setPrice] = useState(0);
    const [description, setDescription] = useState("");

    function formHandler(e) {
        e.preventDefault();
        axios.post("http://localhost:8000/products/new", {title, price, description})
        .then(res=>console.log(res))
        .then(()=>{setTitle(""); setPrice(0); setDescription("")})
        .catch(err=>console.log(err))
    }

    return (
        <form className="ProductForm" onSubmit={formHandler}>
            <div>
                <label htmlFor="title">Title</label>
                <input type="text" name='title' id='title' value={title} onChange={e=>setTitle(e.target.value)}/>
            </div>
            <div>
                <label htmlFor="price">Price</label>
                <input type="number" name='price' id='price' value={price} onChange={e=>setPrice(e.target.value)}/>
            </div>
            <div>
                <label htmlFor="description">Description</label>
                <textarea name="description" id="description" value={description} onChange={e=>setDescription(e.target.value)}></textarea>
            </div>
            <button className='btn btn-primary' type="submit">Create</button>
        </form>
    )
}

export default ProductForm