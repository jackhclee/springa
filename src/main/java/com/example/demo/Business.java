package com.example.demo;

public interface Business {

    String getLogo();

    String processOrder(int qty);

    int reportTotalOrder();

    void initBusiness();
}
