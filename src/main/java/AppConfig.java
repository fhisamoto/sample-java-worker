import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class AppConfig {
  private static final Config CONFIG = ConfigFactory.load();

  public static Config getConfig() {
    return CONFIG;
  }
}
