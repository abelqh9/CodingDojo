import React from 'react'
import DeleteAuthorButton from '../DeleteAuthorButton/DeleteAuthorButton'
import './PlayersBasicTable.css'

function PlayersBasicTable(props) {

    let { players, removeAuthorFromDom } = props

    return (
        <table className="table PlayersBasicTable">
            <thead>
                <tr>
                    <th scope="col">Player Name</th>
                    <th scope="col">Preferred Position</th>
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
                            <td className='buttons-row'>
                                <DeleteAuthorButton id={player._id} successCallback={()=>removeAuthorFromDom(player._id)}/>
                            </td>
                        </tr>
                    )
                })}
            </tbody>
        </table>

    )
}

export default PlayersBasicTable