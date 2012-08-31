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
 * AccountTransfer �׽�Ʈ���̽�
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 9. 1.
 */
public class AccountTransferTest {

    private AccountTransfer transfer;

    @Test
    public void testTransfer() {
        // 1. �غ�
        AccountDto sendAccount = createAccount("13-1", 1L, 1000L);
        AccountDto receiveAccount = createAccount("13-2", 2L, 500L);
        Long money = 200L;

        // 2. ����
        this.transfer = new AccountTransfer(sendAccount, receiveAccount, money);
        this.transfer.transfer();

        // 3. ����
        assertAccount(createAccount("13-1", 1L, 800L), this.transfer.getSendAccount());
        assertAccount(createAccount("13-2", 2L, 700L), this.transfer.getReceiveAccount());
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
