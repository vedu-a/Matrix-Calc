package MatrixCalculator;

import java.util.*;
public class MatrixCalc {
    public static int[][] matrixAddition(int[][] matrixA, int[][] matrixB) {
        if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
            System.out.println("Matrices must be of the same size for addition.");
            return null;
        }
        int[][] sum = new int[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                sum[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return sum;
    }
    
    public static int[][] matrixSubtraction(int[][] matrixA, int[][] matrixB) {
        if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
            System.out.println("Matrices must be of the same size for subtraction.");
            return null;
        }

        int[][] difference = new int[matrixA.length][matrixA[0].length];

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                difference[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }

        return difference;
    }

    public static int[][] matrixMultiplication(int[][] matrixA, int[][] matrixB) {
        if (matrixA[0].length != matrixB.length) {
            System.out.println("Number of columns in the first matrix must be equal to the number of rows in the second matrix for multiplication.");
            return null;
        }
        int[][] product = new int[matrixA.length][matrixB[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                for (int k = 0; k < matrixB.length; k++) {
                    product[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return product;
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int[][] transpose = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    public static int[][] rowReduction(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int lead = 0;

        int[][] reducedMatrix = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            reducedMatrix[i] = Arrays.copyOf(matrix[i], numCols);
        }

        for (int r = 0; r < numRows; r++) {
            if (lead >= numCols)
                break;

            int i = r;
            while (reducedMatrix[i][lead] == 0) {
                i++;
                if (i == numRows) {
                    i = r;
                    lead++;
                    if (lead == numCols)
                        return reducedMatrix;
                }
            }

            int[] temp = reducedMatrix[i];
            reducedMatrix[i] = reducedMatrix[r];
            reducedMatrix[r] = temp;

            int val = reducedMatrix[r][lead];
            for (int j = 0; j < numCols; j++)
                reducedMatrix[r][j] /= val;

            for (i = 0; i < numRows; i++) {
                if (i != r) {
                    val = reducedMatrix[i][lead];
                    for (int j = 0; j < numCols; j++)
                        reducedMatrix[i][j] -= val * reducedMatrix[r][j];
                }
            }
            lead++;
        }

        return reducedMatrix;
    }

    public static int determinant(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        if (numRows != numCols) {
            System.out.println("Determinant can only be calculated for square matrices.");
            return 0;
        }

        if (numRows == 1) {
            return matrix[0][0];
        } else if (numRows == 2) {
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        } else {
            int det = 0;
            for (int i = 0; i < numRows; i++) {
                int sign = (i % 2 == 0) ? 1 : -1;
                int[][] subMatrix = new int[numRows - 1][numCols - 1];
                int subi = 0;
                for (int row = 1; row < numRows; row++) {
                    int subj = 0;
                    for (int col = 0; col < numCols; col++) {
                        if (col != i) {
                            subMatrix[subi][subj] = matrix[row][col];
                            subj++;
                        }
                    }
                    subi++;
                }
                det += sign * matrix[0][i] * determinant(subMatrix);
            }
            return det;
        }
    }
}
