import java.util.*;
import java.util.stream.Collectors;

public class TransactionProcessor {

    public static List<String> findRejectedTransactions(List<String> transactions, int creditLimit) {
        Map<String, Integer> approvedSums = new HashMap<>();

        return transactions.stream()
                .filter(transaction -> {
                    String[] parts = transaction.split(",");
                    String consumerKey = parts[0] + "," + parts[1] + "," + parts[2];
                    int amount = Integer.parseInt(parts[3]);

                    approvedSums.putIfAbsent(consumerKey, 0);
                    var test = approvedSums.get(consumerKey);

                    if (approvedSums.get(consumerKey) + amount > creditLimit) {
                        return true; // This transaction is rejected
                    } else {
                        approvedSums.put(consumerKey, approvedSums.get(consumerKey) + amount);
                        return false; // This transaction is approved
                    }
                })
                .map(transaction -> transaction.split(",")[4]) // Extract transaction id
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(findRejectedTransactions(new ArrayList<>(), 0)); // Outputs: []
        System.out.println(findRejectedTransactions(Arrays.asList("John,Doe,john@doe.com,200,TR0001"), 200)); // Outputs: []
        System.out.println(findRejectedTransactions(Arrays.asList("Jane,Doe,jane@doe.com,201,TR0001"), 200)); // Outputs: [TR0001]
        System.out.println(findRejectedTransactions(Arrays.asList("Jane,Doe,jane@doe.com,199,TR0001", "Jane,Doe,jane@doe.com,2,TR0002"), 200));
        System.out.println(findRejectedTransactions(Arrays.asList("Jane,Doe,jane@doe.com,199,TR0001", "Jane,Doe,jane@doe.com,2,TR0002", "Mohanad,Doe,jane@doe.com,206,TR0003"), 200)); // Outputs: [TR0002]
    }
}