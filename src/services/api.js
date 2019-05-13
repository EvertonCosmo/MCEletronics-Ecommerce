import axios from "axios"


 const http  = axios.create({
        baseURL: 'http://localhost:8080/project/api/',
        headers: {
             Accept: 'application/json',
            'Content-Type': 'application/json'
        },
    })
export default {
    get: (cd) => { 
       cd(http.get('products')) // get all products
    }
}