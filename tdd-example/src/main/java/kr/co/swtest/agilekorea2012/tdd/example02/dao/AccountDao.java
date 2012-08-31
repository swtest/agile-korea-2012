/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.dao;

import kr.co.swtest.agilekorea2012.tdd.example02.dto.AccountDto;

/**
 * ���� DAO
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 9. 1.
 */
public interface AccountDao {

    /**
     * ���� �߰�
     *
     * @param account ����
     * @return ���¹�ȣ. <code>not null</code> ����.
     */
    String createAccount(AccountDto account);

    /**
     * ���� ��ȸ
     *
     * @param accountNo ���¹�ȣ
     * @return ����. ������ <code>null</code>�� ������.
     */
    AccountDto readAccount(String accountNo);

    /**
     * ���� ����
     *
     * @param account ����
     */
    void updateAccount(AccountDto account);

    /**
     * ���� ����
     *
     * @param accountNo ���¹�ȣ
     */
    void deleteAccount(String accountNo);

}
