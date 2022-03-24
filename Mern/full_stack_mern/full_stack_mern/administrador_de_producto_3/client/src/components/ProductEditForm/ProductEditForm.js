import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom';
import axios from 'axios'
import "./ProductEditForm.css"

function ProductEditForm(props) {

    let { id } = props;

    let navigate = useNavigate();

    const [title, setTitle] = useState("");
    const [price, setPrice] = useState(0);
    const [description, setDescription] = useState("");

    useEffect(() => {
        axios.get('http://localhost:8000/api/products/' + id)
            .then(res => {
                setTitle(res.data[0].title);
                setPrice(res.data[0].price);
                setDescription(res.data[0].description);
            })
    }, [])

    function formHandler(e) {
        e.preventDefault();
        axios.put('http://localhost:8000/api/products/' + id, {title, price, description})
        .then(res => navigate("/products"))
        .catch(err=> console.log(err))
    }

    return (
        <div>
            <h2>Edit {title} Product</h2>
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
        </div>
    )
}

export default ProductEditForm