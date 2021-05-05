package part2.ch7;

public interface AccountManager {
    Account findAccountForUser(String userId);
    void updateAccount(Account account);
}
