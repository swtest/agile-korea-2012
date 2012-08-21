/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.agilekorea2012.tdd.example01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Calculator 테스트케이스
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 * @since 2012. 8. 20.
 */
public class CalculatorTest {

    /**
     * 합 테스트
     */
    @Test
    public void testAdd() {
        double sum = Calculator.add(1.1d, 2.2d);
        assertEquals(3.3d, sum, 0.1);
    }

}
