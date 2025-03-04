class Event {
    String eventId;
    String type; // "PAYMENT_REQUEST", "OUTGOING_PAYMENT", "INCOMING_PAYMENT", etc.
    double amount;
    String sourceAccount;
    String destinationAccount;

    public Event(String eventId, String type, double amount, String sourceAccount, String destinationAccount) {
        this.eventId = eventId;
        this.type = type;
        this.amount = amount;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", sourceAccount='" + sourceAccount + '\'' +
                ", destinationAccount='" + destinationAccount + '\'' +
                '}';
    }
}