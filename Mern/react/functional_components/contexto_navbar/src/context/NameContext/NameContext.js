import { useState, createContext } from 'react'

let NameContext = createContext();

function NameProvider({children}) {

    const [name, setName] = useState("");

    let data = {name, setName};

    return (
        <NameContext.Provider value={data}>
            {children}
        </NameContext.Provider>
    );
}

export default NameProvider;
export { NameContext };