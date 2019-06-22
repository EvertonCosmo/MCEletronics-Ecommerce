<template>
  <div class="col-2 col-sm-2 col-md-2 text-right">
    <button
      @click="removeProductToCart(product) "
      alt="remover"
      type="button"
      class="btn btn-outline-danger btn-xs"
    >
      <i class="fa fa-trash" aria-hidden="true"></i>
    </button>
  </div>
</template>

<script>
import { mapActions } from "vuex";
import { successToaster } from "../../services/ErrorHandler";
/* eslint-disable */

export default {
  name: "RemoveToCart",
  props: ["product"],

  methods: {
    ...mapActions(["removeFromCart"]),

    removeProductToCart(product) {
      this.removeFromCart(product);
      successToaster(
        "Produto removido do carrinho com sucesso",
        "Sucesso ao remover"
      );
    }
  }
};
</script>