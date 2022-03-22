import React from 'react'

function SpeciesCard(props) {

    let { item } = props;

    return (
        <div>
            <h1>{item.name}</h1>
            <ul>
                <li>Language: {item.language}</li>
                <li>Skin colors: {item.skin_colors}</li>
                <li>Average height: {item.average_height}</li>
                <li>Average lifespan: {item.average_lifespan}</li>
            </ul>
        </div>
    )
}

export default SpeciesCard