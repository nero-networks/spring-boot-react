import React from 'react'
import BaseComponent from './BaseComponent'
import Http from '../tools/HttpClient'

export default class LoginForm extends BaseComponent {

    constructor(props) {
        super(props)
    }

    render() {
        if(this.appData.isLoggedIn)
            return <button className="logout"
                onClick={this.doLogout.bind(this)}>Logout</button>

        else
            return (
                <form onSubmit={this.doLogin.bind(this)}>
                    <input type="text" name="username" placeholder="Username"
                        onChange={e => this.updateStateValue('username', e.target.value)} />
                    <input type="password" name="password" placeholder="Password"
                        onChange={e => this.updateStateValue('password', e.target.value)} />
                    <button>Login</button>
                    <div ref={r => this.errorText = r}/>
                </form>)
    }

    doLogin(e) {
        e.preventDefault()
        this.setError()

        if(!this.state.username && !this.state.password) {
            this.setError('enter your username and password')

        } else if(!this.state.username) {
            this.setError('enter your username')

        } else if(!this.state.password) {
            this.setError('enter your password')

        } else {
            this.setError()
            Http.postForm('/login', {
                    username: this.state.username,
                    password: this.state.password
                })
                .then(res => {
                    if(!res.ok)
                        this.setError('Login failed!')
                    else
                        location.reload()
                })
        }
    }

    doLogout(e) {
        Http.get('/logout')
            .then(res => location.reload())
    }

    setError(msg) {
        this.errorText.textContent = msg || ''
    }

}