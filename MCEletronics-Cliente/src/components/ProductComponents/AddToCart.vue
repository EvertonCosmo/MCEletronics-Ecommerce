<template>
  <b-button
    variant="primary"
    :disabled="!product.quantity"
    @click="addProductToCart(product)"
  ><i class="fas fa-shopping-cart"></i> adicionar</b-button>
</template>

<script>
import { mapActions } from "vuex";
import { successToaster } from "../../services/ErrorHandler";
/* eslint-disable */

export default {
  name: "AddToCart",
  props: ["product"],

  methods: {
    ...mapActions(["addToCart"]),

    addProductToCart(product) {
      this.addToCart(product);
      successToaster(
        "Produto adicionado ao carrinho com sucesso",
        "Sucesso ao adicionar"
      );
    }
  }
};
</script>


