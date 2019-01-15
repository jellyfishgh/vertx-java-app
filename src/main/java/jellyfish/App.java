package jellyfish;

import io.vertx.core.Vertx;
import io.vertx.core.http.*;
import io.vertx.ext.web.Router;

public class App {
  private int port;
  private Router router;
  private HttpServer server;

  public App(int port) {
    super();
    this.port = port;
    this.init();
  }

  public void init() {
    Vertx vertx = Vertx.vertx();
    HttpServer server = vertx.createHttpServer();
    Router router = Router.router(vertx);
    server.requestHandler(router);
    this.router = router;
    this.server = server;
  }

  public Router getRouter() {
    return this.router;
  }

  public void start() {
    this.server.listen(this.port);
  }
}
