package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/local.properties",
        "system:properties"
})
public interface ProjectConfig extends Config {

    @DefaultValue("chrome")
    String browser();
    @DefaultValue("91.0")
    String browserVersion();
    @DefaultValue("1920x1080")
    String browserSize();
    String webUrl();
    String remoteDriverUrl();
    String videoStorage();


}
