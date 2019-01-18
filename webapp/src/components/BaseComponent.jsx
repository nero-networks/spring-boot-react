import React from 'react'
import { appData } from '../app'

export default class BaseComponent extends React.Component {

    constructor(props) {
        super(props)
        this.state = {}
        this.appData = appData
    }

    updateStateValue(key, value) {
        const state = {}
        Object.keys(this.state).forEach(k => state[k] = this.state[k])

        this._addStateValue(state, key, value)

        this.setState(state)
    }

    onError(err) {
        console.error(err)
        alert(err.message || err || 'Unknown Error') // TODO !
    }

    _addStateValue(state, key, value) {
        if(key.match('[.]')) {
            const parts = key.split('.')
            tempKey = parts.shift()

            tempState = state[tempKey]
            if(!tempState) {
                tempState = state[tempKey] = {}
            }

            this._addStateValue(tempState, parts.join('.'), value)

        } else {
            state[key] = value
        }
    }
}
