import React from 'react'
import BaseComponent from './BaseComponent'
import Header from './Header'
import LoginForm from './LoginForm'
import Http from '../tools/HttpClient'

import { HashRouter, Switch, Route } from 'react-router-dom'
import Welcome from './Welcome'
import HotelTable from './hotel/HotelTable'
import HotelForm from './hotel/HotelForm'

export default class PageContainer extends BaseComponent {

    constructor(props) {
        super(props)
    }

    render() {
        const content = this.appData.isLoggedIn ? (
            <HashRouter>
                <Switch>
                    <Route exact path='/' component={Welcome} />
                    <Route path='/hotels' component={HotelTable} />
                    <Route path='/new' component={HotelForm} />
                </Switch>
            </HashRouter>) : null

        return (
            <div>
                <Header />
                <LoginForm />
                {content}
            </div>
        )
    }

}