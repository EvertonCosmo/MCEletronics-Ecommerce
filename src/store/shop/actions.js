import api from "../../services/api.js"


export const getProducts =({ commit }) => {
    api.get(products => {
        commit('SET_PRODUCTS',products)
    })
}
export const addToCart = ({ commit }, product) => {
    if (product.quantity > 0) {
        commit('ADD_TO_CART', product.id)
    }
}
export const removeFromCart = ({ commit }, product) => {
    commit('REMOVE_FROM_CART', product)
}