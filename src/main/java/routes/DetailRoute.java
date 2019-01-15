package routes;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class DetailRoute extends MyRoute {
  private Buffer buf;

  public DetailRoute(String path, Router router) {
    super(router, path);
    Route route = this.getRoute();
    route.handler(req -> {
      HttpServerResponse res = this.preHandleRes(req.response());
      res.setChunked(true);
      buf = Buffer.buffer(new JsonObject().put("id", "我的id是:" + req.request().getParam("id")).encode());
      System.out.println(buf.length());
      res.write(buf.getString(0, 1));
      req.vertx().setTimer(5000, tid -> req.next());
    });
    route.handler(req -> {
      req.response().write(buf.getString(1, 2));
      req.vertx().setTimer(2000, tid -> req.next());
    });
    route.handler(req -> {
      HttpServerResponse res = req.response();
      res.write(buf.getString(2, buf.length()));
      res.end();
    });
  }
}
