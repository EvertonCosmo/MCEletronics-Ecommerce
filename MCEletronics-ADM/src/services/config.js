import axios from "axios"


export const http = axios.create({
  baseURL: 'http://192.168.1.7:8080/MCEletronics/',
     headers: {
     		Accept: 'application/json',
    	   'Content-Type': 'application/json'
  },
})