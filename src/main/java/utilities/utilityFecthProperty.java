package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class utilityFecthProperty {
    private static Map<String, String> locatermap = new HashMap<>();

    public static String fetchPropertyValue(String key) throws IOException {
        FileInputStream file = new FileInputStream(constant.CONFIG_PROPERTIES_DIRECTORY);
        Properties property = new Properties();
        property.load(file);
        for (Object k : property.keySet()) {
            locatermap.put(String.valueOf(k), String.valueOf(property.get(k)));
        }
        return locatermap.get(key);
    }
}
