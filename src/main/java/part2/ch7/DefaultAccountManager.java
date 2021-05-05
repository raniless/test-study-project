package part2.ch7;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultAccountManager implements AccountManager {
    private Log logger;
    private Configuration configuration;

    public DefaultAccountManager() {
        this(LogFactory.getLog(DefaultAccountManager.class), new DefaultConfiguration("technical"));
    }

    public DefaultAccountManager(Log logger, Configuration configuration) {
        this.logger = logger;
        this.configuration = configuration;
    }

    @Override
    public Account findAccountForUser(String userId) {
        this.logger.debug("Getting account for user ["+userId+"]");
        this.configuration.getSQL("FIND_ACCOUNT_FOR_USER");
        //JDBC를 이용해 사용자 계정을 읽어오는 코드 로직
        return null;
    }

    @Override
    public void updateAccount(Account account) {

    }
}
