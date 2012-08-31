/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.service;

import kr.co.swtest.agilekorea2012.tdd.example02.dto.AccountDto;

/**
 * 계좌 서비스
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 * @since 2012. 9. 1.
 */
public interface AccountService {

    /**
     * 계좌 이체
     *
     * @param sendAccountNo 송금계좌번호
     * @param receiveAccountNo 수신계좌번호
     * @param money 이체금액
     */
    void doAccountTransfer(String sendAccountNo, String receiveAccountNo, Long money);

    /**
     * 계좌 조회
     *
     * @param accountNo 계좌번호
     * @return 계좌. 없으면 <code>null</code>을 리턴함.
     */
    AccountDto readAccount(String accountNo);

}
