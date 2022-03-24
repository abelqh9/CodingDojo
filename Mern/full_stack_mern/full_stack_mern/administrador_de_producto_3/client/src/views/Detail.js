import React from 'react'
import { useParams } from 'react-router-dom'
import ProductDetail from '../components/ProductDetail/ProductDetail'

function Detail() {

    let { id } = useParams()

    return (
        <>
            <ProductDetail id={id}/>
        </>
    )
}

export default Detail