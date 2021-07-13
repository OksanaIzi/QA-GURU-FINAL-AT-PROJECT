package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({"system:properties",
        "classpath:test.data.properties"})
public interface DataConfig extends Config {
    @Key("test.user")
    String testUser();

    @Key("test.password")
    String testPassword();
}
