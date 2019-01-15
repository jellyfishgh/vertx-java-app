package jellyfish;

import io.vertx.ext.web.Router;
import routes.DetailRoute;
import routes.IndexRoute;
import routes.ListRoute;
import routes.NotFoundRoute;

public final class Main {

  private Main() {
  }

  public static void main(String[] args) {
    int port = 8080;
    App app = new App(port);
    addRoutes(app.getRouter());
    System.out.println("http://localhost:" + port);
    app.start();
  }

  private static void addRoutes(Router router) {
    new ListRoute("/list", router);
    new DetailRoute("/detail/:id", router);
    new IndexRoute("/", router);
    new NotFoundRoute(router);
  }
}
