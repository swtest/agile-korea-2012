/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.dto;

import java.io.Serializable;

/**
 * ���� DTO
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 8. 31.
 */
public class AccountDto implements Serializable {

    /** UID */
    private static final long serialVersionUID = 8965460940194103589L;

    /** ���¹�ȣ */
    private String accountNo;

    /** �� */
    private CustomerDto customer;

    /** �ܾ� : ��Ȯ�� ������ ���ؼ��� BigDecimal�� �̿��ϱ⸦ �ٶ�. */
    private Long balance;

    // -------------------------------------------------------------------------
    // Getter and Setter
    // -------------------------------------------------------------------------

    /**
     * @return ���¹�ȣ
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo ���¹�ȣ
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * @return ��
     */
    public CustomerDto getCustomer() {
        return customer;
    }

    /**
     * @param customer ��
     */
    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    /**
     * @return �ܾ�
     */
    public Long getBalance() {
        return balance;
    }

    /**
     * @param balance �ܾ�
     */
    public void setBalance(Long balance) {
        this.balance = balance;
    }

}
