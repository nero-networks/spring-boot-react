
const Client = {
    post: (url, payload, params)=> {
        params = params || {}
        params.headers = params.headers || {}

        let ctype = params.headers['Content-Type']

        if(!ctype)
            ctype = params.headers['Content-Type'] = 'application/json'

        if(typeof payload === 'object') {
            if(ctype === 'application/json')
                payload = JSON.stringify(payload)

            if(ctype === 'application/x-www-form-urlencoded')
                payload = Client.encodeQuery(payload)
        }

        params.body = payload
        return request('post', url, params)
    },

    postForm: (url, payload, params)=> {
        params = params || {}
        params.headers = params.headers || {}

        if(!params.headers['Content-Type'])
            params.headers['Content-Type'] = 'application/x-www-form-urlencoded'

        return Client.post(url, payload, params)
    },

    get: (url, params)=> {
        return request('get', url, params)
    },

    getJSON: (url, params)=> {
        return Client.get(url, params)
            .then(res => res.json())
    },

    encodeQuery: (data)=> {
        let query = ''
        Object.keys(data).forEach(k => query += `${encodeURIComponent(k)}=${encodeURIComponent(data[k])}&`)
        if(query.length > 0) {
            query = query.substr(0, query.length - 1)
        }
        return query
    }
}

export default Client

function request(method, url, params) {
    params = params || {}
    params.method = method
    params.credentials = params.credentials || 'include'

    return fetch(url, params)
}
