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

        List<Order> sortedOrders = orders.stream()
                        .sorted((l, r) -> l.getCost() > r.getCost())

        System.out.println("Grouped by product: " + groupedByOrder);
    }
}