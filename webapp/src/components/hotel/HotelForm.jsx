import React from 'react'
import BaseComponent from '../BaseComponent'
import Http from '../../tools/HttpClient'

export default class HotelForm extends BaseComponent {

    constructor(props) {
        super(props)
    }

    render() {

        const form = (
            <form>
              <label>
              Name:
                <input name="Hotel name" placeholder="Hotel I" />
                <input name="Hotel address" placeholder="xyz Street 2" />
                <input name="Hotel postal code" placeholder="12345" />
                <input name="Hotel city" placeholder="New York" />
                <select name="Hotel country" placeholder="United States"
                      onChange={(e)=> this.state.countryCode = e.target.value}>
                      <option></option>
                  </select>
              </label>
            </form>)

        return (
            <div>
                <h1>Create hotel</h1>
                {form}
            </div>)
    }


}
