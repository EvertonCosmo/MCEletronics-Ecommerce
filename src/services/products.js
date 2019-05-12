import { http } from "./config"

export default {
    // CRUD 

    post: (product) => {
        return http.post('products', product)

    },
    update: (product, id) => {
        return http.put('products/' + id, product)
    },

    get: () => {
        return http.get('products')
    },
    getProduct: (id) => {
        return http.get('products/' + id)
    },
    delete: (id) => {
        return http.delete('products/' + id)
    }

}