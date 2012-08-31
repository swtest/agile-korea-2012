/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.dto;

import java.io.Serializable;

/**
 * 계좌 DTO
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 * @since 2012. 8. 31.
 */
public class AccountDto implements Serializable {

    /** UID */
    private static final long serialVersionUID = 8965460940194103589L;

    /** 계좌번호 */
    private String accountNo;

    /** 고객 */
    private CustomerDto customer;

    /** 잔액 : 정확한 연산을 위해서는 BigDecimal을 이용하기를 바람. */
    private Long balance;

    // -------------------------------------------------------------------------
    // Getter and Setter
    // -------------------------------------------------------------------------

    /**
     * @return 계좌번호
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo 계좌번호
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * @return 고객
     */
    public CustomerDto getCustomer() {
        return customer;
    }

    /**
     * @param customer 고객
     */
    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    /**
     * @return 잔액
     */
    public Long getBalance() {
        return balance;
    }

    /**
     * @param balance 잔액
     */
    public void setBalance(Long balance) {
        this.balance = balance;
    }

}
