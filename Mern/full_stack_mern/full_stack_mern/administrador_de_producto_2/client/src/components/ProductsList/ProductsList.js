import React from 'react'

function ProductsList(props) {

    let { products } = props

    return (
        <div>
            <h2>All Products</h2>
            <ul>
                {products.map((p, i) => <li key={i}><a href={"products/"+p._id}>{p.title}</a></li>)}
            </ul>
        </div>
    )
}

export default ProductsList