package ru.javacode;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        List<Order> orders = List.of(
            new Order("Laptop", 1200.0),
            new Order("Smartphone", 800.0),
            new Order("Laptop", 1500.0),
            new Order("Tablet", 500.0),
            new Order("Smartphone", 900.0)
        );

        Map<String, Double> groupedByOrder = orders.stream()
            .collect(Collectors.groupingBy(
                    Order::getProduct,
                    Collectors.summingDouble(Order::getCost)
                )
            );

        List<Order> sortedOrders = groupedByOrder.stream()
            .sorted((l, r) -> Double.compare(r.getCost(), l.getCost()))
            .limit(2)
            .collect(Collectors.toList());

        System.out.println("Grouped by product: ");
        groupedByOrder.forEach((product, cost) -> System.out.println(product + ": " + cost));
        System.out.println("Sorted by price: ");
        sortedOrders.forEach((order) -> System.out.println(order.getProduct()));
    }
}