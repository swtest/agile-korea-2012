/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.dao;

import kr.co.swtest.agilekorea2012.tdd.example02.dto.AccountDto;

/**
 * 계좌 DAO
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 * @since 2012. 9. 1.
 */
public interface AccountDao {

    /**
     * 계좌 추가
     *
     * @param account 계좌
     * @return 계좌번호. <code>not null</code> 보장.
     */
    String createAccount(AccountDto account);

    /**
     * 계좌 조회
     *
     * @param accountNo 계좌번호
     * @return 계좌. 없으면 <code>null</code>을 리턴함.
     */
    AccountDto readAccount(String accountNo);

    /**
     * 계좌 수정
     *
     * @param account 계좌
     */
    void updateAccount(AccountDto account);

    /**
     * 계좌 삭제
     *
     * @param accountNo 계좌번호
     */
    void deleteAccount(String accountNo);

}
