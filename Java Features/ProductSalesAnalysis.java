import java.util.*;
import java.util.stream.Collectors;
public class ProductSalesAnalysis {
    static class Sale
    {
        int productId;
        int quantity;
        double price;

        Sale(int productId, int quantity, double price)
        {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }
    }
    static class ProductSales
    {
        int productId;
        double totalRevenue;
        ProductSales(int productId, double totalRevenue)
        {
            this.productId = productId;
            this.totalRevenue = totalRevenue;
        }
        @Override
        public String toString()
        {
            return "ProductID: " + productId + ", Revenue: $" + String.format("%.2f", totalRevenue);
        }
    }
    public static void analyzeSales(List<Sale> sales)
    {
        List<Sale> filtered = sales.stream()
                .filter(s -> s.quantity > 10)
                .collect(Collectors.toList());
        Map<Integer, Double> revenueByProduct = filtered.stream()
                .collect(Collectors.groupingBy(
                        s -> s.productId,
                        Collectors.summingDouble(s -> s.quantity * s.price)
                ));
        List<ProductSales> productSalesList = revenueByProduct.entrySet().stream()
                .map(entry -> new ProductSales(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        List<ProductSales> sortedList = productSalesList.stream()
                .sorted((a, b) -> Double.compare(b.totalRevenue, a.totalRevenue))
                .collect(Collectors.toList());
        List<ProductSales> top5 = sortedList.stream()
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("Top 5 Products by Revenue:");
        top5.forEach(System.out::println);
    }
    public static void main(String[] args)
    {
        List<Sale> sales = Arrays.asList(
                new Sale(101, 5, 100.0),
                new Sale(102, 20, 50.0),
                new Sale(103, 15, 30.0),
                new Sale(104, 25, 80.0),
                new Sale(105, 12, 200.0),
                new Sale(106, 9, 150.0),
                new Sale(107, 18, 40.0),
                new Sale(108, 30, 20.0),
                new Sale(102, 12, 60.0)
        );
        analyzeSales(sales);
    }
}
