package com.serialization;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order extends Product implements Serializable {

    private long orderId;

    private long customerId;

    private long productId;

    private LocalDateTime localDateTime;

    private String address;


    public Order() {

    }

    public Order(long customerId, long productId, LocalDateTime localDateTime, String address) {
        this.customerId = customerId;
        this.productId = productId;
        this.localDateTime = localDateTime;
        this.address = address;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public long getProductId() {
        return productId;
    }

    @Override
    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
