package routes;

import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class MyRoute {
  private Router router;
  private String path;
  private Route route;

  public MyRoute(Router router, String path) {
    this.router = router;
    this.path = path;
    this.init();
  }

  public void init() {
    this.route = this.router.route(this.path).method(HttpMethod.POST).method(HttpMethod.GET);
  }

  public Route getRoute() {
    return this.route;
  }

  public HttpServerResponse preHandleRes(HttpServerResponse res) {
    res.putHeader("content-type", "application/json");
    return res;
  }

  public void sendData(HttpServerResponse res, JsonObject data) {
    res.end(data.encode());
  }
}
