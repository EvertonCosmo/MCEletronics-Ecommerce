import axios from "axios"


 const http  = axios.create({
        // baseURL: 'http://192.168.1.13:8080/project/api/',
        baseURL:'http://localhost:8080/project/',
        headers: {
             Accept: 'application/json',
            'Content-Type': 'application/json'
        },
    })
export default {
    /* PRODUCTS */
    get: () => { 
       return http.get('api/products') // get all products
    },
    

    getUser:(username) => { // get the user  by username
        return http.get('api/users/')
    },

    /* USERS */
    postUser :(user) => {
        return http.post('api/users',user)
    },
    /* LOGIN */
    postLogin :(user) => {
        return http.post('login',user)
    }
}