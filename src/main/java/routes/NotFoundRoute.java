package routes;

import io.vertx.ext.web.Router;

public class NotFoundRoute {
  private int NOT_FOUND_CODE = 404;

  public NotFoundRoute(Router router) {
    router.route("/*").handler(ctx -> {
      ctx.response().setStatusCode(NOT_FOUND_CODE).end("not found");
    });
  }
}
