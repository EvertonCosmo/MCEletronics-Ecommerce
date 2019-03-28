<template>
  <div>
    <b-navbar class="bar-info">
      <b-navbar-nav style="width: 50%">
        <p style="margin-left; 100%; font-size: 60%; margin-top: 2.5%">(88) 9 9999-9999</p>
        <i style="margin-left: 40%; font-size: 100%; margin-top: 1.5%; padding: 1%" class="fas fa-envelope"></i>
        <p style="margin-left; 5%; font-size: 60%; margin-top: 2.5%">mc_eletronics@gmail.com</p>
      </b-navbar-nav>

      <b-navbar-nav style="width: 50%; float: right" class="float-right">
        <i style="margin-left: 30%; font-size: 100%; margin-top: 1.5%; padding: 1%" class="fas fa-map-marker-alt"></i>
        <p style="margin-left; 1%;font-size: 60%; margin-top: 2.5%">Contato</p>
        <i style="margin-left: 45%; font-size: 100%; margin-top: 1.5%; padding: 1%" class="fas fa-user-circle"></i>
        <p style="margin-left; 1%; font-size: 60%; margin-top: 2.5%">Conta</p>
      </b-navbar-nav>
    </b-navbar>
  </div>
</template>

<script>
export default {
  name: "BarInfo"
};
</script>

<style>
.bar-info {
  background-color: white;
  font-size: 25px;
  color: rgb(87, 86, 90);
  height: 41px;
  border: 0px solid black;
  width: 100%;
}
</style>