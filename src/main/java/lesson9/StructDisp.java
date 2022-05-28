package lesson9;

import java.io.*;
import java.sql.*;

public class StructDisp {
    static String colLabel[];
    static int colCount;

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            String url="jdbc:mysql://219.246.90.88:3306/test";
            String userName="lucas";
            String password="368611020Xyq....";
            Connection con= DriverManager.getConnection(url,userName,password);
            Statement stm=con.createStatement();
            boolean status=stm.execute("select * from student");
            ResultSet rs=stm.getResultSet();
            showStruct(rs);
            showData(rs);
            stm.close();
        }catch(SQLException e){
            System.out.println(e.getSQLState());
        }catch (IOException e2){
            System.out.println(e2.getMessage());
        }
    }
    public static void showStruct(ResultSet rs)throws IOException,SQLException{
        ResultSetMetaData md=rs.getMetaData();
        colCount=md.getColumnCount();
        colLabel=new String[colCount+1];
        System.out.println("==================================================================");
        for(int i=1;i<=colCount;i++){
            colLabel[i]=md.getColumnLabel(i);
            System.out.printf(""+colLabel[i]+"\t");

        }
        System.out.println("\n==================================================================");

    }
    public static void showData(ResultSet rs)throws IOException,SQLException{
        if(rs!=null){
            while(rs.next()){
                System.out.print(""+rs.getString(colLabel[1]));
                System.out.print("\t"+rs.getString(colLabel[2]));
                System.out.println("\t"+rs.getString(colLabel[3]));

            }
        }
        System.out.println("===================================================================");
    }
}
