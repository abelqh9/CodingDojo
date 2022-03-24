import React from 'react'
import { BrowserRouter, Routes, Route, NavLink, useLocation} from "react-router-dom";
import Main from "./views/Main";
import Create from "./views/Create";
import './App.css';

function App() {
    
    let { pathname } = useLocation();

    return (
        <div className="App">
            <BrowserRouter>
                <NavLink 
                    to={"/players/list"} 
                    style={['/players/list', '/players/addplayer'].includes(pathname) ? {fontWeight:"bold"} : undefined}>
                    Manage Players
                </NavLink>
                <NavLink 
                    to={"/status/game/1"} 
                    style={['/status/game/1', '/status/game/2', '/status/game/3'].includes(pathname) ? {fontWeight:"bold"} : undefined}>
                    Manage Player Status
                </NavLink>
                <Routes>
                    <Route path="/players/list" element={<Main />} />
                    <Route path="/players/addplayer" element={<Create />} />
                    <Route path="/status/game/:id" element={<Create />} />
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
