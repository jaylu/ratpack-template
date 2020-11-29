package io.jaylu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.handling.Context;
import ratpack.server.RatpackServer;
import ratpack.server.ServerConfig;

public class App {

    private static Logger log = LoggerFactory.getLogger(App.class);

    private final Config config;

    public App(Config config) {
        this.config = config;
    }

    public void start() throws Exception {
        RatpackServer server = RatpackServer.of(serverSpec -> serverSpec
                .serverConfig(ServerConfig.builder().port(config.getPort()))
                .registryOf(registry -> registry.add("testing"))
                .handlers(chain -> chain
                        .get("ready", this::ready)
                )
        );
        server.start();
        log.info("http server started at port: {}", config.getPort());
    }

    public void stop() {
        log.info("server stopped.");
    }

    public void ready(Context context) {
        context.getResponse().status(200).send("ready");
    }
}
