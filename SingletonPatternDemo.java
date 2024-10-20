// Singleton class
class ConfigurationManager {
    private static ConfigurationManager instance;

    private ConfigurationManager() {
        // private constructor to prevent instantiation
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    public void showConfiguration() {
        System.out.println("Configuration details...");
    }
}

// Testing the Singleton Pattern
public class SingletonPatternDemo {
    public static void main(String[] args) {
        ConfigurationManager configManager1 = ConfigurationManager.getInstance();
        ConfigurationManager configManager2 = ConfigurationManager.getInstance();

        System.out.println(configManager1 == configManager2); // true, both references point to the same instance

        configManager1.showConfiguration();
    }
}
