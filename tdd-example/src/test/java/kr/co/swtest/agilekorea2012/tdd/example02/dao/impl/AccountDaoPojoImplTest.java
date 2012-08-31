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
 * AccountDaoPojoImpl 테스트케이스
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
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
     * 계좌 추가 테스트
     */
    @Test
    public void testCreateAccount() {
        // 1. 추가 전 검증
        AccountDto createAccount = createAccount("13-3", 3L, 2000L);

        AccountDto readAccount = this.dao.readAccount(createAccount.getAccountNo());
        assertNull(readAccount);

        // 2. 추가
        this.dao.createAccount(createAccount);

        // 3. 추가 후 검증
        readAccount = this.dao.readAccount(createAccount.getAccountNo());
        assertAccount(createAccount, readAccount);
    }

    /**
     * 계좌 조회 테스트
     */
    @Test
    public void testReadAccount() {
        // 1. 조회
        String accountNo = "13-1";
        AccountDto result = this.dao.readAccount(accountNo);

        // 2. 검증
        assertAccount(createAccount(accountNo, 1L, 1000L), result);
    }

    /**
     * 계좌 수정 테스트
     */
    @Test
    public void testUpdateAccount() {
        // 1. 수정 전 검증
        String accountNo = "13-1";
        AccountDto readAccount = this.dao.readAccount(accountNo);
        assertAccount(createAccount(accountNo, 1L, 1000L), readAccount);

        // 2. 수정
        AccountDto account = readAccount;
        account.setCustomer(new CustomerDto(2L));
        account.setBalance(3000L);

        // 3. 수정 후 검증
        readAccount = this.dao.readAccount(accountNo);
        assertAccount(account, readAccount);
    }

    /**
     * 계좌 삭제 테스트
     */
    @Test
    public void testDeleteAccount() {
        // 1. 삭제 전 검증
        String accountNo = "13-1";
        AccountDto readAccount = this.dao.readAccount(accountNo);
        assertNotNull(readAccount);

        // 2. 삭제
        this.dao.deleteAccount(accountNo);

        // 3. 삭제 후 검증
        readAccount = this.dao.readAccount(accountNo);
        assertNull(readAccount);
    }

    // -------------------------------------------------------------------------
    // Private Method
    // -------------------------------------------------------------------------

    /**
     * 계좌 생성
     *
     * @param accountNo 계좌번호
     * @param customerNo 고객번호
     * @param balance 잔액
     * @return 계좌. <code>not null</code> 보장.
     */
    private AccountDto createAccount(String accountNo, Long customerNo, Long balance) {
        AccountDto account = new AccountDto();
        account.setAccountNo(accountNo);
        account.setCustomer(new CustomerDto(customerNo));
        account.setBalance(balance);
        return account;
    }

    /**
     * 계좌 검증 <br/>
     * 검증대상 : 계좌번호, 고객번호, 잔액
     *
     * @param expected 기대하는 계좌 정보
     * @param actual 실제 계좌 정보
     */
    private void assertAccount(AccountDto expected, AccountDto actual) {
        assertEquals(expected.getAccountNo(), actual.getAccountNo());
        assertEquals(expected.getCustomer().getCustomerNo(), actual.getCustomer().getCustomerNo());
        assertEquals(expected.getBalance(), actual.getBalance());
    }

}
