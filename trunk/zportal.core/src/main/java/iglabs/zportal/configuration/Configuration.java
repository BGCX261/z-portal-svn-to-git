package iglabs.zportal.configuration;

public interface Configuration {
    String getValue(String key);
    String[] getValues(String key);
}
