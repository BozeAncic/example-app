import http from "../http-common";

class BetOfferService {
  getAll() {
    return http.get("/betoffers");
  }
}

export default new BetOfferService();
