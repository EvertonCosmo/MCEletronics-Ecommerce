<template>
  <nav class="nav-wrapper">
    <div>
      <p class="brand-logo center">{{tittle}}</p>
    </div>
  </nav>
</template>


<script>
export default {
  name: "MainBar",

  data() {
    return {
      tittle: "MCEletronics"
    };
  }
};
</script>

<style scoped>
nav {
  line-height: 1.5;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
    Oxygen-Sans, Ubuntu, Cantarell, "Helvetica Neue", sans-serif;
  font-weight: normal;
  color: rgba(0, 0, 0, 0.87);
}

nav .brand-logo {
  position: absolute;
  color: #fff;
  display: inline-block;
  font-size: 2.1rem;
  padding: 0;
}

nav .brand-logo.center {
  left: 50%;
  -webkit-transform: translateX(-50%);
  transform: translateX(-50%);
}
.nav-wrapper {
  background: linear-gradient(-90deg, #033076);
  box-shadow: 1px 2px 2px 2px #033076;
  height: 4rem;
  width: 100%;
  margin-bottom: 10px;
  /* margin:auto; */
  background-color: #033076;
}
@media only screen and (max-width: 992px) {
  nav .brand-logo {
    left: 50%;
    -webkit-transform: translateX(-50%);
    transform: translateX(-50%);
  }
}

.logo {
  color: white;
  text-decoration: none;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-size: 2.3rem;
  margin-left: 10px;
}
</style>
