package com.ge.exercise2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class ArrayQuadrantUtilTest {

	Character[][] characterData = {
            {'a', 'b', 'c', 'd'},
            {'e', 'f', 'g', 'h'},
            {'i', 'j', 'k', 'l'},
            {'m', 'n', 'o', 'p'}
    };
	
    Integer[][] integerData = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
    };

	
	@Test
	public void testNullDataForCharacter() {
		ArrayQuadrantUtil<Character> util = new ArrayQuadrantUtil<>(null);
        Assert.assertNull(util.getRowValues(0));
        Assert.assertNull(util.getColumnValues(0));
        Assert.assertNull(util.getQuadrantValues(0, 0));
	}
	
    @Test
    public void getRowValuesTestForCharacter() {

        ArrayQuadrantUtil<Character> util = new ArrayQuadrantUtil<>(characterData);
        Assume.assumeNotNull(util.getRowValues(0));

        Assert.assertNull(util.getRowValues(-1));
        Assert.assertNull(util.getRowValues(4));
        
        Character[] expectedResult = {'e', 'f', 'g', 'h'};
        assertArrayEquals(expectedResult, util.getRowValues(1));
    }

    @Test
    public void getColumnValuesTestForCharacter() {

        ArrayQuadrantUtil<Character> util = new ArrayQuadrantUtil<>(characterData);
        Assume.assumeNotNull(util.getColumnValues(0));

        Assert.assertNull(util.getColumnValues(-4));
        Assert.assertNull(util.getColumnValues(5));
        
        Character[] expectedResult = {'c', 'g', 'k', 'o'};
        assertArrayEquals(expectedResult, util.getColumnValues(2));
    }

    
    @Test
    public void getQuadrantValuesTestForCharacter() {

        ArrayQuadrantUtil<Character> util = new ArrayQuadrantUtil<>(characterData);
        Assume.assumeNotNull(util.getQuadrantValues(0, 0));

        Assert.assertNull(util.getQuadrantValues(-1, 0));
        Assert.assertNull(util.getQuadrantValues(0, 4));
        
        Character[] expectedResult1 = {'a', 'b', 'e', 'f'};
        assertArrayEquals(expectedResult1, util.getQuadrantValues(0, 0));
        
        Character[] expectedResult2 = {'k', 'l', 'o', 'p'};
        assertArrayEquals(expectedResult2, util.getQuadrantValues(3, 3));
    }
    	
	@Test
	public void testNullDataForInteger() {
		ArrayQuadrantUtil<Integer> util = new ArrayQuadrantUtil<>(null);
        Assert.assertNull(util.getRowValues(0));
        Assert.assertNull(util.getColumnValues(0));
        Assert.assertNull(util.getQuadrantValues(0, 0));
	}
	
    @Test
    public void getRowValuesTesForIntegert() {

        ArrayQuadrantUtil<Integer> util = new ArrayQuadrantUtil<>(integerData);
        Assume.assumeNotNull(util.getRowValues(0));

        Assert.assertNull(util.getRowValues(-1));
        Assert.assertNull(util.getRowValues(4));
        
        Integer[] expectedResult = {5, 6, 7, 8};
        assertArrayEquals(expectedResult, util.getRowValues(1));
    }

    @Test
    public void getColumnValuesTestForInteger() {

        ArrayQuadrantUtil<Integer> util = new ArrayQuadrantUtil<>(integerData);
        Assume.assumeNotNull(util.getColumnValues(0));

        Assert.assertNull(util.getColumnValues(-4));
        Assert.assertNull(util.getColumnValues(5));
        
        Integer[] expectedResult = {3, 7, 11, 15};
        assertArrayEquals(expectedResult, util.getColumnValues(2));
    }

    
    @Test
    public void getQuadrantValuesTestForInteger() {

        ArrayQuadrantUtil<Integer> util = new ArrayQuadrantUtil<>(integerData);
        Assume.assumeNotNull(util.getQuadrantValues(0, 0));

        Assert.assertNull(util.getQuadrantValues(-1, 0));
        Assert.assertNull(util.getQuadrantValues(0, 4));
        
        Integer[] expectedResult1 = {1, 2, 5, 6};
        assertArrayEquals(expectedResult1, util.getQuadrantValues(1, 1));
        
        Integer[] expectedResult2 = {11, 12, 15, 16};
        assertArrayEquals(expectedResult2, util.getQuadrantValues(2, 2));
    }
}