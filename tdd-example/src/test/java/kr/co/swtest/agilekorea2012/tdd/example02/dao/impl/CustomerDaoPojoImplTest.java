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
 * CustomerDaoPojoImpl �׽�Ʈ���̽�
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 8. 22.
 */
public class CustomerDaoPojoImplTest {

    /** �� DAO : SUT(�׽�Ʈ���, System Under Test) */
    private CustomerDao dao;

    /**
     * Setup (Test Fixture ����)
     */
    @Before
    public void before() {
        Map<Long, CustomerDto> customerMap = new HashMap<Long, CustomerDto>();
        customerMap.put(1L, createCustomer(1L, "�ֿ���", "davidchoi@nextree.co.kr"));
        customerMap.put(2L, createCustomer(2L, "�ż���", null));

        this.dao = new CustomerDaoPojoImpl(customerMap);
    }

    /**
     * TearDown (Test Fixture �ʱ�ȭ)
     */
    @After
    public void after() {
        this.dao = null;
    }

    // -------------------------------------------------------------------------
    // Test Method
    // -------------------------------------------------------------------------

    /**
     * �� �߰� �׽�Ʈ
     */
    @Test
    public void testCreateCustomer() {
        // 1. �߰� �� ����
        CustomerDto createCustomer = createCustomer(3L, "������", null);

        CustomerDto readCustomer = this.dao.readCustomerByNo(createCustomer.getCustomerNo());
        assertNull(readCustomer);

        // 2. �߰�
        this.dao.createCustomer(createCustomer);

        // 3. �߰� �� ����
        readCustomer = this.dao.readCustomerByNo(createCustomer.getCustomerNo());
        assertCustomer(createCustomer, readCustomer);
    }

    /**
     * �� ��ȸ �׽�Ʈ
     */
    @Test
    public void testReadCustomerByNo() {
        // 1. ��ȸ
        Long customerNo = 1L;
        CustomerDto result = this.dao.readCustomerByNo(customerNo);

        // 2. ����
        assertCustomer(result, createCustomer(customerNo, "�ֿ���", "davidchoi@nextree.co.kr"));
    }

    /**
     * �� ���� �׽�Ʈ
     */
    @Test
    public void testUpdateCustomer() {
        // 1. ���� �� ����
        Long customerNo = 1L;
        CustomerDto readCustomer = this.dao.readCustomerByNo(customerNo);
        assertCustomer(readCustomer, createCustomer(customerNo, "�ֿ���", "davidchoi@nextree.co.kr"));

        // 2. ����
        CustomerDto customer = readCustomer;
        customer.setName("ȫ�浿");
        customer.setEmail("gdhong@nextree.co.kr");

        // 3. ���� �� ����
        readCustomer = this.dao.readCustomerByNo(customerNo);
        assertCustomer(customer, readCustomer);
    }

    /**
     * �� ���� �׽�Ʈ
     */
    @Test
    public void testDeleteCustomerByNo() {
        // 1. ���� �� ����
        Long customerNo = 1L;
        CustomerDto readCustomer = this.dao.readCustomerByNo(customerNo);
        assertNotNull(readCustomer);

        // 2. ����
        this.dao.deleteCustomerByNo(customerNo);

        // 3. ���� �� ����
        readCustomer = this.dao.readCustomerByNo(customerNo);
        assertNull(readCustomer);
    }

    // -------------------------------------------------------------------------
    // Private Method
    // -------------------------------------------------------------------------

    /**
     * �� ����
     *
     * @param customerNo ����ȣ
     * @param name ����
     * @param email �̸���
     * @return ��. <code>not null</code> ����.
     */
    private CustomerDto createCustomer(Long customerNo, String name, String email) {
        CustomerDto dto = new CustomerDto();
        dto.setCustomerNo(customerNo);
        dto.setName(name);
        dto.setEmail(email);
        return dto;
    }

    /**
     * �� ���� <br/>
     * ������� : ����ȣ, ����, �̸���
     *
     * @param expected ����ϴ� �� ����
     * @param actual ���� �� ����
     */
    private void assertCustomer(CustomerDto expected, CustomerDto actual) {
        assertEquals(expected.getCustomerNo(), actual.getCustomerNo());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getEmail(), actual.getEmail());
    }

}
