package io.jaylu;

public class RunLocal {

    public static void main(String[] args) throws Exception {
        System.getProperties().setProperty("server.port", "8002");
        Launcher.main(new String[]{});
    }
}
