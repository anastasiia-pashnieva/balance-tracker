package com.pashnieva.website.api.payment.dto;

import com.pashnieva.website.api.user.dto.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "account_balance")
public class AccountBalance {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;

    @OneToMany(mappedBy = "accountBalance", cascade = CascadeType.ALL)
    private List<CreditCard> creditCards;

    @Column(name = "cash_balance")
    private BigDecimal cashBalance;

    @Column(name = "total_balance")
    private BigDecimal totalBalance;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
