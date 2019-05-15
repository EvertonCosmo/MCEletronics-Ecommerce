const state ={
    added:[]
}
const mutations = { 
    ADD_TO_CART(state,product){
        // const record = state.added.find(product => product.id === productId)

        // if(!record){
        //     state.added.push({id:productId,quantity:1})

        // }else{record.quantity++}

      state.added.push(product);
    
    },
    REMOVE_FROM_CART(state, index) {
        // const index = state.added.findIndex(added => added.id === item.id)
        state.added.splice(index, 1)
    },

}

export default {
    state,
    mutations
}