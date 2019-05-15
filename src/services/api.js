import axios from "axios"


 const http  = axios.create({
        baseURL: 'http://localhost:8080/project/api/',
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