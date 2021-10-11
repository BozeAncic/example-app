import http from "../http-common";

class PlayerService {
  getPlayer() {
    return http.get("/player/1");
  }
}

export default new PlayerService();
