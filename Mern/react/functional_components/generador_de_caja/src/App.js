import React, { useState } from 'react'
import './App.css';
import BoxesContainer from './components/BoxesContainer/BoxesContainer';
import ColorForm from './components/ColorForm/ColorForm';

function App() {

    const [boxes, setBoxes] = useState([]);

    return (
        <div className="App">
            <ColorForm setBoxes={setBoxes}/>
            <BoxesContainer boxes={boxes}/>
        </div>
    );
}

export default App;