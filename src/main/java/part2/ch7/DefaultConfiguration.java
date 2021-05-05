package part2.ch7;

public class DefaultConfiguration implements Configuration {
    public DefaultConfiguration(String configurationName) {
    }

    @Override
    public String getSQL(String sqlString) {
        return null;
    }
}