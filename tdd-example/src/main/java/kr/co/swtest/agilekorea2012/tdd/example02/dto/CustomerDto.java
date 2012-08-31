/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.dto;

import java.io.Serializable;

/**
 * �� DTO
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 8. 22.
 */
public class CustomerDto implements Serializable {

    /** UID */
    private static final long serialVersionUID = 5499301690167211267L;

    /** ����ȣ */
    private Long customerNo;

    /** ���� */
    private String name;

    /** �̸��� */
    private String email;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * �⺻ ������
     */
    public CustomerDto() {
        // �ƹ� �ϵ� ���� ����
    }

    /**
     * ������
     *
     * @param customerNo ����ȣ
     */
    public CustomerDto(Long customerNo) {
        this.customerNo = customerNo;
    }

    // -------------------------------------------------------------------------
    // Getter and Setter
    // -------------------------------------------------------------------------

    /**
     * @return ����ȣ
     */
    public Long getCustomerNo() {
        return customerNo;
    }

    /**
     * @param customerNo ����ȣ
     */
    public void setCustomerNo(Long customerNo) {
        this.customerNo = customerNo;
    }

    /**
     * @return ����
     */
    public String getName() {
        return name;
    }

    /**
     * @param name ����
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return �̸���
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email �̸���
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
