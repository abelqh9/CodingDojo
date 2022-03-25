import React, { useState, useEffect } from 'react'
import io from "socket.io-client"
import './App.css';

function App() {
    
    const [socket] = useState(io(":8000"))

    useEffect(() => {
        socket.on("serverSaysHello", data =>{
            console.log(data);
        })
    }, [])
    
    return (
        <div className="App">
            <h1>Socket Test</h1>
        </div>
  );
}

export default App;