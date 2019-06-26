<template>
<div>
  <form style="width:100%"  @submit.prevent="submitData">
    <fieldset>
      <legend>Detalhes da conta</legend>
      <div class="form-row">
        <div class="col-md-8 mb-4">
          <label for="validationServer01">Nome Completo</label>
          <input
            type="text"
            class="form-control"
            id="validationServer01"
            :placeholder="user.nameComplete"
            required
            :disabled="edit"
            v-model="user.nameComplete"
          >
        </div>
          <div class="col-md-4 mb-4">
          <label for="validationServer02">Nome de Usuário</label>
          <input
            type="text"
            class="form-control"
            id="validationServer02"
            :placeholder="user.username"
            required
            :disabled="edit"
            v-model="user.username"
          >
        </div>
      </div>

      <div class="form-row">
        <div class="col-md-4 mb-4">
          <label for="validationServer03">Endereço</label>
          <input
            type="text"
            class="form-control"
            id="validationServer03"
            :placeholder="user.adress"
            required
             :disabled="edit"
             v-model="user.adress"
          >
        </div>
        <div class="col-md-4 mb-4">
          <label for="validationServer04">Telefone</label>
          <input
            type="text"
            class="form-control"
            id="validationServer04"
            :placeholder="user.phone"
            required
             :disabled="edit"
             v-model="user.phone"
          >
        </div>
        <div class="col-md-4 mb-4">
          <label for="validationServer05">Email</label>
          <input
            type="email"
            class="form-control"
            id="validationServer05"
            :placeholder="user.email"
            required
             :disabled="edit"
             v-model="user.email"
          >
        </div>
        <div class="col-md-4 mb-4">
          <label for="validationServer06">CPF</label>
          <input
            type="text"
            class="form-control"
            id="validationServer06"
            :placeholder="user.cpf"
            required
             :disabled="edit"
             v-model="user.cpf"
          >
        </div>
        <div class="col-md-4 mb-4">
          <label for="validationServer07">Nova Senha</label>
          <input
            type="password"
            class="form-control"
            id="validationServer07"
            :placeholder="user.password"
            required
             :disabled="edit"
             v-model="user.password"
          >
        </div>
        <div class="col-md-4 mb-4">
          <label for="validationServer08" >Sexo</label>
          <select class="custom-select" v-model="user.sexo">
            
            <option value="M">Masculino</option>
            <option value="F" >Feminino</option>
            <option value="O" selected>Outro</option>
          </select>
        </div>
      </div>
    </fieldset>

     <b-button block variant="primary" @click="dataModify" style="pading:22%; margin-right:12%">Alterar dados </b-button>
      <b-button block variant="primary" type="submit"> Salvar </b-button>
  </form>
   
</div>
</template>

<script>
import api from '../../services/api'
import { successToaster, errorToaster } from "../../services/ErrorHandler";
export default {
  name: "AccountDetails",
  props: [ 'user'],
  data() {
    return {
        edit: true,
       

    }
    
  },
  methods: { 
         dataModify(){
          if(this.edit == true){
                this.edit = false
          }else if(this.edit == false){
              this.edit = true
          }
    },
    submitData(){
          let formData = new FormData();
            formData.append('username',this.user.username);
            formData.append('password',this.user.password);
            formData.append('email',this.user.email);
            formData.append('adress',this.user.adress);
            formData.append('phone',this.user.phone);
            formData.append('cpf',this.user.cpf);
            formData.append('nameComplete',this.user.nameComplete);
            formData.append('sexo',this.user.sexo);
             
             api.updateUser(formData,this.user.id).then(Response => { 
                 if(Response.status == 200){
                      successToaster(
                "Dados atualizados",
                "Dados do usuário alterados com sucesso"
              );
                 }else{ 
                     console.log(Response.data)
                 }
             }).catch(e =>  { 
                 console.log(e)
                 if (e.response.status == 404) {
                     errorToaster("Preencha dados", "Preencha todos os campos por favor");
            } else {
              errorToaster("Falha na atualização", "Tente novamente mais tarde");
            }
             })
     }
         
          
    
    },  


};
</script>

