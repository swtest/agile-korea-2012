/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.dao;

import kr.co.swtest.agilekorea2012.tdd.example02.dto.CustomerDto;

/**
 * �� DAO
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 8. 22.
 */
public interface CustomerDao {

    /**
     * �� �߰�
     *
     * @param customer ��
     * @return ����ȣ. <code>not null</code> ����.
     */
    Long createCustomer(CustomerDto customer);

    /**
     * �� ��ȸ
     *
     * @param customerNo ����ȣ
     * @return ��. ������ <code>null</code>�� ������.
     */
    CustomerDto readCustomerByNo(Long customerNo);

    /**
     * �� ����
     *
     * @param customer ��
     */
    void updateCustomer(CustomerDto customer);

    /**
     * �� ����
     *
     * @param customerNo ����ȣ
     */
    void deleteCustomerByNo(Long customerNo);

}
