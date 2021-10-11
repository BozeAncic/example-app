import { createWebHistory, createRouter } from "vue-router";

const routes = [
  {
    path: "/",
    alias: "/betoffer",
    name: "betoffer",
    component: () => import("./components/BetOffer"),
  },
  {
    path: "/playerbets",
    name: "playerbets",
    component: () => import("./components/PlayerBets"),
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
