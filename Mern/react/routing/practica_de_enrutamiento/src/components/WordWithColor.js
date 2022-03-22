import React from 'react'
import { useParams } from 'react-router-dom'

function WordWithColor() {

    let { word, color, backgroundColor } = useParams()

    return (
        <h1 style={{color, backgroundColor}}>The Word is: {word}</h1>
    )
}

export default WordWithColor