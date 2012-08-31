/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.domain;

import kr.co.swtest.agilekorea2012.tdd.example02.dto.AccountDto;

/**
 * ���� ��ü<br/>
 * ��ü�� ���õ� ���� �� ó���� å����.
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 9. 1.
 */
public class AccountTransfer {

    /** �۱ݰ��� */
    private AccountDto sendAccount;

    /** ���Ű��� */
    private AccountDto receiveAccount;

    /** ��ü�ݾ� */
    private Long money;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * ������
     *
     * @param sendAccount �۱ݰ���
     * @param receiveAccount ���Ű���
     * @param money ��ü�ݾ�
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
     * ��ü
     */
    public void transfer() {
        // 1. �۱ݰ��¿��� ��ü�ݾ��� ����.
        this.sendAccount.setBalance(this.sendAccount.getBalance() - this.money);

        // 2. ���Ű��¿��� ��ü�ݾ��� ���Ѵ�.
        this.receiveAccount.setBalance(this.receiveAccount.getBalance() + this.money);
    }

    // -------------------------------------------------------------------------
    // Getter
    // -------------------------------------------------------------------------

    /**
     * @return �۱ݰ���
     */
    public AccountDto getSendAccount() {
        return sendAccount;
    }

    /**
     * @return ���Ű���
     */
    public AccountDto getReceiveAccount() {
        return receiveAccount;
    }

}
