package utils;

import constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils(){
    }

    private static Properties property = new Properties();

    static {
        try(FileInputStream fs = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
            property.load(fs);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static String getValue(String key){
        String value = "";
        value = property.getProperty(key);
        if(Objects.isNull(value)){
            throw new RuntimeException("Property name "+key+" is not found. Please check the config.properties");
        }
        return value;
    }
}
