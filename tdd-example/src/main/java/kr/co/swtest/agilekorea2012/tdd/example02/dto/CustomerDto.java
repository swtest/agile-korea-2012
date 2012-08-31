/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.dto;

import java.io.Serializable;

/**
 * 고객 DTO
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 * @since 2012. 8. 22.
 */
public class CustomerDto implements Serializable {

    /** UID */
    private static final long serialVersionUID = 5499301690167211267L;

    /** 고객번호 */
    private Long customerNo;

    /** 고객명 */
    private String name;

    /** 이메일 */
    private String email;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * 기본 생성자
     */
    public CustomerDto() {
        // 아무 일도 하지 않음
    }

    /**
     * 생성자
     *
     * @param customerNo 고객번호
     */
    public CustomerDto(Long customerNo) {
        this.customerNo = customerNo;
    }

    // -------------------------------------------------------------------------
    // Getter and Setter
    // -------------------------------------------------------------------------

    /**
     * @return 고객번호
     */
    public Long getCustomerNo() {
        return customerNo;
    }

    /**
     * @param customerNo 고객번호
     */
    public void setCustomerNo(Long customerNo) {
        this.customerNo = customerNo;
    }

    /**
     * @return 고객명
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 고객명
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 이메일
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email 이메일
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
