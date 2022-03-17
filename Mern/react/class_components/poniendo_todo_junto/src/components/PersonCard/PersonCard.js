import React, { Component } from 'react'
import './PersonCard.css'

export default class PersonCard extends Component {

    constructor(props){
        super(props);
        this.state = {
            age: props.age
        };
    }

    moreAge = () =>{
        this.setState({ age: this.state.age + 1 })
    }

    render() {

        let { firstName, lastName, hairColor } = this.props;
        let { age } = this.state;

        return (
            <div className='PersonCard'>
                <h2>{lastName}, {firstName}</h2>
                <ul>
                    <li>Age: {age}</li>
                    <li>Hair Color: {hairColor}</li>
                </ul>
                <button onClick={this.moreAge}>Birthday Button for {firstName} {lastName}</button>
            </div>
        )
    }
}
