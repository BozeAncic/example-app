import http from "../http-common";

class OutcomeService {
  getAll() {
    return http.get("/outcomes");
  }
}

export default new OutcomeService();
