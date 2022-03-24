import React, { useState, useEffect } from 'react'
import axios from 'axios';
import { NavLink } from 'react-router-dom';
import PlayersBasicTable from '../components/PlayersTable/PlayersTable';

function Main2() {

    const [players, setPlayers] = useState([])

    useEffect(() => {
        axios.get("http://localhost:8000/api/players")
            .then(players=>setPlayers(players.data))
            .catch(err=>console.log(err))
    }, [])

    function removePlayerFromDom(id) {
        setPlayers(oldState=>oldState.filter(player => player._id !== id));
    }
    
    return (
        <main>
            <h1>
                <NavLink 
                    to={"/players/list"} 
                    style={({ isActive }) => isActive ? {fontWeight:"bold"} : undefined}>
                    List
                </NavLink>
                <NavLink 
                    to={"/players/addplayer"} 
                    style={({ isActive }) => isActive ? {fontWeight:"bold"} : undefined}>
                    List
                </NavLink>
            </h1>
            <PlayersBasicTable players={players} removePlayerFromDom={removePlayerFromDom}/>
        </main>
    )
}

export default Main2