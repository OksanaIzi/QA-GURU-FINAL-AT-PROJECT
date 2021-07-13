package helpers;

import config.DataConfig;
import org.aeonbits.owner.ConfigFactory;

public class DataHelper {
    public static DataConfig dataConfig = ConfigFactory.create(DataConfig.class, System.getProperties());
}
