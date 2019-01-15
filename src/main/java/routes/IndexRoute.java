package routes;

import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

public class IndexRoute extends MyRoute {
  public IndexRoute(String path, Router router) {
    super(router, path);
    this.getRoute().handler(req -> {
      this.sendData(this.preHandleRes(req.response()),
          new JsonObject().put("name", "hemu").put("age", 27).put("human", true));
    });
  }
}
