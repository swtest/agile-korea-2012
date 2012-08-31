/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.service.impl;

import kr.co.swtest.agilekorea2012.tdd.example02.dao.AccountDao;
import kr.co.swtest.agilekorea2012.tdd.example02.dao.CustomerDao;
import kr.co.swtest.agilekorea2012.tdd.example02.domain.AccountTransfer;
import kr.co.swtest.agilekorea2012.tdd.example02.dto.AccountDto;
import kr.co.swtest.agilekorea2012.tdd.example02.service.AccountService;

/**
 * 계좌 서비스 구현체
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 * @since 2012. 9. 1.
 */
public class AccountServiceImpl implements AccountService {

    /** 계좌 DAO */
    private AccountDao accountDao;

    /** 고객 DAO */
    private CustomerDao customerDao;

    // -------------------------------------------------------------------------
    // Public Method
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public void doAccountTransfer(String sendAccountNo, String receiveAccountNo, Long money) {
        // 1. 송금계좌정보를 가져온다.
        AccountDto sendAccount = this.accountDao.readAccount(sendAccountNo);

        // 2. 수신계좌정보를 가져온다.
        AccountDto receiveAccount = this.accountDao.readAccount(receiveAccountNo);

        // 3. 이체처리를 한다.
        AccountTransfer transfer = new AccountTransfer(sendAccount, receiveAccount, money);
        transfer.transfer();

        // 4. 송금계좌저장
        this.accountDao.updateAccount(transfer.getSendAccount());

        // 5. 수신계좌저장
        this.accountDao.updateAccount(transfer.getReceiveAccount());
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
