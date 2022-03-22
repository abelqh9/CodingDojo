import React from 'react'
import { BrowserRouter as Router, Routes, Route,} from 'react-router-dom'
import './App.css';
import SearchWithForm from './pages/SearchWithForm';
import SearchWithUrlParams from './pages/SearchWithUrlParams';

function App() {
    return (
        <div className="App">
            <Router>
                <Routes>
                    <Route path='/' element={<SearchWithForm />} />
                    <Route path='/:id' element={<SearchWithUrlParams />} />
                </Routes>
            </Router>
        </div>
    );
}

export default App;
