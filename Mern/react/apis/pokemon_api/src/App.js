import React, { useState } from 'react'
import './App.css';

function App() {

    const [pokemons, setPokemons] = useState([]);

    function fetchPokemons(){
        fetch("https://pokeapi.co/api/v2/pokemon/?limit=807")
        .then(data=>data.json())
        .then(data=>setPokemons(data.results))
        .catch(e=>console.log(e))
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
