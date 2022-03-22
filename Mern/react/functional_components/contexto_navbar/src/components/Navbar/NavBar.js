import React, { useContext } from 'react'
import { NameContext } from '../../context/NameContext/NameContext';

function NavBar() {

    let { name } = useContext(NameContext);

    return (
        <nav style={{textAlign:"center"}}>
            <h1>Hi {name}!</h1>
        </nav>
    )
}

export default NavBar