import React from 'react'
import { Link } from 'react-router-dom'
import DeleteProductButton from '../DeleteProductButton/DeleteProductButton'
import './ProductsList.css'

function ProductsList(props) {

    let { products, removeProductFromDom } = props

    return (
        <div className='ProductsList'>
            <h2>All Products</h2>
            <ul>
                {products.map((p, i) => { 
                    return <li key={i}>
                        <Link style={{width:"5rem"}} to={p._id}>{p.title}</Link>
                        -
                        <Link to={p._id+"/edit"}>edit</Link>
                        -
                        <DeleteProductButton id={p._id} successCallback={()=>removeProductFromDom(p._id)}/>
                    </li>
                })}
            </ul>
        </div>
    )
}

export default ProductsList