import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class AccountExecutor {
    private final String accountId;
    private final AccountLog log;
    private final Map<String, Double> balanceDatabase = new HashMap<>();
    private final Set<String> processedEventIds = ConcurrentHashMap.newKeySet();

    public AccountExecutor(String accountId, AccountLog log, double initialBalance) {
        this.accountId = accountId;
        this.log = log;
        this.balanceDatabase.put(accountId, initialBalance);
    }

    public void processEvents() {
        for (Event event : log.getEvents()) {
            if (processedEventIds.contains(event.eventId)) {
                // Skip already processed events
                continue;
            }
            handleEvent(event);
            processedEventIds.add(event.eventId);
        }
    }

    private void handleEvent(Event event) {
        switch (event.type) {
            case "PAYMENT_REQUEST":
                handlePaymentRequest(event);
                break;
            case "OUTGOING_PAYMENT":
            case "INCOMING_PAYMENT":
                updateBalance(event);
                break;
        }
    }

    private void handlePaymentRequest(Event event) {
        double currentBalance = balanceDatabase.getOrDefault(accountId, 0.0);
        if (currentBalance >= event.amount) {
            System.out.println("Payment approved: " + event);

            // Update outgoing payment
            log.append(new Event(
                    event.eventId,
                    "OUTGOING_PAYMENT",
                    -event.amount,
                    event.sourceAccount,
                    event.destinationAccount
            ));

            // Simulate appending to destination account log
            AccountLog destinationLog = PaymentSystem.getLog(event.destinationAccount);
            destinationLog.append(new Event(
                    event.eventId,
                    "INCOMING_PAYMENT",
                    event.amount,
                    event.sourceAccount,
                    event.destinationAccount
            ));
        } else {
            System.out.println("Payment declined due to insufficient funds: " + event);
        }
    }

    private void updateBalance(Event event) {
        balanceDatabase.put(
                accountId,
                balanceDatabase.getOrDefault(accountId, 0.0) + event.amount
        );
        System.out.println("Balance updated for " + accountId + ": " + balanceDatabase.get(accountId));
    }
}