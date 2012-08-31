/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.service;

import kr.co.swtest.agilekorea2012.tdd.example02.dto.AccountDto;

/**
 * ���� ����
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 9. 1.
 */
public interface AccountService {

    /**
     * ���� ��ü
     *
     * @param sendAccountNo �۱ݰ��¹�ȣ
     * @param receiveAccountNo ���Ű��¹�ȣ
     * @param money ��ü�ݾ�
     */
    void doAccountTransfer(String sendAccountNo, String receiveAccountNo, Long money);

    /**
     * ���� ��ȸ
     *
     * @param accountNo ���¹�ȣ
     * @return ����. ������ <code>null</code>�� ������.
     */
    AccountDto readAccount(String accountNo);

}
