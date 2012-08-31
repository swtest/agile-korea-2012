/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.dto;

import java.io.Serializable;

/**
 * ∞Ì∞¥ DTO
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">√÷øµ∏Ò</a>
 * @since 2012. 8. 22.
 */
public class CustomerDto implements Serializable {

    /** UID */
    private static final long serialVersionUID = 5499301690167211267L;

    /** ∞Ì∞¥π¯»£ */
    private Long customerNo;

    /** ∞Ì∞¥∏Ì */
    private String name;

    /** ¿Ã∏ﬁ¿œ */
    private String email;

    // -------------------------------------------------------------------------
    // Getter and Setter
    // -------------------------------------------------------------------------

    /**
     * @return ∞Ì∞¥π¯»£
     */
    public Long getCustomerNo() {
        return customerNo;
    }

    /**
     * @param customerNo ∞Ì∞¥π¯»£
     */
    public void setCustomerNo(Long customerNo) {
        this.customerNo = customerNo;
    }

    /**
     * @return ∞Ì∞¥∏Ì
     */
    public String getName() {
        return name;
    }

    /**
     * @param name ∞Ì∞¥∏Ì
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return ¿Ã∏ﬁ¿œ
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email ¿Ã∏ﬁ¿œ
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
