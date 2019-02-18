package com.pashnieva.website.api.transaction.dto;

import com.pashnieva.website.api.check.dto.Check;
import com.pashnieva.website.api.user.dto.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.pashnieva.website.common.util.StringUtils.isNotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    private Long id;
    private TransactionStatus status;
    private TransactionType transactionType;
    private BigDecimal amount;
    private BillingDetails billingDetails;
    private User user;
    private Check check;
    private LocalDate date;


    public enum TransactionType {
        WITHDRAW, REFILL;

        public TransactionType getPaymentType(String name) {
            return isNotBlank(name) ? TransactionType.valueOf(name.toUpperCase()) : null;
        }
    }

    public enum TransactionStatus {
        PLANNED, COMPLETED;

        public TransactionStatus getTransactionStatus(String name) {
            return isNotBlank(name) ? TransactionStatus.valueOf(name.toUpperCase()) : null;
        }
    }
}
