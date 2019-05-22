
import {
    encryptUser
} from '../../../services/authService'

const state ={
	loggedUser: {}
}
export const mutations = {
	ADD_LOGGED_USER: (state, user) => {
            state.loggedUser = user
            localStorage.setItem('_auth', encryptUser(user))
        },
}
export default {
    
    state,mutations
}