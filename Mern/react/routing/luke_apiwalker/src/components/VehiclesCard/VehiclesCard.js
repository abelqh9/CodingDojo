import React from 'react'

function VehiclesCard(props) {

    let { item } = props;

    return (
        <div>
            <h1>{item.name}</h1>
            <ul>
                <li>Model: {item.model}</li>
                <li>Cost in credits: {item.cost_in_credits}</li>
                <li>Cargo capacity: {item.cargo_capacity}</li>
                <li>Passengers: {item.passengers}</li>
            </ul>
        </div>
    )
}

export default VehiclesCard