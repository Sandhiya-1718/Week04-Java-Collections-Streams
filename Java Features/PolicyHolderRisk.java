import java.util.*;
import java.util.stream.Collectors;
public class PolicyHolderRisk {
    interface RiskCalculator
    {
        double calculateRisk(double premiumAmount, int age);
    }
    static class PolicyHolder
    {
        String holderId;
        String name;
        int age;
        String policyType;
        double premiumAmount;
        public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount)
        {
            this.holderId = holderId;
            this.name = name;
            this.age = age;
            this.policyType = policyType;
            this.premiumAmount = premiumAmount;
        }
    }
    static class RiskAssessment
    {
        String holderId;
        String name;
        double riskScore;
        public RiskAssessment(String holderId, String name, double riskScore)
        {
            this.holderId = holderId;
            this.name = name;
            this.riskScore = riskScore;
        }
        @Override
        public String toString()
        {
            return holderId + " - " + name + " (Risk Score: " + String.format("%.2f", riskScore) + ")";
        }
    }
    public static void assessRisk(List<PolicyHolder> holders, RiskCalculator calculator)
    {
        List<RiskAssessment> assessments = holders.stream()
                .filter(ph -> ph.policyType.equalsIgnoreCase("Life") && ph.age > 60)
                .map(ph -> new RiskAssessment(ph.holderId, ph.name, calculator.calculateRisk(ph.premiumAmount, ph.age)))
                .sorted((a, b) -> Double.compare(b.riskScore, a.riskScore))
                .collect(Collectors.toList());
        Map<String, List<RiskAssessment>> categorized = assessments.stream()
                .collect(Collectors.groupingBy(
                        ra -> ra.riskScore > 0.5 ? "High Risk" : "Low Risk"
                ));
        System.out.println("High Risk Policy Holders:");
        categorized.getOrDefault("High Risk", new ArrayList<>())
                .forEach(System.out::println);
        System.out.println("\nLow Risk Policy Holders:");
        categorized.getOrDefault("Low Risk", new ArrayList<>())
                .forEach(System.out::println);
    }
    public static void main(String[] args)
    {
        List<PolicyHolder> holders = Arrays.asList(
                new PolicyHolder("PH001", "Alice", 65, "Life", 39000),
                new PolicyHolder("PH002", "Bob", 61, "Life", 24000),
                new PolicyHolder("PH003", "Charlie", 70, "Health", 28000),
                new PolicyHolder("PH004", "David", 75, "Life", 32000),
                new PolicyHolder("PH005", "Eve", 85, "Life", 25000)
        );
        RiskCalculator calculator = (premiumAmount, age) -> premiumAmount / age;
        assessRisk(holders, calculator);
    }
}
