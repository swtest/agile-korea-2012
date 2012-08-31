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
 * �� DAO : POJO ����ü
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 8. 22.
 */
public class CustomerDaoPojoImpl implements CustomerDao {

    /** �� Map : DB ��� */
    private Map<Long, CustomerDto> customerMap;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * �⺻ ������
     */
    public CustomerDaoPojoImpl() {
        this.customerMap = new HashMap<Long, CustomerDto>();
    }

    /**
     * ������
     *
     * @param customerMap �� Map
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
