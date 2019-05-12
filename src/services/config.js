import axios from "axios"


export const http = axios.create({
    baseURL: 'http://localhost:8080/project/api/',
    headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json'
    },
})