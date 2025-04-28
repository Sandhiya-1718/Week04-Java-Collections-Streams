import java.util.*;
import java.util.stream.Collectors;
public class InsuranceApp {
    static class InsurancePolicy {
        String policyNumber;
        String holderName;
        double premiumAmount;
        public InsurancePolicy(String policyNumber, String holderName, double premiumAmount)
        {
            this.policyNumber = policyNumber;
            this.holderName = holderName;
            this.premiumAmount = premiumAmount;
        }
        @Override
        public String toString()
        {
            return "Policy Number: " + policyNumber + ", Holder Name: " + holderName + ", Premium: $" + premiumAmount;
        }
    }
    public static List<InsurancePolicy> filterPoliciesByPremium(List<InsurancePolicy> policies)
    {
        return policies.stream()
                .filter(p -> p.premiumAmount > 1200)
                .collect(Collectors.toList());
    }
    public static List<InsurancePolicy> sortPoliciesByHolderName(List<InsurancePolicy> policies)
    {
        return policies.stream()
                .sorted(Comparator.comparing(p -> p.holderName))
                .collect(Collectors.toList());
    }
    public static double computeTotalPremium(List<InsurancePolicy> policies)
    {
        return policies.stream()
                .mapToDouble(p -> p.premiumAmount)
                .sum();
    }
    public static void printPolicyDetails(List<InsurancePolicy> policies)
    {
        policies.forEach(System.out::println);
    }
    public static List<InsurancePolicy> filterPoliciesByPremiumRange(List<InsurancePolicy> policies)
    {
        return policies.stream()
                .filter(p -> p.premiumAmount >= 1000 && p.premiumAmount <= 2000)
                .collect(Collectors.toList());
    }
    public static Optional<InsurancePolicy> findPolicyWithHighestPremium(List<InsurancePolicy> policies)
    {
        return policies.stream()
                .max(Comparator.comparing(p -> p.premiumAmount));
    }
    public static Map<Character, List<InsurancePolicy>> groupPoliciesByInitial(List<InsurancePolicy> policies)
    {
        return policies.stream()
                .collect(Collectors.groupingBy(p -> p.holderName.charAt(0)));
    }
    public static double computeAveragePremium(List<InsurancePolicy> policies)
    {
        return policies.stream()
                .mapToDouble(p -> p.premiumAmount)
                .average()
                .orElse(0);
    }
    public static void sortPoliciesByPremiumAndPrint(List<InsurancePolicy> policies)
    {
        policies.stream()
                .sorted(Comparator.comparingDouble(p -> p.premiumAmount))
                .forEach(System.out::println);
    }
    public static boolean checkIfAnyPolicyExceedsPremium(List<InsurancePolicy> policies, double premium)
    {
        return policies.stream()
                .anyMatch(p -> p.premiumAmount > premium);
    }
    public static Map<String, Long> countPoliciesByPremiumRange(List<InsurancePolicy> policies)
    {
        return policies.stream()
                .collect(Collectors.groupingBy(p -> {
                    if (p.premiumAmount <= 1000) return "$0 - $1,000";
                    if (p.premiumAmount <= 2000) return "$1,001 - $2,000";
                    return ">$2,000";
                }, Collectors.counting()));
    }
    public static List<String> extractUniqueHolderNames(List<InsurancePolicy> policies)
    {
        return policies.stream()
                .map(p -> p.holderName)
                .distinct()
                .collect(Collectors.toList());
    }
    public static List<InsurancePolicy> findPoliciesByHolderNameSubstring(List<InsurancePolicy> policies, String substring)
    {
        return policies.stream()
                .filter(p -> p.holderName.contains(substring))
                .collect(Collectors.toList());
    }
    public static Map<String, Double> createMapOfPolicyNumbersToPremium(List<InsurancePolicy> policies)
    {
        return policies.stream()
                .collect(Collectors.toMap(p -> p.policyNumber, p -> p.premiumAmount));
    }
    public static void main(String[] args)
    {
        List<InsurancePolicy> policies = Arrays.asList(
                new InsurancePolicy("P001", "John Smith", 1500),
                new InsurancePolicy("P002", "Mary Johnson", 800),
                new InsurancePolicy("P003", "James Wilson", 2200),
                new InsurancePolicy("P004", "Emily Davis", 1300),
                new InsurancePolicy("P005", "Michael Brown", 1800),
                new InsurancePolicy("P006", "Linda Miller", 2100)
        );
        System.out.println("Filtered Policies with Premium > $1,200:");
        filterPoliciesByPremium(policies).forEach(System.out::println);
        System.out.println("\nSorted Policies by Holder Name:");
        sortPoliciesByHolderName(policies).forEach(System.out::println);
        System.out.println("\nTotal Premium:");
        System.out.println(computeTotalPremium(policies));
        System.out.println("\nFiltered Policies with Premium between $1,000 and $2,000:");
        filterPoliciesByPremiumRange(policies).forEach(System.out::println);
        System.out.println("\nPolicy with Highest Premium:");
        findPolicyWithHighestPremium(policies).ifPresent(System.out::println);
        System.out.println("\nGrouped Policies by Holder Name Initial:");
        groupPoliciesByInitial(policies).forEach((k, v) -> {
            System.out.println(k + ":");
            v.forEach(System.out::println);
        });
        System.out.println("\nAverage Premium:");
        System.out.println(computeAveragePremium(policies));
        System.out.println("\nSorted Policies by Premium and Printed:");
        sortPoliciesByPremiumAndPrint(policies);
        System.out.println("\nCheck if any policy exceeds $2,000:");
        System.out.println(checkIfAnyPolicyExceedsPremium(policies, 2000));
        System.out.println("\nCount Policies in Each Premium Range:");
        countPoliciesByPremiumRange(policies).forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("\nUnique Holder Names:");
        extractUniqueHolderNames(policies).forEach(System.out::println);
        System.out.println("\nPolicies by Holder Name Substring (e.g. 'John'):");
        findPoliciesByHolderNameSubstring(policies, "John").forEach(System.out::println);
        System.out.println("\nMap of Policy Numbers to Premium Amounts:");
        createMapOfPolicyNumbersToPremium(policies).forEach((k, v) -> System.out.println(k + ": $" + v));
    }
}
