 /* eslint-disable */
import api from "../../services/api.js"


export const getProducts =({ commit }) => {
    api.get().then(Response => {commit('SET_PRODUCTS',Response.data)})
    
        
}

export const addToCart = (context, product) => {
    if (product.quantity > 0) {
        context.commit('ADD_TO_CART', product)
    }
}


export const removeFromCart = (context, product) => {
    context.commit('REMOVE_FROM_CART', product)
}

