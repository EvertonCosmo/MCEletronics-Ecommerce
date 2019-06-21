const state ={
    added:[]
}
const mutations = { 
    ADD_TO_CART(state,productId){
        const record = state.added.find(product => product.id === productId.id)
       

    if (!record) {
      state.added.push({
          category: productId.category,
          descripition: productId.descripition,
          id: productId.id,
          name: productId.name,
          price: productId.price,
          quantity: 1

      })
    //   console.log(productId)
    } else {
      record.quantity++
    }
    },
    REMOVE_FROM_CART(state, item) {
        const index = state.added.findIndex(added => added.id === item.id)
        state.added.splice(index, 1)
    },
}

export default {
    state,
    mutations
}