/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.domain;

import static org.junit.Assert.assertEquals;
import kr.co.swtest.agilekorea2012.tdd.example02.dto.AccountDto;
import kr.co.swtest.agilekorea2012.tdd.example02.dto.CustomerDto;

import org.junit.Test;

/**
 * AccountTransfer 테스트케이스
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 * @since 2012. 9. 1.
 */
public class AccountTransferTest {

    private AccountTransfer transfer;

    @Test
    public void testTransfer() {
        // 1. 준비
        AccountDto sendAccount = createAccount("13-1", 1L, 1000L);
        AccountDto receiveAccount = createAccount("13-2", 2L, 500L);
        Long money = 200L;

        // 2. 실행
        this.transfer = new AccountTransfer(sendAccount, receiveAccount, money);
        this.transfer.transfer();

        // 3. 검증
        assertAccount(createAccount("13-1", 1L, 800L), this.transfer.getSendAccount());
        assertAccount(createAccount("13-2", 2L, 700L), this.transfer.getReceiveAccount());
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
