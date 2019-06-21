import axios from "axios"


 const http  = axios.create({
         baseURL: 'http://localhost:8080/MCEletronics/',

        // baseURL:'http://192.168.1.8:8080/MCEletronics/',
        
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
        return http.post('api/user',user)
    },
    /* LOGIN */
    postLogin :(user) => {
        return http.post('api/login',user)
    }
}