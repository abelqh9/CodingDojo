import React, { useState } from 'react'
import './App.css';
import Header from './components/Header/Header';
// import Chat from './views/Chat/Chat';
import Chat from './views/Chat/Chat';
import Register from './views/Register/Register';

function App() {
    const [user, setUser] = useState(false)
    
    return (
        <div className="App">
            <Header />
            {user ? <Chat user={user}/> : <Register setUser={setUser} /> }
        </div>
  );
}

export default App;