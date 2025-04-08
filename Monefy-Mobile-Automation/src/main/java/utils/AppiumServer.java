package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AppiumServer {

    public static AppiumDriverLocalService appiumServer;

    public static void startServer() {
        appiumServer = getAppiumServer();
        appiumServer.start();
    }

    public static void stopServer() {
        appiumServer.stop();
    }

    private static AppiumDriverLocalService getAppiumServer() {
        Map<String, String> env = new HashMap<>(System.getenv());

        String androidHome = System.getenv("ANDROID_HOME");
        if (androidHome == null || androidHome.isEmpty()) {
            androidHome = System.getProperty("user.home") + "/Library/Android/sdk";
            }
        env.put("ANDROID_HOME", androidHome);
        env.put("ANDROID_SDK_ROOT", androidHome);

        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withLogFile(new File("ServerLogs/appiumLogs.log"))
                .withEnvironment(env)
                .withIPAddress("127.0.0.1")
                .usingPort(4733);
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
        Field streamField = null;
        Field streamsField = null;
        try {
            streamField = AppiumDriverLocalService.class.getDeclaredField("stream");
            streamField.setAccessible(true);
            streamsField = Class.forName("io.appium.java_client.service.local.ListOutputStream")
                    .getDeclaredField("streams");
            streamsField.setAccessible(true);
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            ((ArrayList<OutputStream>) streamsField.get(streamField.get(service))).clear(); // remove System.out logging
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return service;
    }
}
