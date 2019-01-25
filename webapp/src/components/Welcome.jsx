import React from 'react'
import BaseComponent from './BaseComponent'
import { Link } from 'react-router-dom'

export default class Welcome extends BaseComponent {

    constructor(props) {
        super(props)
    }

    render() {
        const user = this.appData.user.firstName.substr(0, 1) + '. ' + this.appData.user.lastName

        return (
            <nav>
                <h1>Welcome {user}!</h1>
                <ul>
                    <li><Link to='/'>Welcome</Link></li>
                    <li><Link to='/hotels'>Hotels</Link></li>
                    <li><Link to='/new'>New Hotel</Link></li>
                </ul>
            </nav>
        )
    }
}