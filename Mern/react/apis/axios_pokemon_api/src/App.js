import React, { useState } from 'react'
import axios from 'axios';
import './App.css';

function App() {

    const [pokemons, setPokemons] = useState([]);

    function fetchPokemons(){
        axios.get("https://pokeapi.co/api/v2/pokemon/?limit=807")
        .then(data=>data.data)
        .then(data=>setPokemons(data.results))
    }

    return (
        <div className="App">
            <button onClick={fetchPokemons}>Fetch Pokemons</button>
            <ul>
                {
                    pokemons.map((p,i)=>{
                        return <li key={i}>{p.name} - {i}</li>
                    })
                }
            </ul>
        </div>
    );
}

export default App;
