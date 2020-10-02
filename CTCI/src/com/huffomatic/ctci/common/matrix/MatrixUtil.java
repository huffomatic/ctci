package com.huffomatic.ctci.common.matrix;

public class MatrixUtil {
	private MatrixUtil() {
	}
	
	public static boolean compareMatrices(int[][] matrix1, int[][] matrix2) {
		if (matrix1.length != matrix2.length) {
			return false;
		}
		else if (matrix1.length == 0) {
			return false;
		}
		else if (matrix1[0].length != matrix2[0].length) {
			return false;
		}
		
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[0].length; j++) {
				if (matrix1[i][j] != matrix2[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
}
