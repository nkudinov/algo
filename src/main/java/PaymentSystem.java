import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

class PaymentSystem {
    private static final Map<String, AccountLog> accountLogs = new ConcurrentHashMap<>();
    private static final Map<String, AccountExecutor> executors = new ConcurrentHashMap<>();

    public static synchronized AccountLog getLog(String accountId) {
        return accountLogs.computeIfAbsent(accountId, id -> new AccountLog());
    }

    public static synchronized AccountExecutor getExecutor(String accountId, double initialBalance) {
        return executors.computeIfAbsent(accountId, id -> new AccountExecutor(accountId, getLog(accountId), initialBalance));
    }

    public static void simulateTransaction(String sourceAccount, String destinationAccount, double amount) {
        String eventId = UUID.randomUUID().toString();
        AccountLog sourceLog = getLog(sourceAccount);
        sourceLog.append(new Event(eventId, "PAYMENT_REQUEST", amount, sourceAccount, destinationAccount));
    }
}