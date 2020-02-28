package com.ge.exercise2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayQuadrantUtil<T> {
    private static final Logger logger = LogManager.getLogger(ArrayQuadrantUtil.class);

    private T[][] data;
    private int row;
    private int column;


    /**
     * Constructs the Util class to operate on the given data 
     * @param data to be operated on
     */
    public ArrayQuadrantUtil(T[][] data) {
        this.data = data;
        if(data == null)
        	return;
        this.row = data.length - 1;
        this.column = data[0].length - 1;
    }
    
    /**
     * Return all of the values in a specific row in order of appearance (left to right)
     * @param r row from which data will be given
     * @return the value from the given row in an array
     */
    @SuppressWarnings("unchecked")
	public T[] getRowValues(int r) {
    	if(data == null || r < 0 || r > this.row)
    		return null;
    	
    	Object temp[] = new Object[this.column + 1];
    	for(int i = 0; i <= this.column ; i ++)
    		temp[i] = data[r][i];
    	
    	return (T[]) temp;
    }

    /**
     * Return all of the values in a specific column in order of appearance (top to bottom)
     * @param c column from which data will be given
     * @return the value from the given column in an array
     */
    @SuppressWarnings("unchecked")
	public T[] getColumnValues(int c) {
    	if(data == null || c < 0 || c > this.column)
    		return null;
    	
    	Object temp[] = new Object[this.row + 1];
    	for(int i = 0; i <= this.row ; i ++)
    		temp[i] = data[i][c];
    	
    	return (T []) temp;
    }
    
    /**
     * Return all of the values in a specific quadrant in order of appearance (left to right, top to bottom)
     * 
     * @param r row of the index
     * @param c column of the index
     * @return the value from the quadrant of the given index in an array
     */
    @SuppressWarnings("unchecked")
	public T[] getQuadrantValues(int r, int c) {
    	if(data == null)
    		return null;
    	
    	int quadrant = findQuadrant(r, c);
    	
    	if(quadrant == -1)
    		return null;
    	int quadrantRow = ((row + 1) / 2);
    	int quadrantColumn = ((column + 1) / 2);
    	Object temp[] = new Object[quadrantRow * quadrantColumn];
    	
    	int quadrantRowOffset = 0;
    	int quadrantColumnOffset = 0;
    	
    	switch(quadrant)
    	{
    		case 1 : quadrantColumnOffset = (this.column / 2) + 1;
    			break;
    		case 3 : quadrantColumnOffset = (this.column / 2) + 1;
    		case 2 : quadrantRowOffset = (this.row / 2) + 1;
    	}
    	
    	for(int i = 0; i < quadrantRow; i ++)
    		for(int j = 0; j < quadrantColumn; j++)
    			temp[i * quadrantRow + j] = data[quadrantRowOffset + i][quadrantColumnOffset + j];
    	
        return (T []) temp;
    }

    /**
     * 
     * The value for quadrant in which the given
     * index with r & c lies will be returned.
     * Return value will be according to the given strategy. 
     * 
     *  0 | 1 
     * ---|---
     *  2 | 3 
     *  
     * @param r
     * @param c
     * @return
     */
	private int findQuadrant(int r, int c) {
		if(r >= 0 && r <= this.row / 2) {
			if(c >= 0 && c <= this.column / 2)
				return 0;
			else if (c > this.column / 2 && c <= this.column)
				return 2;
		} else if (r > this.row / 2 && r <= this.row ){
			if(c >= 0 && c <= this.column / 2)
				return 1;
			else if (c > this.column / 2 && c <= this.column)
				return 3;
		}
		
		return -1;
	}
}
