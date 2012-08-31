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
 * AccountServiceImpl 테스트케이스
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 * @since 2012. 9. 1.
 */
public class AccountServiceImplTest {

    /** 계좌 서비스 : SUT(테스트대상, System Under Test) */
    private AccountService service;

    /**
     * Setup (Test Fixture 구성)
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
     * TearDown (Test Fixture 초기화)
     */
    @After
    public void after() {
        this.service = null;
    }

    // -------------------------------------------------------------------------
    // Test Method
    // -------------------------------------------------------------------------

    /**
     * 계좌 이체 테스트
     * <pre>
     * 테스트 시나리오
     *
     * "13-1"번 계좌는 1000원이 있음.
     * "13-2"번 계좌는 500원이 있음.
     * "13-1"번 계좌에서 "13-2"번 계좌로 200원을 이체
     * 예상되는 결과는 "13-1"번 계좌에 800원이 남아있고, "13-2"번 계좌에 200원이 남아있음.
     * </pre>
     */
    @Test
    public void testDoAccountTransfer() {
        // 1. 이체
        this.service.doAccountTransfer("13-1", "13-2", 200L);

        // 2. 검증
        AccountDto senderAccount = this.service.readAccount("13-1");
        assertAccount(createAccount("13-1", 1L, 800L), senderAccount);

        AccountDto receiverAccount = this.service.readAccount("13-2");
        assertAccount(createAccount("13-2", 2L, 700L), receiverAccount);
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
