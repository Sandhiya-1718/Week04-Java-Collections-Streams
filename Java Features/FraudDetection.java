import java.util.*;
import java.util.stream.Collectors;
public class FraudDetection {
    static class Transaction {
        String transactionId;
        String policyNumber;
        double amount;
        String transactionDate;
        boolean isFraudulent;
        public Transaction(String transactionId, String policyNumber, double amount, String transactionDate, boolean isFraudulent)
        {
            this.transactionId = transactionId;
            this.policyNumber = policyNumber;
            this.amount = amount;
            this.transactionDate = transactionDate;
            this.isFraudulent = isFraudulent;
        }
    }
    static class FraudAlert
    {
        String policyNumber;
        int totalFraudulentTransactions;
        double totalFraudAmount;
        public FraudAlert(String policyNumber, int totalFraudulentTransactions, double totalFraudAmount)
        {
            this.policyNumber = policyNumber;
            this.totalFraudulentTransactions = totalFraudulentTransactions;
            this.totalFraudAmount = totalFraudAmount;
        }
        @Override
        public String toString()
        {
            return "Policy: " + policyNumber + " | Fraudulent Transactions: " + totalFraudulentTransactions
                    + " | Total Fraud Amount: $" + String.format("%.2f", totalFraudAmount);
        }
    }
    public static void detectFraud(List<Transaction> transactions)
    {
        List<Transaction> filteredTransactions = transactions.stream()
                .filter(t -> t.isFraudulent && t.amount > 10000)
                .toList();
        Map<String, List<Transaction>> groupedByPolicy = filteredTransactions.stream()
                .collect(Collectors.groupingBy(t -> t.policyNumber));
        List<FraudAlert> fraudAlerts = groupedByPolicy.entrySet().stream()
                .map(entry -> {
                    String policyNumber = entry.getKey();
                    List<Transaction> policyTransactions = entry.getValue();
                    int totalFraudulentTransactions = policyTransactions.size();
                    double totalFraudAmount = policyTransactions.stream()
                            .mapToDouble(t -> t.amount)
                            .sum();
                    return new FraudAlert(policyNumber, totalFraudulentTransactions, totalFraudAmount);
                })
                .toList();
        fraudAlerts.stream()
                .filter(alert -> alert.totalFraudulentTransactions > 5 || alert.totalFraudAmount > 50000)
                .forEach(System.out::println);
    }
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T001", "P001", 15000, "2025-04-01", true),
                new Transaction("T002", "P001", 5000, "2025-04-02", true),
                new Transaction("T003", "P002", 20000, "2025-04-03", true),
                new Transaction("T004", "P001", 30000, "2025-04-04", true),
                new Transaction("T005", "P003", 12000, "2025-04-05", true),
                new Transaction("T006", "P002", 8000, "2025-04-06", true),
                new Transaction("T007", "P001", 45000, "2025-04-07", true),
                new Transaction("T008", "P001", 2000, "2025-04-08", true),
                new Transaction("T009", "P003", 15000, "2025-04-09", true),
                new Transaction("T010", "P003", 7000, "2025-04-10", true),
                new Transaction("T011", "P003", 12000, "2025-04-11", true)
        );
        detectFraud(transactions);
    }
}
