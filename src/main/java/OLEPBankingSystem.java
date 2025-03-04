public class OLEPBankingSystem {
    public static void main(String[] args) {
        // Создаем исполнители для трех учетных записей
        PaymentSystem.getExecutor("AccountA", 100.0);
        PaymentSystem.getExecutor("AccountB", 0.0);
        PaymentSystem.getExecutor("AccountC", 0.0);

        // Симулируем два запроса на оплату
        System.out.println("=== Начало транзакций ===");
        PaymentSystem.simulateTransaction("AccountA", "AccountB", 100.0);
        PaymentSystem.simulateTransaction("AccountA", "AccountC", 100.0);

        // Обрабатываем события для каждой учетной записи
        System.out.println("=== Обработка событий для AccountA ===");
        PaymentSystem.getExecutor("AccountA", 0.0).processEvents();
        System.out.println("=== Обработка событий для AccountB ===");
        PaymentSystem.getExecutor("AccountB", 0.0).processEvents();
        System.out.println("=== Обработка событий для AccountC ===");
        PaymentSystem.getExecutor("AccountC", 0.0).processEvents();

        // Финальные балансы
        System.out.println("=== Финальные балансы ===");
    }
}
