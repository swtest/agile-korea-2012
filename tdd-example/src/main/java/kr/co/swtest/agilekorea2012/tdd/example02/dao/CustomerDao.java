/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example02.dao;

import kr.co.swtest.agilekorea2012.tdd.example02.dto.CustomerDto;

/**
 * °í°´ DAO
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">ÃÖ¿µ¸ñ</a>
 * @since 2012. 8. 22.
 */
public interface CustomerDao {

    /**
     * °í°´ Ãß°¡
     *
     * @param customer °í°´
     * @return °í°´¹øÈ£. <code>not null</code> º¸Àå.
     */
    Long createCustomer(CustomerDto customer);

    /**
     * °í°´ Á¶È¸
     *
     * @param customerNo °í°´¹øÈ£
     * @return °í°´. ¾øÀ¸¸é <code>null</code>À» ¸®ÅÏÇÔ.
     */
    CustomerDto readCustomerByNo(Long customerNo);

    /**
     * °í°´ ¼öÁ¤
     *
     * @param customer °í°´
     */
    void updateCustomer(CustomerDto customer);

    /**
     * °í°´ »èÁ¦
     *
     * @param customerNo °í°´¹øÈ£
     */
    void deleteCustomerByNo(Long customerNo);

}
