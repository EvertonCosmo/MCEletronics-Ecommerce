// function that returns an HTTP Authorization header containing the JSON Web Token (JWT)
export function helperAuth(){
    let user = JSON.parse(localStorage.getItem('user'));


    if(user && user.token){
        return {'Autorização': 'usuário' + user.token};
    }else{
        return{}
    }


}

