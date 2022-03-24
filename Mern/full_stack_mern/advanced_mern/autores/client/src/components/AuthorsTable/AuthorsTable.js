import React from 'react'
import { Link } from 'react-router-dom'
import DeleteAuthorButton from '../DeleteAuthorButton/DeleteAuthorButton'
import './AuthorsTable.css'

function AuthorsTable(props) {

    let { authors, removeAuthorFromDom } = props

    return (
        <table className="table AuthorsTable">
            <thead>
                <tr>
                    <th scope="col">Author</th>
                    <th scope="col">Actions available</th>
                </tr>
            </thead>
            <tbody>
                {authors.map((author, i) => { 
                    return(
                        <tr className="align-middle" key={i}>
                            <td>
                                {author.name}
                            </td>
                            <td className='buttons-row'>
                                <Link className='btn btn-primary' to={author._id+"/edit"}>edit</Link>
                                <DeleteAuthorButton id={author._id} successCallback={()=>removeAuthorFromDom(author._id)}/>
                            </td>
                        </tr>
                    )
                })}
            </tbody>
        </table>

    )
}

export default AuthorsTable