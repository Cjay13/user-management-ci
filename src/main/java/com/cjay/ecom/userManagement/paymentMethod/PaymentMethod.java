package com.cjay.ecom.userManagement.paymentMethod;

import com.cjay.ecom.userManagement.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.context.annotation.ApplicationScope;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class PaymentMethod {
    public enum PaymentType {
        CREDIT_CARD,
        DEBIT_CARD,
        KOKO,
        MINT_PAY
    }
    @Id
    @SequenceGenerator(
            name = "pay_seq_gen",
            sequenceName = "pay_seq_gen",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pay_seq_gen"
    )
    private long id;
    private PaymentType type;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;



}
