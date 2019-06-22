<template>
   <div class="cardLoader">
        <div class="row">
            <div class="col-md-3" v-for="loop in time" v-bind:key="loop">
                <vcl-instagram :width="220" :height="450" style="padding: 20px"></vcl-instagram>
            </div>
        </div>
    </div>
</template>

<script>
import { VclInstagram } from 'vue-content-loading'
export default {
    name:'LoaderEffect',
    props:['time'],

    components:{ VclInstagram }
}
</script>