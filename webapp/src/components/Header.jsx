import React from 'react'
import BaseComponent from './BaseComponent'
import { Link } from 'react-router-dom'

export default class Header extends BaseComponent {

    constructor(props) {
        super(props)
    }

    render() {
        const navi = this.appData.isLoggedIn ? (
                <nav>
                    <a href='#/'>Welcome</a> |
                    <a href='#/hotels'>Hotels</a>
                </nav>) : null

        return (
            <header>
                <div className='logo'>
                    {navi}
                </div>
            </header>)
    }
}
