/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.domain;

import kr.co.swtest.agilekorea2012.tdd.example02.dto.AccountDto;

/**
 * 계좌 이체<br/>
 * 이체에 관련된 검증 및 처리를 책임짐.
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 * @since 2012. 9. 1.
 */
public class AccountTransfer {

    /** 송금계좌 */
    private AccountDto sendAccount;

    /** 수신계좌 */
    private AccountDto receiveAccount;

    /** 이체금액 */
    private Long money;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * 생성자
     *
     * @param sendAccount 송금계좌
     * @param receiveAccount 수신계좌
     * @param money 이체금액
     */
    public AccountTransfer(AccountDto sendAccount, AccountDto receiveAccount, Long money) {
        this.sendAccount = sendAccount;
        this.receiveAccount = receiveAccount;
        this.money = money;
    }

    // -------------------------------------------------------------------------
    // Public Method
    // -------------------------------------------------------------------------

    /**
     * 이체
     */
    public void transfer() {
        // 1. 송금계좌에서 이체금액을 뺀다.
        this.sendAccount.setBalance(this.sendAccount.getBalance() - this.money);

        // 2. 수신계좌에서 이체금액을 더한다.
        this.receiveAccount.setBalance(this.receiveAccount.getBalance() + this.money);
    }

    // -------------------------------------------------------------------------
    // Getter
    // -------------------------------------------------------------------------

    /**
     * @return 송금계좌
     */
    public AccountDto getSendAccount() {
        return sendAccount;
    }

    /**
     * @return 수신계좌
     */
    public AccountDto getReceiveAccount() {
        return receiveAccount;
    }

}
