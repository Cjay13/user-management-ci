package com.cjay.ecom.userManagement.addressInfo;

import com.cjay.ecom.userManagement.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Address {
    public enum AddressType {
        BILLING_ADDRESS,
        SHIPPING_ADDRESS
    }

    @Id
    @SequenceGenerator(
            name = "address_seq_gen",
            sequenceName = "address_seq_gen",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_seq_gen"
    )
    private long id;
    private AddressType addressType;
    private String homeNo;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;



}

