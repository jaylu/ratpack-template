package io.jaylu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
public class Launcher {

    private static Logger log = LoggerFactory.getLogger(Launcher.class);

    public static void main(String[] args) throws Exception {

        Config config = getConfigFromSystemProperties();
        App app = new App(config);
        app.start();

        Runtime.getRuntime().addShutdownHook(new Thread(app::stop));
    }

    public static Config getConfigFromSystemProperties() {
        String serverPort = System.getProperty("server.port", "8080");
        return new Config().setPort(Integer.valueOf(serverPort));
    }
}
