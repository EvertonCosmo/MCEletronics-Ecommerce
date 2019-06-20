// import api from "../../../services/api.js"

// export const namespaced = true

const state ={
    products:[]
}

export const mutations = {
    SET_PRODUCTS(state, products) {
        state.products = products
    },
  
}

export default {
    state,mutations
}