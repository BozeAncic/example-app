<template>
  <div class="row">
    <p class="h3 col-2">{{ player.name }}</p>
    <p class="h3 col-2">{{ player.cashAmount }}</p>
  </div>
  <div class="row">
    <div class="col-12">
      <table class="table">
        <thead>
          <tr class="table-primary">
            <th scope="col">Bet id</th>
            <th scope="col">Stake</th>
            <th scope="col">Coefficient</th>
            <th scope="col">Gain</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in player.playerBets" :key="item.id">
            <td>
              {{ item.id }}
            </td>
            <td>
              {{ item.stake }}
            </td>
            <td>
              {{ item.coefficient }}
            </td>
            <td>
              {{ item.gain }}
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import PlayerService from "../services/PlayerService";
export default {
  name: "PlayerBets",
  data() {
    return {
      player: {},
    };
  },
  methods: {
    getPlayer() {
      PlayerService.getPlayer().then((response) => {
        this.player = response.data;
      });
    },
  },
  mounted() {
    this.getPlayer();
  },
};
</script>