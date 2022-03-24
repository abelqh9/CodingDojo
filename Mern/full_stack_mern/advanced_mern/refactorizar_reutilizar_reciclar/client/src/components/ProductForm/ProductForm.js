import React, { useState } from 'react'
import "./ProductForm.css"

function ProductForm(props) {

    let { titleInitialValue, priceInitialValue, descriptionValue, submitHandler } = props

    const [title, setTitle] = useState(titleInitialValue);
    const [price, setPrice] = useState(priceInitialValue);
    const [description, setDescription] = useState(descriptionValue);

    return (
        <div>
            <form className="ProductForm" onSubmit={e=>{submitHandler(e); setTitle(""); setPrice(0); setDescription("")}}>
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

export default ProductForm