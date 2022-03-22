import React from 'react'

function PlanetCard(props) {

    let { item } = props;

    return (
        <div>
            <h1>{item.name}</h1>
            <ul>
                <li>Terrain: {item.terrain}</li>
                <li>Population: {item.population}</li>
                <li>Gravity: {item.gravity}</li>
                <li>Diameter: {item.diameter}</li>
            </ul>
        </div>
    )
}

export default PlanetCard