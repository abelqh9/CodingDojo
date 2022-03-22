import './App.css';
import FormWrapper from './components/FormWrapper/FormWrapper';
import NavBar from './components/Navbar/NavBar';
import Wrapper from './components/Wrapper/Wrapper';
import NameProvider from './context/NameContext/NameContext';

function App() {
    return (
        <div className="App">
            <NameProvider>
                <Wrapper>
                    <NavBar/>
                    <FormWrapper/>
                </Wrapper>
            </NameProvider>
        </div>
    );
}


export default App;
