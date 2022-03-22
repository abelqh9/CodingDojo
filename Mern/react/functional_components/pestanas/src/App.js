import React, { useState } from 'react';
import Pestanias from './components/Pestanias/Pestanias';
import './App.css';

function App() {

    const [currentPestania, setCurrentPestania] = useState("Tab 1")

    return (
        <div className="App">
            <Pestanias pestanias={["Tap 1", "Tap 2", "Tap 3", "Tap 4"]} setCurrentPestania={setCurrentPestania}/>
            <div className='PestaniasView'>{currentPestania} content is showing here.</div>
        </div>
    );
}

export default App;
