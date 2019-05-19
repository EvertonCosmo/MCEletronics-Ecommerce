import axios from "axios"


 const http  = axios.create({
        baseURL: 'http://192.168.1.13:8080/project/api/',
        headers: {
             Accept: 'application/json',
            'Content-Type': 'application/json'
        },
    })
export default {
    get: () => { 
       return http.get('products') // get all products
    },
    
    getUser:(email) => { // get the user 
        return http.get('users/' +email)
    },
    postUser :(user) => {
        return http.post('users',user)
    }
}