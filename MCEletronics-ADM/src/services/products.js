import {http} from "./config"

export default{
    // CRUD 
    
    post:(product)=>{
         return http.post('api/product',product)
          
    },
    update: (product, id) => {
        return http.put('api/product/' + id, product)
    },

    get:()=>{
        return http.get('api/products')
    },
    getProduct:(id)=>{
        return http.get('api/products/'+id)
    },

    delete: (id) => {
        return http.delete('api/product/' + id)
    }

}