package lesson2;


import java.util.Scanner;

import static java.lang.System.exit;

public class Matrix {
    private float[][] matrix;
    private int rows;
    private int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new float[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public float getElement(int row, int column) {
        return matrix[row][column];
    }

    public void setElement(int row, int column, float value) {
        matrix[row][column] = value;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int inputInt() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            System.out.println("Incorrect input");
            exit(0);
            return 0;
        }
    }

    public float[][] inputFloats(int row, int column) {
        Scanner scanner = new Scanner(System.in);
        float[][] matrix = new float[row][column];
        String[] str;
        str = scanner.nextLine().split(" ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                try {
                    matrix[i][j] = Float.parseFloat(str[i * column + j]);
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect input in row " + i + " column " + j);
                    exit(0);
                }
            }
        }
        return matrix;
    }

    public float inputFloat() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextFloat()) {
            return scanner.nextFloat();
        } else {
            System.out.println("Incorrect input");
            exit(0);
            return 0;
        }
    }

    public boolean isEqual(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRows() != matrix2.getRows() || matrix1.getColumns() != matrix2.getColumns()) {
            return false;
        }
        for (int i = 0; i < matrix1.getRows(); i++) {
            for (int j = 0; j < matrix1.getColumns(); j++) {
                if (matrix1.getElement(i, j) != matrix2.getElement(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String toString(Matrix matrix) {
        String str = "";
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                str += matrix.getElement(i, j) + " ";
            }
            str += "\n";
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println("Enter number of rows");
        int rows = inputInt();
        System.out.println("Enter number of columns");
        int columns = inputInt();
        Matrix matrix = new Matrix(rows, columns);
        System.out.println("Enter elements of matrix, separated by space, row by row, finish with Enter");
        matrix.matrix = matrix.inputFloats(rows, columns);
        System.out.println("Matrix:");
        System.out.println(matrix.toString(matrix));
        System.out.println("If you want to input another matrix, enter 1, else 0");
        switch (matrix.inputInt()) {
            case 1:
                System.out.println("Enter number of rows");
                rows = inputInt();
                System.out.println("Enter number of columns");
                columns = inputInt();
                Matrix matrix1 = new Matrix(rows, columns);
                System.out.println("Enter elements of matrix, separated by space, row by row, finish with Enter");
                matrix1.matrix = matrix1.inputFloats(rows, columns);
                System.out.println("Matrix:");
                System.out.println(matrix1.toString(matrix1));

                if (matrix.isEqual(matrix, matrix1)) {
                    System.out.println("Matrices are equal");
                    exit(0);
                } else {
                    System.out.println("Matrices are not equal");
                    exit(0);
                }
                break;
        }
    }
}