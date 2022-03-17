import './App.css';
import PersonCard from './components/PersonCard';

function App() {
  return (
    <div className="App">
      <PersonCard name={"Doe, Jane"} age ={45} hairColor={"Black"}/>
      <PersonCard name ={"Smith, John"} age ={88} hairColor={"Brown"}/>
      <PersonCard name ={"Fillmore, Millard"} age ={50} hairColor={"Brown"}/>
      <PersonCard name ={"Smith, Maria"} age ={62} hairColor={"Brown"}/>
    </div>
  );
}

export default App;