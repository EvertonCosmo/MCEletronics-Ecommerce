import { reject } from "q";



// users array 


let users = JSON.parse(localStorage.getItem('user')) || [];


export function fakeBackend(){
    let realFetch = window.fetch;

    window.fetch = function(url,opt){
        return new Promise((resolve,reject)=>{
            // timeout

            setTimeout(()=>{
                
                if(url.endsWith('/users/authenticate') && opt.method == 'POST'){
                    let parm = JSON.parse(opt.body); // get values
                }
            })
        })
    }


   
}