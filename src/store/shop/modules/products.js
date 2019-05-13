// import api from "../../../services/api.js"

// export const namespaced = true

const state ={
    products:[],

}

export const mutations = {
    SET_PRODUCTS(state, products) {
        state.products = products
    },
    ADD_TO_CART(state,productId){
        // state.products = products
        state.products.find(product => product.id == productId).quantity--
    },
    REMOVE_FROM_CART: (state, index) => {
        state.cartProducts.splice(index, 1);
    },
}




export default {
    state,mutations
}