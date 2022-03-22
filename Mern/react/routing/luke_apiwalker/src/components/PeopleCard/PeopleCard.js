import React from 'react'

function PeopleCard(props) {

    let { item } = props;

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

export default PeopleCard