package com.huffomatic.ctci.chapter1;

import org.junit.Assert;

import com.huffomatic.ctci.common.matrix.MatrixUtil;

/**
 * Rotate a N x N matrix by 90 degrees
 * 
 * Time:  O(n^2)
 * Space: O(1) 
 * 
 * @author huffomatic
 *
 */
public class Question7 {
	public static void main(String[] argv) {
		int[][] matrix3by3 = new int[3][3];
		matrix3by3[0][0] = 1;
		matrix3by3[0][1] = 2;
		matrix3by3[0][2] = 3;
		matrix3by3[1][0] = 4;
		matrix3by3[1][1] = 5;
		matrix3by3[1][2] = 6;
		matrix3by3[2][0] = 7;
		matrix3by3[2][1] = 8;
		matrix3by3[2][2] = 9;
		
		int[][] rotatedMatrix3by3 = new int[3][3];
		rotatedMatrix3by3[0][0] = 7;
		rotatedMatrix3by3[0][1] = 4;
		rotatedMatrix3by3[0][2] = 1;
		rotatedMatrix3by3[1][0] = 8;
		rotatedMatrix3by3[1][1] = 5;
		rotatedMatrix3by3[1][2] = 2;
		rotatedMatrix3by3[2][0] = 9;
		rotatedMatrix3by3[2][1] = 6;
		rotatedMatrix3by3[2][2] = 3;
		
		Assert.assertTrue(MatrixUtil.compareMatrices(rotateMatrixBy90Degrees(matrix3by3), rotatedMatrix3by3));
		
		int[][] matrix4by4 = new int[4][4];
		matrix4by4[0][0] = 1;
		matrix4by4[0][1] = 2;
		matrix4by4[0][2] = 3;
		matrix4by4[0][3] = 4;
		matrix4by4[1][0] = 5;
		matrix4by4[1][1] = 6;
		matrix4by4[1][2] = 7;
		matrix4by4[1][3] = 8;
		matrix4by4[2][0] = 9;
		matrix4by4[2][1] = 10;
		matrix4by4[2][2] = 11;
		matrix4by4[2][3] = 12;
		matrix4by4[3][0] = 13;
		matrix4by4[3][1] = 14;
		matrix4by4[3][2] = 15;
		matrix4by4[3][3] = 16;
		
		//  1  2  3  4       1  5  9 13      13  9 5 1
		//  5  6  7  8  ---  2  6 10 14  --- 14 10 6 2
		//  9 10 11 12  ---  3  7 11 15  --- 15 11 7 3
		// 13 14 15 16       4  8 12 16      16 12 8 4
		int[][] rotatedMatrix4by4 = new int[4][4];
		rotatedMatrix4by4[0][0] = 13;
		rotatedMatrix4by4[0][1] = 9;
		rotatedMatrix4by4[0][2] = 5;
		rotatedMatrix4by4[0][3] = 1;
		rotatedMatrix4by4[1][0] = 14;
		rotatedMatrix4by4[1][1] = 10;
		rotatedMatrix4by4[1][2] = 6;
		rotatedMatrix4by4[1][3] = 2;
		rotatedMatrix4by4[2][0] = 15;
		rotatedMatrix4by4[2][1] = 11;
		rotatedMatrix4by4[2][2] = 7;
		rotatedMatrix4by4[2][3] = 3;
		rotatedMatrix4by4[3][0] = 16;
		rotatedMatrix4by4[3][1] = 12;
		rotatedMatrix4by4[3][2] = 8;
		rotatedMatrix4by4[3][3] = 4;
		
		Assert.assertTrue(MatrixUtil.compareMatrices(rotateMatrixBy90Degrees(matrix4by4), rotatedMatrix4by4));
	}
	
	public static int[][] rotateMatrixBy90Degrees(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		// Step #1: Transpose the rows with columns around the diagonal.
		for (int i = 0; i < rows; i++) {
			for (int j = i; j < cols; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		// Step #2: Reflect the columns around the center column.
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][cols - 1 - j];
				matrix[i][cols - 1 - j] = temp;
			}
		}
		
		return matrix;
	}
}
