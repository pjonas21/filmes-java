import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApiKeyLoader {

    public static Properties loadApiProperties() {
        Properties props = new Properties();
        try (InputStream inputStream = ApiKeyLoader.class.getClassLoader().getResourceAsStream("api.properties")){
            props.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props;
    }
}
