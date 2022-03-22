import React from 'react'
import Pestania from '../Pestania/Pestania';
import './Pestanias.css'

export default function Pestanias(props) {

    let {pestanias, setCurrentPestania} = props;

    return (
        <div className='PestaniasContainer'>
            {
                pestanias.map((p, i)=><Pestania Key={i} name={p} setCurrentPestania={setCurrentPestania}/>)
            }
        </div>
    )

}
