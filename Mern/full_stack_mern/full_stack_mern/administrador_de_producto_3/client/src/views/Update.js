import React from 'react'
import { useParams } from 'react-router-dom'
import ProductEditForm from '../components/ProductEditForm/ProductEditForm';

function Update() {

    let { id } = useParams();

    return (
        <>
            <ProductEditForm id={id}/>
        </>
    )
}

export default Update