<template>
  <div class="row">
    <div class="col-8">
      <table class="table">
        <thead>
          <tr class="table-primary">
            <th scope="col">Pairs</th>
            <th
              scope="col"
              v-for="item in outcomes"
              :key="item.id"
              :title="item.description"
            >
              {{ item.name }}
            </th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(item, parentIndex) in betOffers" :key="item.id">
            <td class="table-secondary">
              {{ `${item.homeTeam.name} vs ${item.awayTeam.name}` }}
            </td>
            <td
              v-for="(betOfferItem, index) in item.betOfferItems"
              @click="selectThis(item, betOfferItem, parentIndex, index)"
              :class="{
                'table-success': activeIndex.get(parentIndex) === index,
              }"
              :key="betOfferItem.id"
            >
              {{ betOfferItem.coefficient }}
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="col-2">
      <div class="card">
        <div class="card-body">
          <h5 class="card-title">Placed Bet</h5>
          <ul class="list-group">
            <li
              v-for="item in bets"
              :key="item"
              class="
                list-group-item
                d-flex
                justify-content-between
                align-items-center
              "
            >
              {{ `${item.homeTeam?.name} vs ${item.awayTeam?.name}` }}
              <span class="badge bg-success rounded-pill">{{
                item.outcome?.name
              }}</span>
              <span class="badge bg-primary rounded-pill">{{
                item.coefficient
              }}</span>
            </li>
          </ul>

          <figure class="text-start mt-3">
            <div class="row">
              <blockquote class="blockquote col-6">
                <p>Coefficient</p>
              </blockquote>
              <blockquote class="blockquote col-6">
                <p>{{ mainCoefficient }}</p>
              </blockquote>
            </div>
          </figure>
          <!-- <input type="number" v-model="cash" /> -->
          <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label"
              >Cash</label
            >
            <input
              type="number"
              v-model="cash"
              class="form-control"
              id="exampleFormControlInput1"
              placeholder="name@example.com"
            />
          </div>
          <figure class="text-start mt-3">
            <div class="row">
              <blockquote class="blockquote col-6">
                <p>Gain</p>
              </blockquote>
              <blockquote class="blockquote col-6">
                <p>{{ winningCash }}</p>
              </blockquote>
            </div>
          </figure>

          <button class="btn btn-primary" @click="submitBet()">Save</button>
        </div>
        <p v-if="errors.length">
    <b>Please correct the following error(s):</b>
    <ul>
      <li v-for="error in errors" :key="error">{{ error }}</li>
    </ul>
  </p>
      </div>
    </div>
  </div>
</template>

<script>
import OutcomeService from "../services/OutcomeService";
import BetOfferService from "../services/BetOfferService";
import PlayerBetService from "../services/PlayerBetService";
export default {
  name: "BetOffer",
  data() {
    return {
      errors: [],
      outcomes: [],
      betOffers: [],
      activeIndex: new Map(),
      bets: [],
      mainCoefficient: 0,
      cash: 0,
      winningCash: 0,
    };
  },
  methods: {
    getOutcomes() {
      OutcomeService.getAll().then((response) => {
        this.outcomes = response.data;
      });
    },
    getBetOffers() {
      BetOfferService.getAll().then((response) => {
        this.betOffers = response.data;
      });
    },
    selectThis(val, betOfferVal, parentIndex, index) {
      let betIndex = this.bets.findIndex((value) => value.itemId === val.id);
      if (this.activeIndex.get(parentIndex) === index) {
        this.activeIndex.delete(parentIndex);
        if (betIndex > -1) {
          this.bets.splice(betIndex, 1);
        }
      } else {
        const obj = {
          ...betOfferVal,
          itemId: val.id,
          homeTeam: val.homeTeam,
          awayTeam: val.awayTeam,
        };
        this.activeIndex.set(parentIndex, index);
        if (betIndex > -1) {
          this.bets[betIndex] = obj;
        } else {
          this.bets.push(obj);
        }
      }
    },
    submitBet() {
      this.errors = [];
      if (this.bets.length === 0) {
        this.errors.push("Please select bet");
      }

      if (this.cash === 0 || !this.cash) {
        this.errors.push("Please fill stake");
      }
      if (this.errors.length === 0) {
        let data = {
          stake: this.cash,
          coefficient: this.mainCoefficient,
          gain: this.winningCash,
          playerId: 1,
          playerBetItems: [...this.bets],
        };
        data.playerBetItems = data.playerBetItems.map((value) => {
          return value.itemId;
        });
        PlayerBetService.saveBet(data)
          .then(() => {
            this.bets = [];
            this.cash = 0;
            this.activeIndex.clear();
          })
          .catch((err) => {
            this.errors.push(err.response.data.message);
            // this.bets = [];
            // this.cash = 0;
            // this.activeIndex.clear();
          });
      }
    },
  },
  mounted() {
    this.getOutcomes();
    this.getBetOffers();
  },
  watch: {
    bets: {
      handler() {
        this.mainCoefficient =
          Math.round(
            this.bets.reduce((acc, val) => {
              acc += val.coefficient;
              return acc;
            }, 0) * 100
          ) / 100;
        this.winningCash =
          Math.round(this.cash * this.mainCoefficient * 100) / 100;
      },
      deep: true,
    },
    cash: {
      handler() {
        this.winningCash =
          Math.round(this.cash * this.mainCoefficient * 100) / 100;
      },
    },
  },
};
</script>