package ru.javacode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Order {
    private final String product;
    private final double cost;
}