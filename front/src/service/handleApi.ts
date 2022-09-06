import axios from 'axios'

const api = axios.create({
    baseURL: process.env.NEXT_PUBLIC_API_URL,
    headers: {
        origin: 'http://localhost:8080'
    }
})

export {api}