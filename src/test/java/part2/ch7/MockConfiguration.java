package part2.ch7;

public class MockConfiguration implements Configuration {
    public void setSQL(String sqlString) {
    }

    @Override
    public String getSQL(String sqlString) {
        return null;
    }
}
