import React from 'react'
import BaseComponent from '../BaseComponent'
import Http from '../../tools/HttpClient'

export default class HotelForm extends BaseComponent {

    constructor(props) {
        super(props)
    }

    render() {

      const countryOptions = []
            if (this.state.countries) {
                for (var i in this.state.countries) {
                    const country = this.state.countries[i]
                    countryOptions.push(<option key={i} value={country.countryCode}>
                        {country.countryCode} - {country.countryName}</option>)
                }
            }

        const form = (
            <form>
              <label>
              Name:
                <input placeholder="Hotel I" />
              </label>
            </form>)
        const formStreet = (
            <form>
              <label>
              Street:
                <input placeholder="XYZ Street 1" />
              </label>
            </form>)
        const formPostalCode = (
            <form>
              <label>
              Postal code:
                <input placeholder="12345" />
              </label>
            </form>)
        const formCity = (
            <form>
              <label>
              City:
              <input placeholder="New York" />
              </label>
            </form>)
        const formCountry = (
            <form>
              <label>
              Country:
               <select placeholder="Country"
                 onChange={(e)=> this.state.countryCode = e.target.value}>
                 <option></option>
                 {countryOptions}
               </select>
              </label>
            </form>)

        return (
            <div>
                <h1>Create hotel</h1>
                {form}
                {formStreet}
                {formPostalCode}
                {formCity}
                {formCountry}
            </div>)
    }


}
