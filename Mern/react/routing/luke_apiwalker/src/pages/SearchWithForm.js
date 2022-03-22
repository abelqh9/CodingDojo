import React, {useState} from 'react'
import AppForm from '../components/AppForm/AppForm'
import FilmCard from '../components/FilmCard/FilmCard';
import NotFound from '../components/NotFound/NotFound';
import PeopleCard from '../components/PeopleCard/PeopleCard';
import PlanetCard from '../components/PlanetCard/PlanetCard';
import SpeciesCard from '../components/SpeciesCard/SpeciesCard';
import StarshipCard from '../components/StarshipCard/StarshipCard';
import VehiclesCard from '../components/VehiclesCard/VehiclesCard';

function SearchWithForm() {

    const [item, setItem] = useState(undefined)
    const [category, setCategory] = useState("people");
    const [id, setId] = useState("");

    return(
        <div>
            <AppForm  category={category} setCategory={setCategory} id={id} setId={setId} setItem={setItem}/>
            
            {item && 
                (item.detail === "Not found" ? <NotFound />
                    :
                        category === "people" ? <PeopleCard item={item}/> :
                        category === "planets" ? <PlanetCard item={item}/>:
                        category === "films" ? <FilmCard item={item}/>:
                        category === "species" ? <SpeciesCard item={item}/>:
                        category === "vehicles" ? <VehiclesCard item={item}/>:
                        category === "starships" ? <StarshipCard item={item}/>:null)
            }
        </div>
    )
    
}

export default SearchWithForm