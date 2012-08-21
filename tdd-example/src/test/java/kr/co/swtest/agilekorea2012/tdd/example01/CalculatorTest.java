/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Calculator �׽�Ʈ���̽�
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 8. 20.
 */
public class CalculatorTest {

    /**
     * �� �׽�Ʈ
     */
    @Test
    public void testAdd() {
        double sum = Calculator.add(1.1d, 2.2d);
        assertEquals(3.3d, sum, 0.1);
    }

}
