package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class BusinessImpl implements Business {

    @Getter
    @Setter
    String logo;

    List<String> orders = new ArrayList<>();

    @Override
    public String processOrder(int qty) {
        try {
            for (int i = 1; i < qty + 1; i++) {
                String orderId = String.format("Q%d", i);
                orders.add(orderId);
            }
            return "OK";
        } catch (Exception e) {
            return "FAIL";
        }
    }

    public int reportTotalOrder() {
        return orders.size();
    }

    public void initBusiness() {
        this.orders = new ArrayList<>();
    }

}
