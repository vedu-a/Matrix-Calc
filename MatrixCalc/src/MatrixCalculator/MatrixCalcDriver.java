package MatrixCalculator;

import java.util.*;

import static MatrixCalculator.MatrixCalc.*;

public class MatrixCalcDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix1 = null;
        int[][] matrix2 = null;

        boolean runAgain = true;
        while (runAgain) {
            //Getting Matrix Inputs
            System.out.print("Enter the number of rows for Matrix 1: ");
            int rows1 = scan.nextInt();
            System.out.print("Enter the number of columns for Matrix 1: ");
            int columns1 = scan.nextInt();
            matrix1 = new int[rows1][columns1];
            System.out.println("Enter elements for Matrix 1:");
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < columns1; j++) {
                    matrix1[i][j] = scan.nextInt();
                }
            }
            System.out.print("Enter the number of rows for Matrix 2: ");
            int rows2 = scan.nextInt();
            System.out.print("Enter the number of columns for Matrix 2: ");
            int columns2 = scan.nextInt();
            matrix2 = new int[rows2][columns2];
            System.out.println("Enter elements for Matrix 2:");
            for (int i = 0; i < rows2; i++) {
                for (int j = 0; j < columns2; j++) {
                    matrix2[i][j] = scan.nextInt();
                }
            }
            //Printing out Matrices
            System.out.println("Matrix 1:");
            for (int[] row : matrix1) {
                for (int element : row) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
            System.out.println("Matrix 2:");
            for (int[] row : matrix2) {
                for (int element : row) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
            boolean askAgain = true;
            while (askAgain) {
                System.out.println("Input matrices again? (y or n)");
                String cont = scan.next();
                if (cont.equalsIgnoreCase("y")) {
                    runAgain = true;
                    askAgain = false;
                } else if (cont.equalsIgnoreCase("n")) {
                    runAgain = false;
                    askAgain = false;
                } else {
                    System.out.println("invalid input, try again.");
                }
            }
        }
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("What function would you like to perform?\n(addition, subtraction, multiplication, " +
                    "transposition, rr (row reduction), determinant)");
            String func = scan.next();
            if (func.equalsIgnoreCase("addition")) {
                int[][] resultAddition = matrixAddition(matrix1, matrix2);
                System.out.println("\nMatrix Addition:");
                if (resultAddition != null) {
                    for (int[] row : resultAddition) {
                        for (int element : row) {
                            System.out.print(element + " ");
                        }
                        System.out.println();
                    }
                }
            } else if (func.equalsIgnoreCase("subtraction")) {
                int[][] resultSubtraction = matrixSubtraction(matrix1, matrix2);
                System.out.println("\nMatrix Subtraction:");
                if (resultSubtraction != null) {
                    for (int[] row : resultSubtraction) {
                        for (int element : row) {
                            System.out.print(element + " ");
                        }
                        System.out.println();
                    }
                }
            } else if (func.equalsIgnoreCase("multiplication")) {
                int[][] resultMultiplication = matrixMultiplication(matrix1, matrix2);
                System.out.println("\nMatrix Multiplication:");
                if (resultMultiplication != null) {
                    for (int[] row : resultMultiplication) {
                        for (int element : row) {
                            System.out.print(element + " ");
                        }
                        System.out.println();
                    }
                }
            } else if (func.equalsIgnoreCase("transposition")) {
                boolean tr = true;
                while (tr) {
                    System.out.println("Which matrix would you like the transpose of? (1 or 2)");
                    int transp = scan.nextInt();
                    if (transp == 1) {
                        int[][] resultTranspose = transposeMatrix(matrix1);
                        System.out.println("\nTranspose of Matrix 1:");
                        for (int[] row : resultTranspose) {
                            for (int element : row) {
                                System.out.print(element + " ");
                            }
                            System.out.println();
                        }
                        tr = false;
                    } else if (transp == 2) {
                        int[][] resultTranspose = transposeMatrix(matrix2);
                        System.out.println("\nTranspose of Matrix 2:");
                        for (int[] row : resultTranspose) {
                            for (int element : row) {
                                System.out.print(element + " ");
                            }
                            System.out.println();
                        }
                        tr = false;
                    } else {
                        System.out.println("Invalid input, try again.");
                    }
                }
            } else if (func.equalsIgnoreCase("rr")) {
                boolean rrb = true;
                while (rrb) {
                    System.out.println("Which matrix would you like to reduce? (1 or 2)");
                    int rrMatrix = scan.nextInt();
                    if (rrMatrix == 1) {
                        System.out.println("Performing Row Reduction (Gaussian Elimination) on Matrix 1:");
                        int[][] reducedMatrix1 = rowReduction(matrix1);
                        for (int[] row : reducedMatrix1) {
                            for (int element : row) {
                                System.out.print(element + " ");
                            }
                            System.out.println();
                        }
                        rrb = false;
                    } else if (rrMatrix == 2) {
                        System.out.println("Performing Row Reduction (Gaussian Elimination) on Matrix 2:");
                        int[][] reducedMatrix1 = rowReduction(matrix2);
                        for (int[] row : reducedMatrix1) {
                            for (int element : row) {
                                System.out.print(element + " ");
                            }
                            System.out.println();
                        }
                        rrb = false;
                    } else {
                        System.out.println("Invalid input, try again.");
                    }
                }
            } else if (func.equalsIgnoreCase("determinant")) {
                System.out.println("Which matrix's determinant would you like to calculate? (1 or 2)");
                int detOf = scan.nextInt();
                if (detOf == 1) {
                    System.out.println("\nDeterminant of Matrix 1: " + determinant(matrix1));
                } else if (detOf == 2) {
                    System.out.println("\nDeterminant of Matrix 2: " + determinant(matrix2));
                }
            } else {
                System.out.println("Invalid input, please try again.");
            }
            boolean finish = true;
            while (finish) {
                System.out.println("Would you like to perform another function? (y or n)");
                String anotherFunc = scan.next();
                if (anotherFunc.equalsIgnoreCase("y")) {
                    keepRunning = true;
                    finish = false;
                } else if (anotherFunc.equalsIgnoreCase("n")) {
                    keepRunning = false;
                    finish = false;
                } else {
                    System.out.println("invalid input, please try again.");
                    finish = true;
                }
            }
        }
        System.out.println("Finished, thank you for using my program\n-Vedansh Arya");
    }
}