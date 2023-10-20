package com.serialization;

import java.util.Date;
import java.io.Serializable;

public class Order implements Serializable {

    private long orderId;

    private long customerId;

    private long productId;

    private Date localDateTime;

    private String address;


    public Order() {

    }

    public Order(long customerId, long productId, Date localDateTime, String address) {
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

    public Date getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(Date localDateTime) {
        this.localDateTime = localDateTime;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCustomerId() {
        return customerId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", localDateTime=" + localDateTime +
                ", address='" + address + '\'' +
                '}';
    }
}
