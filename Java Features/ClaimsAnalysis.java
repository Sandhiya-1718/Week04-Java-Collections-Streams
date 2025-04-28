import java.util.*;
import java.util.stream.Collectors;
public class ClaimsAnalysis {
    static class Claim
    {
        String claimId;
        String policyNumber;
        double claimAmount;
        String claimDate;
        String status;
        Claim(String claimId, String policyNumber, double claimAmount, String claimDate, String status)
        {
            this.claimId = claimId;
            this.policyNumber = policyNumber;
            this.claimAmount = claimAmount;
            this.claimDate = claimDate;
            this.status = status;
        }
    }
    static class PolicyStats
    {
        String policyNumber;
        double totalAmount;
        double averageAmount;
        PolicyStats(String policyNumber, double totalAmount, double averageAmount)
        {
            this.policyNumber = policyNumber;
            this.totalAmount = totalAmount;
            this.averageAmount = averageAmount;
        }
        @Override
        public String toString()
        {
            return "Policy: " + policyNumber +
                    ", Total: $" + String.format("%.2f", totalAmount) +
                    ", Average: $" + String.format("%.2f", averageAmount);
        }
    }
    public static void analyzeClaims(List<Claim> claims)
    {
        List<Claim> approvedClaims = claims.stream()
                .filter(c -> c.status.equalsIgnoreCase("Approved") && c.claimAmount > 5000)
                .collect(Collectors.toList());
        Map<String, List<Claim>> grouped = approvedClaims.stream()
                .collect(Collectors.groupingBy(c -> c.policyNumber));
        List<PolicyStats> statsList = grouped.entrySet().stream()
                .map(entry -> {
                    String policy = entry.getKey();
                    List<Claim> claimList = entry.getValue();
                    double total = claimList.stream().mapToDouble(c -> c.claimAmount).sum();
                    double avg = total / claimList.size();
                    return new PolicyStats(policy, total, avg);
                })
                .collect(Collectors.toList());
        List<PolicyStats> top3Policies = statsList.stream()
                .sorted((a, b) -> Double.compare(b.totalAmount, a.totalAmount))
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Top 3 Policies by Total Claim Amount:");
        top3Policies.forEach(System.out::println);
    }
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C101", "P1001", 7000, "2024-01-10", "Approved"),
                new Claim("C102", "P1002", 3000, "2024-02-11", "Rejected"),
                new Claim("C103", "P1001", 9000, "2024-03-15", "Approved"),
                new Claim("C104", "P1003", 15000, "2024-04-20", "Approved"),
                new Claim("C105", "P1002", 8000, "2024-05-05", "Approved"),
                new Claim("C106", "P1003", 4000, "2024-05-12", "Approved"),
                new Claim("C107", "P1004", 12000, "2024-06-01", "Approved")
        );
        analyzeClaims(claims);
    }
}
