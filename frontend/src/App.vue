<template>
  <div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <router-link to="/betoffer" class="nav-link">Bet offer</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/playerbets" class="nav-link"
            >Player bets</router-link
          >
        </li>
      </div>
    </nav>

    <div class="container-fluid mt-3">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: "App",
};
</script>

<style>
</style>
