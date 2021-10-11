import http from "../http-common";

class PlayerBetService {
  saveBet(data) {
    return http.post("/savebet", data);
  }
}

export default new PlayerBetService();
