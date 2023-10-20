package com.serialization;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Customer implements Serializable {

    private long customerId;
    private String name;

    private String email;

    private String phoneNo;

    private transient Date localDate;

    private String address;



    @JsonCreator
    public Customer(@JsonProperty("name")String name, @JsonProperty("email") String email, @JsonProperty("phoneNo")String phoneNo, @JsonProperty("localDate") Date localDate, @JsonProperty("address")String address) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.localDate = localDate;
        this.address = address;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Date getLocalDate() {
        return localDate;
    }

    public void setLocalDate(Date localDate) {
        this.localDate = localDate;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", localDate=" + localDate +
                ", address='" + address + '\'' +
                '}';
    }
}
