
<template>
<div>
    <!-- <NavBar></NavBar>  -->
    <main-bar></main-bar>
    <div>
        
            <p> Inicio  > minha conta</p>

            <h2 class="text-center">Minha Conta</h2>
                <div class="text-center">
                            <p>olá {{email}}</p>
                </div>
                <b-card-group>
                <b-card style="max-width: 25rem" class="card" > 
                
                    <b-list-group class="item ">
                        
                        <b-list-group-item href="#"  >Painel <b-badge variant="primary" pill>14</b-badge>  <i class="fas fa-tachometer-alt float-right  card-list"></i> </b-list-group-item>
                        <b-list-group-item href="#"  >Meu Perfil<i class="far fa-user float-right card-list"></i></b-list-group-item>
                        <b-list-group-item href="#"  >Pedidos <i class="fas fa-shopping-basket float-right card-list"></i> </b-list-group-item>
                        <b-list-group-item href="#" >Endereço <i class="fas fa-home float-right card-list"></i> </b-list-group-item>
                        <b-list-group-item href="#" >Detalhes da conta<i class="fas fa-info float-right card-list"></i> </b-list-group-item>
                       <!-- <router-link to="/Login" style="text-decoration:none; color:black"> -->
                            <b-list-group-item href="/Login" @click="logout" >Sair <i class="fas fa-sign-out-alt float-right card-list"></i></b-list-group-item>
                       <!-- </router-link>  -->
                       
                        <!-- <router-view></router-view> -->
                </b-list-group>
                    
                </b-card>

            </b-card-group>
       
    </div>
</div>
</template>

<script>
import NavBar from './NavBar.vue'
import MainBar from './MainBar.vue'

export default {
    name:'PageLogin',
    
    components:{
        NavBar,MainBar
    },
    
    data() {
      return{
            email: JSON.parse(window.localStorage.getItem('fields'))[0].email // get email data from localStorage     
        };  
    },
  
    
    methods: {
        logout(){
            this.$parent.logout();
        }
    },
}
</script>

<style scoped>
    .color{
        color:black;
    }
    
    #login{
        background-color: #FFFFFF;
        border: 1px solid #CCCCCC;
        padding: 20px;
        margin-top: 10px;
    }
    .card-list{
       
        margin-top:auto;
        margin-left:auto;
        
       
     }
    .card{
        border: none;
      
        
    }
    .item{
      width:100%;
      padding:5%;
      border-left:none;
      border-right: none;
    }
    .item > :hover{
        /* Background-color: #033076; */
        background-color: #033076;
        color:white;
    }



</style>


