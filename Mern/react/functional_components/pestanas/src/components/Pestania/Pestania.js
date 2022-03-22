import React from 'react'
import './Pestania.css'

export default function Pestania(props) {

    let {name, setCurrentPestania} = props;

    return (
        <li className='Pestania' onClick={e=>setCurrentPestania(e.target.textContent)}>{name}</li>
    )
}
