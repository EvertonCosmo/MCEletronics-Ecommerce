<template>
<div>
  <div v-if="list">
    <nav style="margin-top: 2%; margin-right: 2%" aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li class="breadcrumb-item active" aria-current="page">Recomendados</li>
        <li class="ml-auto" aria-current="page">
          <router-link  :to="{name:'all-products'}">
            Mostrar todos
        </router-link>
        </li>
      </ol>
    </nav>
    <hr>

    <swiper
      :options="swiperOption"
      class="swiper-box container"
      style="max-width:100%;"
    >
      <swiper-slide  style="margin: 2.5%" v-for="(product,index) in products" :key="index">
        <Product :product="product" :shadow="false" track-id="id"/>
      </swiper-slide> 

      <div class="swiper-pagination" slot="pagination"></div>
      <div class="swiper-button-prev" slot="button-prev"></div>
      <div class="swiper-button-next" slot="button-next"></div>
    </swiper>

    
  </div>
  <div v-else>
      <div>
          <div class="row">
              <div class="col-md-4" v-for="(product,index) in products" :key="index">
                  <Product :product="product" :shadow="true"/>
              </div>
          </div>
      </div>
  </div>
  </div>
</template>

<script>
import Product from "./ProductCard";
// import chunk from 'chunk'
// Chunk converts arrays like [1,2,3,4,5] into arrays of arrays like [[1,2], [3,4], [5]].

export default {
  name: "Products",
  props:['products','list'],
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
  
};
</script>


