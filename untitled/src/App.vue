<template>
  <div class="container">>
    <button @click="getPosts">Show Posts</button>
    <button @click="getAllDepartements">Show Posts</button>
    <!--  <h2>{{ array }}</h2>-->
    <div id="map" style="width: 1100px; height: 900px;">

    </div>
  </div>
</template>

<script>
import {LatLng} from "leaflet/src/geo/index.js";
import {map} from "leaflet/src/map/index.js";

export default {
  data() {
    return {
      array: null,
      map: null
    }
  },
  methods: {
    getPosts() {
      fetch('http://localhost:8080/all')
          .then(function (response) {
            return response.json()
          }).then(function (data) {
        console.log(data)
        var i = 0
        data.forEach((item) => {
          if (i < 100) {
            L.marker(new LatLng(item.geolocation.x, item.geolocation.y)).addTo(map.value)
            i++
          }
        })
      })
    },
    getAllDepartements() {
      fetch('http://localhost:8080/departement/all')
          .then(function (response) {
            return response.json()
          }).then(function (data) {
        console.log(data)
        data.forEach((item) => {
          var array = []
          item.geometry.points.forEach((point, index) => {
            // console.log(new LatLng(point.x, point.y))
            array[index] = (new LatLng(point.y, point.x));
          })
          L.polygon(array).addTo(map.value)
        })
      })
    },
    getAll() {
      fetch('http://localhost:8080/all')
          .then(response => this.array = response.data)
    },
    displayAll(data) {
      data.forEach((element) => {
        L.marker(LatLng(element[1])).addTo(this.map)
      })
    }
  },
  mounted() {
    map.value = L.map('map').setView([48.866667, 2.33333], 6);
    L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 19,
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    }).addTo(map.value)
  }
}

</script>

<style scoped>

</style>
