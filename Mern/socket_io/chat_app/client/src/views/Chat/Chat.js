import React, { useState, useEffect } from 'react'
import io from "socket.io-client"
import Message from '../../components/Message/Message'
import "./Chat.css"

function Chat(props) {

    let { user } = props 

    const [socket] = useState(io(":8000"))
    const [messages, setMessages] = useState([])
    const [messageToSend, setMessageToSend] = useState("")

    useEffect(() => {
        socket.on("reciveMessage", data =>{
            setMessages(oldMessages=>{
                return [...oldMessages, data]
            })
        })
    }, [])

    function sendHandler(e){
        e.preventDefault();
        socket.emit("sendMessage", {author_name: user.name, text: messageToSend})
        setMessageToSend("")
    }

    return (
        <main className='Chat'>
            <div className='messagesContainer'>
                {
                    messages.map(message=>{
                        return <Message name = {message.author_name} text = {message.text} user = {user}/>
                    })
                }
            </div>
            <form className='formContainer' onSubmit={sendHandler}>
                <input type="text" value={messageToSend} onChange={e=>setMessageToSend(e.target.value)} />
                <button type="submit" className='btn btn-primary'> send </button>
            </form>
        </main>
    )
}

export default Chat