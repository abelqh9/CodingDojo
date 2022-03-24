import React from 'react'
import DeleteAuthorButton from '../DeleteAuthorButton/DeleteAuthorButton'
import './PlayersByGameTable.css'

function PlayersByGameTable(props) {

    let { players, game } = props

    return (
        <table className="table PlayersBasicTable">
            <thead>
                <tr>
                    <th scope="col">Team Name</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                {players.map((player, i) => { 
                    return(
                        <tr className="align-middle" key={i}>
                            <td>
                                {player.name}
                            </td>
                            <td>
                                {player.position}
                            </td>
                        </tr>
                    )
                })}
            </tbody>
        </table>

    )
}

export default PlayersByGameTable