package lesson5;
/*
从文本文件中读取数据，通过第一行存储的行数和列数获取矩阵的行和列。
之后，从第二行开始读取矩阵的数据，数据之间以空格分隔。
同时，提供矩阵的加减乘运算。
另外，当两个矩阵不符合矩阵的运算规则时，抛出异常。
*/

import java.io.*;

public class Matrix {
    int Row = 0;
    int Col = 0;
    double[][] data;

    //构造函数
    public Matrix() {
        Row = 0;
        Col = 0;
        data = null;
    }

    /*public Matrix(String fileName){
        Matrix result=new Matrix()
    }*/
    public Matrix(int row, int col, double[][] data) {
        Row = row;
        Col = col;
        data = data;
    }

    public static void main(String[] args) throws Exception {
        Matrix first = new Matrix();
        first = first.read("src/lesson5/first.txt");
        Matrix second = new Matrix();
        second = second.read("src/lesson5/second.txt");
        Matrix third = new Matrix();
        third = third.read("src/lesson5/third.txt");
        Matrix fourth = new Matrix();
        fourth = fourth.read("src/lesson5/fourth.txt");
        Matrix result = new Matrix();
        result = result.add(first, second);
        result.write(result, "src/lesson5/result.txt");
        result = result.sub(first, second);
        result.write(result, "src/lesson5/result.txt");
        result = result.mul(first, third);
        result.write(result, "src/lesson5/result.txt");
        result = result.div(first, fourth);
        result.write(result, "src/lesson5/result.txt");
    }

    //读取行列
    public int getRow(String fileNameFrom) throws Exception {
        FileReader reader = new FileReader(fileNameFrom);
        BufferedReader br = new BufferedReader(reader);
        String[] ss = br.readLine().split("\\s+");
        Row = Integer.valueOf(ss[0]);
        return Row;
    }

    public int getCol(String fileNameFrom) throws Exception {
        FileReader reader = new FileReader(fileNameFrom);
        BufferedReader br = new BufferedReader(reader);
        String[] ss = br.readLine().split("\\s+");
        Col = Integer.valueOf(ss[1]);
        return Col;
    }

    //set行列
    public void setRow(int row) {
        Row = row;
    }

    public void setCol(int col) {
        Col = col;
    }

