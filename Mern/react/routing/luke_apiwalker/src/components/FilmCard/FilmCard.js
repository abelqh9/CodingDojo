import React from 'react'

function FilmCard(props) {

    let { item } = props;

    return (
        <div>
            <h1>{item.title}</h1>
            <ul>
                <li>Director: {item.director}</li>
                <li>Episode id: {item.episode_id}</li>
                <li>Release date: {item.release_date}</li>
                <li>Opening crawl: {item.opening_crawl}</li>
            </ul>
        </div>
    )
}

export default FilmCard