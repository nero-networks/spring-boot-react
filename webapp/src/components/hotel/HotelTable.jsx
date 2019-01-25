import React from 'react'
import BaseComponent from '../BaseComponent'
import Http from '../../tools/HttpClient'
import Table from 'react-table'

export default class HotelTable extends BaseComponent {

    constructor(props) {
        super(props)
        this.state.page = {content:[], pageable: {pageNumber: 0}, size: 5}
    }

    componentDidMount() {
        this.updateTable()
        this.updateCountries()
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
            <form onSubmit={(e)=> e.preventDefault()}>
                <input name="hotelName" placeholder="Hotel Name (contains)"
                    onChange={(e)=> this.state.hotelName = e.target.value}/>
                <input name="hotelCode" placeholder="Hotel Code (starts with)"
                    onChange={(e)=> this.state.hotelCode = e.target.value} />
                <input name="chainCode" placeholder="Chain Code (starts with)"
                    onChange={(e)=> this.state.chainCode = e.target.value} />
                <input name="street" placeholder="Street (starts with)"
                    onChange={(e)=> this.state.street = e.target.value} />
                <input name="postalCode" placeholder="Postal Code (starts with)"
                    onChange={(e)=> this.state.postalCode = e.target.value} />
                <input name="city" placeholder="City (starts with)"
                    onChange={(e)=> this.state.city = e.target.value} />

                <select name="countryCode" placeholder="Country"
                    onChange={(e)=> this.state.countryCode = e.target.value}>
                    <option></option>
                    {countryOptions}
                </select>

                <button onClick={()=> this.updateTable()}>Search</button>
            </form>)

        const columns = [
            { Header: 'Name', accessor: 'hotelName' },
            { Header: 'Code', accessor: 'hotelCode' },
            { Header: 'Chain', accessor: 'chainCode' },
            { Header: 'Street', accessor: 'street' },
            { Header: 'Postal Code', accessor: 'postalCode' },
            { Header: 'City', accessor: 'city' },
            { Header: 'Country', accessor: 'countryCode'}
        ]

        return (
            <div>
                <h1>Hotels</h1>

                {form}

                <Table
                    defaultPageSize={5}
                    columns={columns}
                    data={this.state.page.content} />

                <div>
                    <button onClick={()=> this.updateTable(-1)}>prev</button>
                    <button onClick={()=> this.updateTable(+1)}>next</button>
                    <select onChange={(e)=> this.changePageSize(e.target.value)}>
                        <option value="5">5</option>
                        <option value="10">10</option>
                        <option value="15">15</option>
                    </select>
                </div>
            </div>)
    }

    changePageSize(size) {
        this.state.page = {content:[], pageable: {pageNumber: 0}, size: size}
        this.updateTable()
    }

    updateTable(dir) {
        const name = encodeURIComponent(this.state.hotelName||''),
            code = encodeURIComponent(this.state.hotelCode||''),
            chain = encodeURIComponent(this.state.chainCode||''),
            street = encodeURIComponent(this.state.street||''),
            postalCode = encodeURIComponent(this.state.postalCode||''),
            city = encodeURIComponent(this.state.city||''),
            countryCode = encodeURIComponent(this.state.countryCode||''),
            page = this.state.page.pageable.pageNumber + dir||0

        if(page >= 0 && (page == 0 || page < this.state.page.totalPages)) {

            Http.getJSON(`/api/v1/hotel?hotelName=${name}&hotelCode=${code}&chainCode=${chain}`
                                     + `&street=${street}&postalCode=${postalCode}&city=${city}&countryCode=${countryCode}`
                                     + `&page=${page}&pageSize=${this.state.page.size}`)
                .then(page => this.updateStateValue('page', page))

        }
    }

    updateCountries() {
        Http.getJSON('/api/v1/country')
            .then(countries => {
                console.log(countries)
                this.updateStateValue('countries', countries)
            })

    }

}
