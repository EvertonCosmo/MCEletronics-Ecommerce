<template>
<div>
  <form style="width:100%">
    <fieldset>
      <legend>Detalhes da conta</legend>
      <div class="form-row">
        <div class="col-md-12 mb-4">
          <label for="validationServer01">NomeCompleto</label>
          <input
            type="text"
            class="form-control"
            id="validationServer01"
            placeholder="Nome Completo"
            value="Mark"
            required
            :disabled="edit"
          >
        </div>
      </div>

      <div class="form-row">
        <div class="col-md-4 mb-4">
          <label for="validationServer02">Endereço</label>
          <input
            type="text"
            class="form-control"
            id="validationServer02"
            placeholder="Endereço"
            required
             :disabled="edit"
          >
        </div>
        <div class="col-md-4 mb-4">
          <label for="validationServer03">Telefone</label>
          <input
            type="text"
            class="form-control"
            id="validationServer03"
            placeholder="Telefone"
            required
             :disabled="edit"
          >
        </div>
        <div class="col-md-4 mb-4">
          <label for="validationServer04">Email</label>
          <input
            type="email"
            class="form-control"
            id="validationServer04"
            placeholder="email"
            required
             :disabled="edit"
          >
        </div>
        <div class="col-md-4 mb-4">
          <label for="validationServer05">CPF</label>
          <input
            type="text"
            class="form-control"
            id="validationServer05"
            placeholder="CPF"
            required
             :disabled="edit"
          >
        </div>
        <div class="col-md-4 mb-4">
          <label for="validationServer06">Nova Senha</label>
          <input
            type="password"
            class="form-control"
            id="validationServer06"
            placeholder="Nova Senha"
            required
             :disabled="edit"
          >
        </div>
        <div class="col-md-4 mb-4">
          <label for="validationServer07">Sexo</label>
          <select class="custom-select">
            
            <option value="1">Masculino</option>
            <option value="2" >Feminino</option>
            <option value="3" selected>Outro</option>
          </select>
        </div>
      </div>
    </fieldset>

     <b-button block variant="primary" @click="dataModify" style="pading:22%; margin-right:12%">Alterar dados </b-button>
      <b-button block variant="primary" @submit.prevent="submitData"> Salvar </b-button>
  </form>
   
</div>
</template>

<script>
export default {
  name: "AccountDetails",
  data() {
    return {
        edit: true
    }
    
  },
  methods: { 
      dataModify(){
          if(this.edit == true){
                this.edit = false
          }else if(this.edit == false){
              this.edit = true
          }
         
      }
  }
};
</script>

