import React, { Component } from 'react'
import '../styles/PersonCard.css'

export default class PersonCard extends Component {

    render() {

        let { name, age, hairColor } = this.props;

        return (
            <div className='PersonCard'>
                <h2>{name}</h2>
                <ul>
                    <li>Age: {age}</li>
                    <li>Hair Color: {hairColor}</li>
                </ul>
            </div>
        )
    }
}
