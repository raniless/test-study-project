package part1.ch7;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestAccountService {
    @Test
    public void testTransferOk() {
        MockAccountManager mockAccountManager = new MockAccountManager();

        Account senderAccount = new Account("1", 200);
        Account beneficiaryAccount = new Account("2", 100);
        mockAccountManager.addAccount("1", senderAccount);
        mockAccountManager.addAccount("2", beneficiaryAccount);

        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);
        accountService.transfer("1", "2", 50);

        assertEquals(150, senderAccount.getBalance());
        assertEquals(150, beneficiaryAccount.getBalance());
    }

    @Test
    public void testFindAccountByUser() {
        MockLog logger = new MockLog();
        MockConfiguration configuration = new MockConfiguration();
        configuration.setSQL("select * [...]");
        DefaultAccountManager am = new DefaultAccountManager(logger, configuration);
        Account account = am.findAccountForUser("1234");
        //이곳에서 확인 수행
    }
}
