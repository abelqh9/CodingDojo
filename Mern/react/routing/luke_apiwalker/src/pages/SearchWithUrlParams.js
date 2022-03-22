import React, { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom'
import PeopleCard from '../components/PeopleCard/PeopleCard'

function SearchWithUrlParams() {

    let { id } = useParams()

    const [item, setItem] = useState(undefined)

    useEffect(() => {
        fetch(`https://swapi.dev/api/${"people"}/${id}?format=json`)
        .then(data=>data.json()).then(item=>setItem(item))
        .catch(e=>console.log(e))
    }, [])

    return (
        <div>
            {item ? <PeopleCard item={item}/> : ""}
        </div>
    )
}

export default SearchWithUrlParams