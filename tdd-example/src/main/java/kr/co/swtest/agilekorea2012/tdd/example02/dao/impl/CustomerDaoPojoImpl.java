/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.dao.impl;

import java.util.Map;

import kr.co.swtest.agilekorea2012.tdd.example02.dao.CustomerDao;
import kr.co.swtest.agilekorea2012.tdd.example02.dto.CustomerDto;

/**
 * 绊按 DAO : POJO 备泅眉
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">弥康格</a>
 * @since 2012. 8. 22.
 */
public class CustomerDaoPojoImpl implements CustomerDao {

    /** 绊按 Map : DB 措侩 */
    private Map<Long, CustomerDto> customerMap;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * 积己磊
     *
     * @param customerMap 绊按 Map
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
