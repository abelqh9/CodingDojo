import React from 'react'
import './BoxesContainer.css'

export default function BoxesContainer(props) {

    let { boxes } = props;

    return (
        <div className='BoxesContainer'>
            {
                boxes.map((color, i) => <div style={{backgroundColor: color, width: "10rem", height:"10rem"}} key={i}></div>)
            }
        </div>
    )
}