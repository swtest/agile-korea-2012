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
 * ������ü ���� ����ü
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 9. 1.
 */
public class AccountServiceImpl implements AccountService {

    /** ���� DAO */
    private AccountDao accountDao;

    /** ���� DAO */
    private CustomerDao customerDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doAccountTransfer(String sendAccountNo, String receiveAccountNo, Long money) {
        // 1. �۱ݰ��������� �����´�.
        AccountDto sendAccount = this.accountDao.readAccount(sendAccountNo);

        // 2. ���Ű��������� �����´�.
        AccountDto receiveAccount = this.accountDao.readAccount(receiveAccountNo);

        // 3. �۱ݰ��¿��� ��ü�ݾ��� ����.
        sendAccount.setBalance(sendAccount.getBalance() - money);

        // 4. ���Ű��¿��� ��ü�ݾ��� ���Ѵ�.
        receiveAccount.setBalance(receiveAccount.getBalance() + money);

        // 5. �۱ݰ�������
        this.accountDao.updateAccount(sendAccount);

        // 6. ���Ű�������
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
     * @param accountDao ���� DAO
     */
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * @param customerDao ���� DAO
     */
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

}