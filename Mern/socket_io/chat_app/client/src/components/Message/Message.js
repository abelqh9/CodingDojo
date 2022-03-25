import React from 'react'
import "./Message.css"

function Message(props) {

    let { name, text, user } = props

    return (
        <div className={'Message ' + (user.name === name ? "userMessage" : "otherMessage")}>
            <p className='name'>{name} said</p>
            <p className='text'>{text}</p>
        </div>
    )
}

export default Message