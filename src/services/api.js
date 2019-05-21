import axios from "axios"


 const http  = axios.create({
        //  baseURL: 'http://192.168.42.71:8080/project/',

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
    
    /* USERS */
    postUser :(user) => {
        return http.post('api/users',user)
    },
    /* LOGIN */
    postLogin :(user) => {
        return http.post('login',user)
    }
}