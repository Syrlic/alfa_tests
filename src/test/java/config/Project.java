package config;

import org.aeonbits.owner.ConfigFactory;

public class Project {

    public static ProjectConfig config = ConfigFactory.create(ProjectConfig.class);

    public static boolean isRemoteWebDriver() {
        return !config.remoteDriverUrl().equals("");
    }

    public static boolean isVideoOn() {
        return !config.videoStorage().equals("");
    }

}
