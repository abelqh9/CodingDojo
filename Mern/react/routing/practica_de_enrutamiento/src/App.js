import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Welcome from './components/Welcome';
import WordWithColor from './components/WordWithColor';
import './App.css';
import NumberOrWord from './components/NumberOrWord';

function App() {
    return (
        <div className="App">
            <BrowserRouter>
                <Routes>
                    <Route path='/' element={<Welcome/>}/>
                    <Route path='/:numberOrWord' element={<NumberOrWord/>}/>
                    <Route path='/:word/:color/:backgroundColor' element={<WordWithColor/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    );
}
export default App;
