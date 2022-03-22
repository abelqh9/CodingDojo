import React, { useState, useEffect } from 'react'
import { capitalizeFirstLetter } from '../../helpers/capitalizeFirstLetter';
import './AppForm.css'

function AppForm(props) {

    let { category, setCategory, id, setId, setItem } = props

    const [categories, setCategories] = useState([]);

    useEffect(() => {
        fetch("https://swapi.dev/api/?format=json")
        .then(data=>data.json()).then(data=>setCategories(Object.keys(data)))
        .catch(e=>console.log(e))
    }, [])

    function formHandler(e) {
        e.preventDefault();
        fetch(`https://swapi.dev/api/${category}/${id}?format=json`)
        .then(data=>data.json()).then(item=>setItem(item))
        .catch(e=>console.log(e))
    }

    return (
        <form className='AppForm' onSubmit={formHandler}>
            <label htmlFor="category">Search for:</label>
            <select id="category" onChange={e=>setCategory(e.target.value)}>
                {
                    categories.map((c,i)=><option key={i} value={c}>{capitalizeFirstLetter(c)}</option> )
                }
            </select>
            <label htmlFor="id">Id:</label>
            <input id="id" type="number" value={id} onChange={e=>setId(e.target.value)}/>
            <button type="submit">Search</button>
        </form>
    )
}

export default AppForm