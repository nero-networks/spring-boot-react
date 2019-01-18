import React from 'react'
import ReactDOM from 'react-dom'
import PageContainer from './components/PageContainer'
import Http from './tools/HttpClient'

import './styles.scss'
import 'react-table/react-table.css'

// this is a global configuration bucket which is imported
// and assigned to every component extending BaseComponent
const appData = {
    isLoggedIn: false,

}

export { appData }

// request authentication status
Http.getJSON('/api/v1/auth').then(status => {
    const container = document.querySelector('#container')

    if(status.loggedIn) {
        appData.isLoggedIn = true
        appData.user = status.user
    }

    ReactDOM.render(<PageContainer />, container)
})
