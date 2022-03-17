import React from 'react'
import './PersonCard.css'

const PersonCard = (props) => {

    let { firstName, lastName, age, hairColor } = props;
    
    return (
      <div className='PersonCard'>
          <h2>{lastName}, {firstName}</h2>
          <ul>
              <li>Age: {age}</li>
              <li>Hair Color: {hairColor}</li>
          </ul>
      </div>
    )
}

export default PersonCard