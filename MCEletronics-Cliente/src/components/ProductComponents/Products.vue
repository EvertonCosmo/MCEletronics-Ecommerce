<template>
  <div>
    <nav aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li class="breadcrumb-item active" aria-current="page">Recomendados</li>
        <li class="ml-auto" aria-current="page">
          <router-link to="/">MostrarTodos</router-link>
        </li>
      </ol>
    </nav>
    <hr>

    <swiper
      :options="swiperOption"
      v-for="(row,index) in productRows"
      :key="index"
      class="swiper-box container"
      style="max-width:100%;"
    >
      <swiper-slide v-for="(product,index) in row " :key="index">
        <Product :product="product" track-id="id"/>
      </swiper-slide>

      <div class="swiper-pagination" slot="pagination"></div>
      <div class="swiper-button-prev" slot="button-prev"></div>
      <div class="swiper-button-next" slot="button-next"></div>
    </swiper>
  </div>
</template>

<script>
import Product from "./Product";
import { mapActions, mapState } from "vuex";
// import chunk from 'chunk'
// Chunk converts arrays like [1,2,3,4,5] into arrays of arrays like [[1,2], [3,4], [5]].

export default {
  name: "Products",

  data() {
    return {
      swiperOption: {
        slidesPerView: 3,
        spaceBetween: 5,
        freeMode: true,
        pagination: {
          el: ".swiper-pagination",
          clickable: true
        },
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev"
        },
        breakpoints: {
          1024: {
            slidesPerView: 4,
            spaceBetween: 40
          },
          768: {
            slidesPerView: 3,
            spaceBetween: 30
          },
          640: {
            slidesPerView: 2,
            spaceBetween: 20
          },
          320: {
            slidesPerView: 1,
            spaceBetween: 10
          }
        }
      }
    };
  },
  components: {
    Product
  },
  computed: mapState({
    productRows: state => state.products.products  // get products from state(vuex) JUST ONLY TRUE
  }),
  methods: mapActions(["getProducts"]),

  created() {
    this.getProducts(); // get all products 
  }
};
</script>


