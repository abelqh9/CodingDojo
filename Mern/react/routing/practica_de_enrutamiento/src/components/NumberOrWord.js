import React from 'react'
import { useParams } from 'react-router-dom'

function Number() {

    let { numberOrWord } = useParams()

    return (
        <h1>
            {
                isNaN(numberOrWord)
                ? <h1>The word is: {numberOrWord}</h1>
                : <h1>The number is: {numberOrWord}</h1>
            }
        </h1>
    )
}

export default Number