    //读取数据
    public Matrix read(String fileNameFrom) throws Exception {
        System.out.println("开始读取数据.......");
        Matrix result = new Matrix();
        //int[][] data;
        try {
            FileReader reader = new FileReader(fileNameFrom);
            BufferedReader br = new BufferedReader(reader);
            String[] ss = br.readLine().split("\\s+");
            result.Row = Integer.valueOf(ss[0]);
            result.Col = Integer.valueOf(ss[1]);
            System.out.println(result.Row + "行");
            System.out.println(result.Col + "列");
            String[] sss = null;
            result.data = new double[result.Row][result.Col];
            for (int i = 0; i < result.Row; i++) {
                sss = br.readLine().split("\\s+");
                for (int j = 0; j < result.Col; j++) {
                    result.data[i][j] = Double.valueOf(sss[j]);
                }
            }
            br.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //写出数据
    public void write(Matrix result, String fileNameTo) throws Exception {
        File file = new File(fileNameTo);
        FileWriter writer = new FileWriter(file);
        BufferedWriter br = new BufferedWriter(writer);
        int Row = result.Row;
        int Col = result.Col;
        double[][] data = result.data;
        br.write(Row + " " + Col);
        br.newLine();
        for (int i = 0; i < Row; i++) {
            String str = "";
            for (int j = 0; j < Col; j++) {
                str += data[i][j] + "\t";
            }
            br.write(str);
            br.newLine();
            br.flush();
        }
        System.out.println("结果已经存储。");
    }


    //加法运算
    public Matrix add(Matrix first, Matrix second) throws Exception {

        Matrix firstm = new Matrix();
        firstm = first;
        Matrix secondm = new Matrix();
        secondm = second;

        Matrix result = new Matrix();
        try {
            if (first.Row != second.Row || second.Col != second.Col)
                throw new Exception("不符合矩阵加法的运算规则！");
        } catch (Exception e) {
            e.getMessage();
        }
        result.Row = firstm.Row;
        result.Col = firstm.Col;
        result.data = new double[result.Row][result.Col];
        for (int i = 0; i < result.Row; i++) {
            for (int j = 0; j < result.Col; j++) {
                result.data[i][j] = firstm.data[i][j] + secondm.data[i][j];
            }
        }

        System.out.println("已经完成加法运算");
        return result;

    }

    //减法运算
    public Matrix sub(Matrix first, Matrix second) throws Exception {

        Matrix firstm = new Matrix();
        firstm = first;
        Matrix secondm = new Matrix();
        secondm = second;
        try {
            if (first.Row != second.Row || second.Col != second.Col)
                throw new Exception("不符合矩阵减法的运算规则！");
        } catch (Exception e) {
            e.getMessage();
        }

        Matrix result = new Matrix();
        result.Row = firstm.Row;
        result.Col = firstm.Col;
        result.data = new double[result.Row][result.Col];
        for (int i = 0; i < result.Row; i++) {
            for (int j = 0; j < result.Col; j++) {
                result.data[i][j] = firstm.data[i][j] - secondm.data[i][j];
            }
        }
        System.out.println("已经完成减法运算");
        return result;

    }

    //乘法运算
    public Matrix mul(Matrix first, Matrix second) throws Exception {

        Matrix firstm = new Matrix();
        firstm = first;
        Matrix secondm = new Matrix();
        secondm = second;
        Matrix result = new Matrix();

        try {
            if (firstm.Col != secondm.Row)
                throw new Exception("不符合矩阵乘法的运算规则！");
        } catch (Exception e) {
            e.getMessage();
        }

        result.Row = firstm.Row;
        result.Col = second.Col;
        result.data = new double[result.Row][result.Col];
        for (int i = 0; i < result.Row; i++) {
            for (int j = 0; j < result.Col; j++) {
                double sum = 0;
                for (int k = 0; k < result.Row; k++) {
                    sum += first.data[i][k] * second.data[k][j];
                }
                result.data[i][j] = sum;
                //System.out.println(sum);
            }
        }
        System.out.println("已经完成乘法运算");
        return result;
    }

    public Matrix div(Matrix first, Matrix second) throws Exception {
        Matrix firstm = new Matrix();
        firstm = first;
        Matrix secondm = new Matrix();
        secondm = second;
        Matrix result = new Matrix();
        try {
            if (first.Row != first.Col && second.Col != second.Col)
                throw new Exception("不是方阵,不符合矩阵除法的必要条件！");
        } catch (Exception e) {
            e.getMessage();
        }
        int a = firstm.Row;
        int b = secondm.Row;
        double[][] aim = new double[b][b];
        aim = secondm.data;
        double c = this.getMartrixResult(aim);
        try {
            if (c < 1e-6)
                throw new Exception("行列式的值为0,不符合矩阵除法的必要条件！");
        } catch (Exception e) {
            e.getMessage();
        }
        result.Row = firstm.Row;
        result.Col = firstm.Col;
        result.data = new double[result.Row][result.Col];
        result.data = this.getReverseMartrix(aim);
        result = this.mul(firstm, result);
        System.out.println("已经完成除法运算");
        return result;

    }

    public double getMartrixResult(double[][] data) {
        if (data.length == 2) {
            return data[0][0] * data[1][1] - data[0][1] * data[1][0];
        }
        double result = 0;
        int num = data.length;
        double[] nums = new double[num];
        for (int i = 0; i < data.length; i++) {
            if (i % 2 == 0) {
                nums[i] = data[0][i] * this.getMartrixResult(getConfactor(data, 1, i + 1));
            } else {
                nums[i] = -data[0][i] * this.getMartrixResult(getConfactor(data, 1, i + 1));
            }
        }
        for (int i = 0; i < data.length; i++) {
            result += nums[i];
        }
        return result;
    }

    public double[][] getConfactor(double[][] data, int h, int v) {
        int H = data.length;
        int V = data[0].length;
        double[][] newdata = new double[H - 1][V - 1];
        for (int i = 0; i < newdata.length; i++) {
            if (i < h - 1) {
                for (int j = 0; j < newdata[i].length; j++) {
                    if (j < v - 1) {
                        newdata[i][j] = data[i][j];
                    } else {
                        newdata[i][j] = data[i][j + 1];
                    }
                }
            } else {
                for (int j = 0; j < newdata[i].length; j++) {
                    if (j < v - 1) {
                        newdata[i][j] = data[i + 1][j];
                    } else {
                        newdata[i][j] = data[i + 1][j + 1];
                    }
                }
            }
        }
        return newdata;
    }

    public double[][] getReverseMartrix(double[][] data) {
        double[][] newdata = new double[data.length][data[0].length];
        double A = this.getMartrixResult(data);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if ((i + j) % 2 == 0) {
                    newdata[i][j] = this.getMartrixResult(this.getConfactor(data, i + 1, j + 1)) / A;
                } else {
                    newdata[i][j] = -this.getMartrixResult(this.getConfactor(data, i + 1, j + 1)) / A;
                }

            }
        }
        newdata = this.trans(newdata);
        return newdata;
    }

    public double[][] trans(double[][] newdata) {
        // TODO Auto-generated method stub
        double[][] newdata2 = new double[newdata[0].length][newdata.length];
        for (int i = 0; i < newdata.length; i++)
            for (int j = 0; j < newdata[0].length; j++) {
                newdata2[j][i] = newdata[i][j];
            }
        return newdata2;
    }
}


