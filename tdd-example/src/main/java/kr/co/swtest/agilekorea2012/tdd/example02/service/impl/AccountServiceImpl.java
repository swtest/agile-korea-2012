/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.service.impl;

import kr.co.swtest.agilekorea2012.tdd.example02.dao.AccountDao;
import kr.co.swtest.agilekorea2012.tdd.example02.dao.CustomerDao;
import kr.co.swtest.agilekorea2012.tdd.example02.dto.AccountDto;
import kr.co.swtest.agilekorea2012.tdd.example02.service.AccountService;

/**
 * 계좌이체 서비스 구현체
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 * @since 2012. 9. 1.
 */
public class AccountServiceImpl implements AccountService {

    /** 계좌 DAO */
    private AccountDao accountDao;

    /** 고객 DAO */
    private CustomerDao customerDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doAccountTransfer(String sendAccountNo, String receiveAccountNo, Long money) {
        // 1. 송금계좌정보를 가져온다.
        AccountDto sendAccount = this.accountDao.readAccount(sendAccountNo);

        // 2. 수신계좌정보를 가져온다.
        AccountDto receiveAccount = this.accountDao.readAccount(receiveAccountNo);

        // 3. 송금계좌에서 이체금액을 뺀다.
        sendAccount.setBalance(sendAccount.getBalance() - money);

        // 4. 수신계좌에서 이체금액을 더한다.
        receiveAccount.setBalance(receiveAccount.getBalance() + money);

        // 5. 송금계좌저장
        this.accountDao.updateAccount(sendAccount);

        // 6. 수신계좌저장
        this.accountDao.updateAccount(receiveAccount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountDto readAccount(String accountNo) {
        return this.accountDao.readAccount(accountNo);
    }

    // -------------------------------------------------------------------------
    // Setter
    // -------------------------------------------------------------------------

    /**
     * @param accountDao 계좌 DAO
     */
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * @param customerDao 고객 DAO
     */
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

}
