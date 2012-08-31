/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import kr.co.swtest.agilekorea2012.tdd.example02.dao.CustomerDao;
import kr.co.swtest.agilekorea2012.tdd.example02.dto.CustomerDto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * CustomerDaoPojoImpl 테스트케이스
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 * @since 2012. 8. 22.
 */
public class CustomerDaoPojoImplTest {

    /** 고객 DAO : SUT(테스트대상, System Under Test) */
    private CustomerDao dao;

    /**
     * Setup (Test Fixture 구성)
     */
    @Before
    public void before() {
        Map<Long, CustomerDto> customerMap = new HashMap<Long, CustomerDto>();
        customerMap.put(1L, createCustomer(1L, "최영목", "davidchoi@nextree.co.kr"));
        customerMap.put(2L, createCustomer(2L, "신세경", null));

        this.dao = new CustomerDaoPojoImpl(customerMap);
    }

    /**
     * TearDown (Test Fixture 초기화)
     */
    @After
    public void after() {
        this.dao = null;
    }

    // -------------------------------------------------------------------------
    // Test Method
    // -------------------------------------------------------------------------

    /**
     * 고객 추가 테스트
     */
    @Test
    public void testCreateCustomer() {
        // 1. 추가 전 검증
        CustomerDto createCustomer = createCustomer(3L, "김태희", null);

        CustomerDto readCustomer = this.dao.readCustomerByNo(createCustomer.getCustomerNo());
        assertNull(readCustomer);

        // 2. 추가
        this.dao.createCustomer(createCustomer);

        // 3. 추가 후 검증
        readCustomer = this.dao.readCustomerByNo(createCustomer.getCustomerNo());
        assertCustomer(createCustomer, readCustomer);
    }

    /**
     * 고객 조회 테스트
     */
    @Test
    public void testReadCustomerByNo() {
        // 1. 조회
        Long customerNo = 1L;
        CustomerDto result = this.dao.readCustomerByNo(customerNo);

        // 2. 검증
        assertCustomer(result, createCustomer(customerNo, "최영목", "davidchoi@nextree.co.kr"));
    }

    /**
     * 고객 수정 테스트
     */
    @Test
    public void testUpdateCustomer() {
        // 1. 수정 전 검증
        Long customerNo = 1L;
        CustomerDto readCustomer = this.dao.readCustomerByNo(customerNo);
        assertCustomer(readCustomer, createCustomer(customerNo, "최영목", "davidchoi@nextree.co.kr"));

        // 2. 수정
        CustomerDto customer = readCustomer;
        customer.setName("홍길동");
        customer.setEmail("gdhong@nextree.co.kr");

        // 3. 수정 후 검증
        readCustomer = this.dao.readCustomerByNo(customerNo);
        assertCustomer(customer, readCustomer);
    }

    /**
     * 고객 삭제 테스트
     */
    @Test
    public void testDeleteCustomerByNo() {
        // 1. 삭제 전 검증
        Long customerNo = 1L;
        CustomerDto readCustomer = this.dao.readCustomerByNo(customerNo);
        assertNotNull(readCustomer);

        // 2. 삭제
        this.dao.deleteCustomerByNo(customerNo);

        // 3. 삭제 후 검증
        readCustomer = this.dao.readCustomerByNo(customerNo);
        assertNull(readCustomer);
    }

    // -------------------------------------------------------------------------
    // Private Method
    // -------------------------------------------------------------------------

    /**
     * 고객 생성
     *
     * @param customerNo 고객번호
     * @param name 고객명
     * @param email 이메일
     * @return 고객. <code>not null</code> 보장.
     */
    private CustomerDto createCustomer(Long customerNo, String name, String email) {
        CustomerDto dto = new CustomerDto();
        dto.setCustomerNo(customerNo);
        dto.setName(name);
        dto.setEmail(email);
        return dto;
    }

    /**
     * 고객 검증 <br/>
     * 검증대상 : 고객번호, 고객명, 이메일
     *
     * @param expected 기대하는 고객 정보
     * @param actual 실제 고객 정보
     */
    private void assertCustomer(CustomerDto expected, CustomerDto actual) {
        assertEquals(expected.getCustomerNo(), actual.getCustomerNo());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getEmail(), actual.getEmail());
    }

}
