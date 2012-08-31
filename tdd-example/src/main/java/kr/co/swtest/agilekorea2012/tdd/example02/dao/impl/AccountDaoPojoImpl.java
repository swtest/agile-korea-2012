/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.dao.impl;

import java.util.SortedMap;

import kr.co.swtest.agilekorea2012.tdd.example02.dao.AccountDao;
import kr.co.swtest.agilekorea2012.tdd.example02.dto.AccountDto;

/**
 * ���� DAO : POJO ����ü
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 9. 1.
 */
public class AccountDaoPojoImpl implements AccountDao {

    /** ���� Map : DB ��� */
    private SortedMap<String, AccountDto> accountMap;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * ������
     *
     * @param accountMap ���� Map
     */
    public AccountDaoPojoImpl(SortedMap<String, AccountDto> accountMap) {
        this.accountMap = accountMap;
    }

    // -------------------------------------------------------------------------
    // Public Method
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public String createAccount(AccountDto account) {
        this.accountMap.put(account.getAccountNo(), account);
        return account.getAccountNo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountDto readAccount(String accountNo) {
        return this.accountMap.get(accountNo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateAccount(AccountDto account) {
        this.accountMap.put(account.getAccountNo(), account);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAccount(String accountNo) {
        this.accountMap.remove(accountNo);
    }

}
