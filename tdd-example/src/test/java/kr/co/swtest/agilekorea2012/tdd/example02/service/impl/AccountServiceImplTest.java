/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.SortedMap;
import java.util.TreeMap;

import kr.co.swtest.agilekorea2012.tdd.example02.dao.impl.AccountDaoPojoImpl;
import kr.co.swtest.agilekorea2012.tdd.example02.dao.impl.CustomerDaoPojoImpl;
import kr.co.swtest.agilekorea2012.tdd.example02.dto.AccountDto;
import kr.co.swtest.agilekorea2012.tdd.example02.dto.CustomerDto;
import kr.co.swtest.agilekorea2012.tdd.example02.service.AccountService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * AccountServiceImpl �׽�Ʈ���̽�
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 9. 1.
 */
public class AccountServiceImplTest {

    /** ���� ���� : SUT(�׽�Ʈ���, System Under Test) */
    private AccountService service;

    /**
     * Setup (Test Fixture ����)
     */
    @Before
    public void before() {
        AccountServiceImpl serviceImpl = new AccountServiceImpl();

        SortedMap<String, AccountDto> accountMap = new TreeMap<String, AccountDto>();
        accountMap.put("13-1", createAccount("13-1", 1L, 1000L));
        accountMap.put("13-2", createAccount("13-2", 2L, 500L));
        serviceImpl.setAccountDao(new AccountDaoPojoImpl(accountMap));

        serviceImpl.setCustomerDao(new CustomerDaoPojoImpl());

        this.service = serviceImpl;
    }

    /**
     * TearDown (Test Fixture �ʱ�ȭ)
     */
    @After
    public void after() {
        this.service = null;
    }

    // -------------------------------------------------------------------------
    // Test Method
    // -------------------------------------------------------------------------

    /**
     * ���� ��ü �׽�Ʈ
     * <pre>
     * �׽�Ʈ �ó�����
     *
     * "13-1"�� ���´� 1000���� ����.
     * "13-2"�� ���´� 500���� ����.
     * "13-1"�� ���¿��� "13-2"�� ���·� 200���� ��ü
     * ����Ǵ� ����� "13-1"�� ���¿� 800���� �����ְ�, "13-2"�� ���¿� 200���� ��������.
     * </pre>
     */
    @Test
    public void testDoAccountTransfer() {
        // 1. ��ü
        this.service.doAccountTransfer("13-1", "13-2", 200L);

        // 2. ����
        AccountDto senderAccount = this.service.readAccount("13-1");
        assertAccount(createAccount("13-1", 1L, 800L), senderAccount);

        AccountDto receiverAccount = this.service.readAccount("13-2");
        assertAccount(createAccount("13-2", 2L, 700L), receiverAccount);
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
