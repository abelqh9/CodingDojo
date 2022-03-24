import React from 'react'
import { BrowserRouter, Routes, Route} from "react-router-dom";
import Main from "./views/Main";
import Create from "./views/Create";
import Update from './views/Update';
import './App.css';
import NotFound from './views/NotFound';

function App() {
    return (
        <div className="App">
            <h1>Authors App</h1>
            <BrowserRouter>
                <Routes>
                    <Route path="/authors" element={<Main />} />
                    <Route path="/authors/new" element={<Create />} />
                    <Route path="/authors/:id/edit" element={<Update />} />
                    <Route path="/notFound" element={<NotFound />} />
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
