/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.SortedMap;
import java.util.TreeMap;

import kr.co.swtest.agilekorea2012.tdd.example02.dao.AccountDao;
import kr.co.swtest.agilekorea2012.tdd.example02.dto.AccountDto;
import kr.co.swtest.agilekorea2012.tdd.example02.dto.CustomerDto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * AccountDaoPojoImpl �׽�Ʈ���̽�
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 9. 1.
 */
public class AccountDaoPojoImplTest {

    private AccountDao dao;

    @Before
    public void before() {
        SortedMap<String, AccountDto> accountMap = new TreeMap<String, AccountDto>();
        accountMap.put("13-1", createAccount("13-1", 1L, 1000L));
        accountMap.put("13-2", createAccount("13-2", 2L, 500L));

        this.dao = new AccountDaoPojoImpl(accountMap);
    }

    @After
    public void after() {

    }

    // -------------------------------------------------------------------------
    // Test Method
    // -------------------------------------------------------------------------

    /**
     * ���� �߰� �׽�Ʈ
     */
    @Test
    public void testCreateAccount() {
        // 1. �߰� �� ����
        AccountDto createAccount = createAccount("13-3", 3L, 2000L);

        AccountDto readAccount = this.dao.readAccount(createAccount.getAccountNo());
        assertNull(readAccount);

        // 2. �߰�
        this.dao.createAccount(createAccount);

        // 3. �߰� �� ����
        readAccount = this.dao.readAccount(createAccount.getAccountNo());
        assertAccount(createAccount, readAccount);
    }

    /**
     * ���� ��ȸ �׽�Ʈ
     */
    @Test
    public void testReadAccount() {
        // 1. ��ȸ
        String accountNo = "13-1";
        AccountDto result = this.dao.readAccount(accountNo);

        // 2. ����
        assertAccount(createAccount(accountNo, 1L, 1000L), result);
    }

    /**
     * ���� ���� �׽�Ʈ
     */
    @Test
    public void testUpdateAccount() {
        // 1. ���� �� ����
        String accountNo = "13-1";
        AccountDto readAccount = this.dao.readAccount(accountNo);
        assertAccount(createAccount(accountNo, 1L, 1000L), readAccount);

        // 2. ����
        AccountDto account = readAccount;
        account.setCustomer(new CustomerDto(2L));
        account.setBalance(3000L);

        // 3. ���� �� ����
        readAccount = this.dao.readAccount(accountNo);
        assertAccount(account, readAccount);
    }

    /**
     * ���� ���� �׽�Ʈ
     */
    @Test
    public void testDeleteAccount() {
        // 1. ���� �� ����
        String accountNo = "13-1";
        AccountDto readAccount = this.dao.readAccount(accountNo);
        assertNotNull(readAccount);

        // 2. ����
        this.dao.deleteAccount(accountNo);

        // 3. ���� �� ����
        readAccount = this.dao.readAccount(accountNo);
        assertNull(readAccount);
    }

    // -------------------------------------------------------------------------
    // Private Method
    // -------------------------------------------------------------------------

    /**
     * ���� ����
     *
     * @param accountNo ���¹�ȣ
     * @param customerNo ����ȣ
     * @param balance �ܾ�
     * @return ����. <code>not null</code> ����.
     */
    private AccountDto createAccount(String accountNo, Long customerNo, Long balance) {
        AccountDto account = new AccountDto();
        account.setAccountNo(accountNo);
        account.setCustomer(new CustomerDto(customerNo));
        account.setBalance(balance);
        return account;
    }

    /**
     * ���� ���� <br/>
     * ������� : ���¹�ȣ, ����ȣ, �ܾ�
     *
     * @param expected ����ϴ� ���� ����
     * @param actual ���� ���� ����
     */
    private void assertAccount(AccountDto expected, AccountDto actual) {
        assertEquals(expected.getAccountNo(), actual.getAccountNo());
        assertEquals(expected.getCustomer().getCustomerNo(), actual.getCustomer().getCustomerNo());
        assertEquals(expected.getBalance(), actual.getBalance());
    }

}
