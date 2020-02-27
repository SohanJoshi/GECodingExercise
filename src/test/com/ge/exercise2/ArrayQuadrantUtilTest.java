package com.ge.exercise2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class ArrayQuadrantUtilTest {

	char[][] data = {
            {'a', 'b', 'c', 'd'},
            {'e', 'f', 'g', 'h'},
            {'i', 'j', 'k', 'l'},
            {'m', 'n', 'o', 'p'}
    };
	
	@Test
	public void testNullData() {
		ArrayQuadrantUtil util = new ArrayQuadrantUtil(null);
        Assert.assertNull(util.getRowValues(0));
        Assert.assertNull(util.getColumnValues(0));
        Assert.assertNull(util.getQuadrantValues(0, 0));
	}
	
    @Test
    public void getRowValuesTest() {

        ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);
        Assume.assumeNotNull(util.getRowValues(0));

        Assert.assertNull(util.getRowValues(-1));
        Assert.assertNull(util.getRowValues(4));
        
        char[] expectedResult = {'e', 'f', 'g', 'h'};
        assertArrayEquals(expectedResult, util.getRowValues(1));
    }

    @Test
    public void getColumnValuesTest() {

        ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);
        Assume.assumeNotNull(util.getColumnValues(0));

        Assert.assertNull(util.getColumnValues(-4));
        Assert.assertNull(util.getColumnValues(5));
        
        char[] expectedResult = {'c', 'g', 'k', 'o'};
        assertArrayEquals(expectedResult, util.getColumnValues(2));
    }

    
    @Test
    public void getQuadrantValuesTest() {

        ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);
        Assume.assumeNotNull(util.getQuadrantValues(0, 0));

        Assert.assertNull(util.getQuadrantValues(-1, 0));
        Assert.assertNull(util.getQuadrantValues(0, 4));
        
        char[] expectedResult1 = {'a', 'b', 'e', 'f'};
        assertArrayEquals(expectedResult1, util.getQuadrantValues(0, 0));
        
        char[] expectedResult2 = {'k', 'l', 'o', 'p'};
        assertArrayEquals(expectedResult2, util.getQuadrantValues(3, 3));
    }
}