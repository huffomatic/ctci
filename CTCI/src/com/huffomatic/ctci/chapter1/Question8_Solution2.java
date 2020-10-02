package com.huffomatic.ctci.chapter1;

import org.junit.Assert;

import com.huffomatic.ctci.common.matrix.MatrixUtil;

/**
 * Zero Matrx: If an element in a M x N matrix is zero, then set that row and column to 0.
 * 
 * Input:  1  2  3  4
 *         5  0  7  8
 *         9 10 11  0   
 * Output: 1  0  3  0
 *         0  0  0  0
 *         0  0  0  0
 *         
 * Input:   0  2  3  4
 *          5  6  7  8
 *          0 10 11  0
 *         13 14 15 16
 * Output:  0  0  0  0
 *          0  6  7  0
 *          0  0  0  0
 *          0 14  15 0
 * 
 *        
 * Time:  O(m x n)
 * Space: O(1)
 * 
 * @author huffomatic
 *
 */
public class Question8_Solution2 {
	public static void main(String[] argv) {
		int[][] matrix3by4 = new int[3][4];
		matrix3by4[0][0] = 1;
		matrix3by4[0][1] = 2;
		matrix3by4[0][2] = 3;
		matrix3by4[0][3] = 4;
		matrix3by4[1][0] = 5;
		matrix3by4[1][1] = 0;
		matrix3by4[1][2] = 7;
		matrix3by4[1][3] = 8;
		matrix3by4[2][0] = 9;
		matrix3by4[2][1] = 10;
		matrix3by4[2][2] = 11;
		matrix3by4[1][3] = 0;
		
		int[][] zeroedMatrix3by4 = new int[3][4];
		zeroedMatrix3by4[0][0] = 1;
		zeroedMatrix3by4[0][1] = 0;
		zeroedMatrix3by4[0][2] = 3;
		zeroedMatrix3by4[0][3] = 0;
		zeroedMatrix3by4[1][0] = 0;
		zeroedMatrix3by4[1][1] = 0;
		zeroedMatrix3by4[1][2] = 0;
		zeroedMatrix3by4[1][3] = 0;
		zeroedMatrix3by4[2][0] = 0;
		zeroedMatrix3by4[2][1] = 0;
		zeroedMatrix3by4[2][2] = 0;
		zeroedMatrix3by4[1][3] = 0;
		
		Assert.assertTrue(MatrixUtil.compareMatrices(zeroMatrix(matrix3by4), zeroedMatrix3by4));
		
		int[][] matrix4by4 = new int[4][4];
		matrix4by4[0][0] = 0;
		matrix4by4[0][1] = 2;
		matrix4by4[0][2] = 3;
		matrix4by4[0][3] = 4;
		matrix4by4[1][0] = 5;
		matrix4by4[1][1] = 6;
		matrix4by4[1][2] = 7;
		matrix4by4[1][3] = 8;
		matrix4by4[2][0] = 0;
		matrix4by4[2][1] = 10;
		matrix4by4[2][2] = 11;
		matrix4by4[2][3] = 0;
		matrix4by4[3][0] = 13;
		matrix4by4[3][1] = 14;
		matrix4by4[3][2] = 15;
		matrix4by4[3][3] = 16;
		
		int[][] zeroedMatrix4by4 = new int[4][4];
		zeroedMatrix4by4[0][0] = 0;
		zeroedMatrix4by4[0][1] = 0;
		zeroedMatrix4by4[0][2] = 0;
		zeroedMatrix4by4[0][3] = 0;
		zeroedMatrix4by4[1][0] = 0;
		zeroedMatrix4by4[1][1] = 6;
		zeroedMatrix4by4[1][2] = 7;
		zeroedMatrix4by4[1][3] = 0;
		zeroedMatrix4by4[2][0] = 0;
		zeroedMatrix4by4[2][1] = 0;
		zeroedMatrix4by4[2][2] = 0;
		zeroedMatrix4by4[2][3] = 0;
		zeroedMatrix4by4[3][0] = 0;
		zeroedMatrix4by4[3][1] = 14;
		zeroedMatrix4by4[3][2] = 15;
		zeroedMatrix4by4[3][3] = 0;
		
		Assert.assertTrue(MatrixUtil.compareMatrices(zeroMatrix(matrix4by4), zeroedMatrix4by4));
		
		int[][] matrix1by4 = new int[1][4];
		matrix1by4[0][0] = 0;
		matrix1by4[0][1] = 2;
		matrix1by4[0][2] = 3;
		matrix1by4[0][3] = 4;
		
		int[][] zeroedMatrix1by4 = new int[1][4];
		zeroedMatrix1by4[0][0] = 0;
		zeroedMatrix1by4[0][1] = 0;
		zeroedMatrix1by4[0][2] = 0;
		zeroedMatrix1by4[0][3] = 0;
		
		Assert.assertTrue(MatrixUtil.compareMatrices(zeroMatrix(matrix1by4), zeroedMatrix1by4));
		
		int[][] matrix4by1 = new int[4][1];
		matrix4by1[0][0] = 0;
		matrix4by1[1][0] = 2;
		matrix4by1[2][0] = 3;
		matrix4by1[3][0] = 4;
		
		int[][] zeroedMatrix4by1 = new int[4][1];
		zeroedMatrix4by1[0][0] = 0;
		zeroedMatrix4by1[1][0] = 0;
		zeroedMatrix4by1[2][0] = 0;
		zeroedMatrix4by1[3][0] = 0;
		
		Assert.assertTrue(MatrixUtil.compareMatrices(zeroMatrix(matrix4by1), zeroedMatrix4by1));
	}
	
	public static int[][] zeroMatrix(int[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		
		// Instead of using two separate arrays to hold the zero flags, we can use the first row and first column.
		// First, let's see if any 0s exist in the first row.
		boolean firstRow = false;
		for (int j = 0; j < columns; j++) {
			if (matrix[0][j] == 0) {
				firstRow = true;
				break;
			}
		}
		
		// Second, let's see if any 0s exist in the first column.
		boolean firstColumn = false;
		for (int i = 0; i < rows; i++) {
			if (matrix[i][0] == 0) {
				firstColumn = true;
				break;
			}
		}
		
		// Next, we can look at rows 1 to m and columns 1 to n.
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < columns; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		// Nullify rows 1 to m.
		for (int i = 1; i < rows; i++) {
			if (matrix[i][0] == 0) {
				nullifyRow(matrix, i);
			}
		}
		
		// Nullify columns 1 to n.
		for (int j = 1; j < columns; j++) {
			if (matrix[0][j] == 0) {
				nullifyColumn(matrix, j);
			}
		}
		
		// Nullify first row.
		if (firstRow) {
			nullifyRow(matrix, 0);
		}
		
		// Nullify first column.
		if (firstColumn) {
			nullifyColumn(matrix, 0);
		}
		
		return matrix;
	}
	
	private static void nullifyRow(int[][] matrix, int row) {
		for (int column = 0; column < matrix[0].length; column++) {
			matrix[row][column] = 0;
		}
	}
	
	private static void nullifyColumn(int[][] matrix, int column) {
		for (int row = 0; row < matrix.length; row++) {
			matrix[row][column] = 0;
		}
	}
}
