package com.cjay.ecom.userManagement.user;

import com.cjay.ecom.userManagement.addressInfo.Address;
import com.cjay.ecom.userManagement.paymentMethod.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class User {
    @Id
    @SequenceGenerator(
            name = "user_seq_generator",
            sequenceName = "user_seq_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_seq_generator"
    )
    private long id;
    private String name;
    private String userName;
    private String email;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private PaymentMethod defPaymentMethod;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;


    public String getEmail() {
        return email;
    }

    public User(String name, String userName, String email) {
        this.name = name;
        this.userName = userName;
        this.email = email;
    }

    public User(String name, String userName, String email, PaymentMethod defPaymentMethod, Address address) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.defPaymentMethod = defPaymentMethod;
        this.address = address;
    }
}
