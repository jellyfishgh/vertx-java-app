package routes;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

public class ListRoute extends MyRoute {
  public ListRoute(String path, Router router) {
    super(router, path);
    this.getRoute().handler(req -> {
      JsonArray arr = new JsonArray();
      for (int i = 0; i < 20; i++) {
        JsonObject json = new JsonObject();
        json.put("name", "Name_" + i);
        json.put("id", "" + i);
        arr.add(json);
      }
      this.sendData(this.preHandleRes(req.response()), new JsonObject().put("list", arr));
    });
  }
}
