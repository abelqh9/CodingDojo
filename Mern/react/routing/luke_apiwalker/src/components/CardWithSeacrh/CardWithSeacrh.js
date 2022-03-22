import React, { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom';
import obiImg from '../../assets/1Dv9.gif'

function CardWithSeacrh() {

    const [item, setItem] = useState("")

    let { id } = useParams();

    useEffect(() => {
        fetch(`https://swapi.dev/api/${"people"}/${id}?format=json`)
        .then(data=>data.json()).then(item=>setItem(item))
        .catch(e=>console.log(e))
    }, [])
    

    if (!item) return null;

    if (item.detail === "Not found") {
        return (
            <div>
                <h1 className='error'>Estos no son los droides que está buscando</h1>
                <img src={obiImg} alt="obi wan" />
            </div>
        )
    }

    return (
        <div>
            <h1>{item.name}</h1>
            <ul>
                <li>Height: {item.height}</li>
                <li>Hair Color: {item.hair_color}</li>
                <li>Birth Year: {item.birth_year}</li>
                <li>Homeworld-url: <a href={item.homeworld}>{item.homeworld}</a></li>
            </ul>
        </div>
    )
    
}

export default CardWithSeacrh