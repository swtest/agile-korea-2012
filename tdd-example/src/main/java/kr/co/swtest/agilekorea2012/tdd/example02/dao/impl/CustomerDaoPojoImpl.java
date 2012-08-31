/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.dao.impl;

import java.util.HashMap;
import java.util.Map;

import kr.co.swtest.agilekorea2012.tdd.example02.dao.CustomerDao;
import kr.co.swtest.agilekorea2012.tdd.example02.dto.CustomerDto;

/**
 * 고객 DAO : POJO 구현체
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 * @since 2012. 8. 22.
 */
public class CustomerDaoPojoImpl implements CustomerDao {

    /** 고객 Map : DB 대용 */
    private Map<Long, CustomerDto> customerMap;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * 기본 생성자
     */
    public CustomerDaoPojoImpl() {
        this.customerMap = new HashMap<Long, CustomerDto>();
    }

    /**
     * 생성자
     *
     * @param customerMap 고객 Map
     */
    public CustomerDaoPojoImpl(Map<Long, CustomerDto> customerMap) {
        this.customerMap = customerMap;
    }

    // -------------------------------------------------------------------------
    // Public Method
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Long createCustomer(CustomerDto customer) {
        this.customerMap.put(customer.getCustomerNo(), customer);
        return customer.getCustomerNo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CustomerDto readCustomerByNo(Long customerNo) {
        return this.customerMap.get(customerNo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateCustomer(CustomerDto customer) {
        this.customerMap.put(customer.getCustomerNo(), customer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteCustomerByNo(Long customerNo) {
        this.customerMap.remove(customerNo);
    }

}
