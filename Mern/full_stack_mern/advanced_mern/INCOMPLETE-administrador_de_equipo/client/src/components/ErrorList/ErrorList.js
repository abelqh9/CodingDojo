import React from 'react'
import './ErrorList.css'

function ErrorList(props) {

    let { errors } = props

    return (
        <ul className='ErrorList'>
            {errors.map((e,i) => <li key={i}>{e}</li> )}
        </ul>
    )
}

export default ErrorList