package lesson9;

import java.sql.*;


public class ConnectToMySQL {
    public static Connection getConnection()throws SQLException,java.lang.ClassNotFoundException{
        String url="jdbc:mysql://219.246.90.88:3306/test";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String userName="lucas";
        String password="368611020Xyq....";
        Connection con= DriverManager.getConnection(url,userName,password);
        return con;
    }

    public static void main(String[] args) {
        try{

            Connection con=getConnection();
            Statement sql=con.createStatement();
            sql.execute("drop table if exists student");

            sql.execute("create table student(id int,name varchar(20),math int)");

            sql.execute("insert student values(1,'AAA','99')");
            sql.execute("insert student values(2,'BBB','77')");
            sql.execute("insert student values(3,'CCC','65')");

            String query="select * from student";
            ResultSet result=sql.executeQuery(query);
            System.out.println("student 表如下：");
            System.out.println("-------------------------------------------------------------");
            System.out.println("学号"+" "+"姓名"+" "+"数学成绩");
            System.out.println("-------------------------------------------------------------");
            int number;
            String name ;
            String math;
            while(result.next()){
                number=result.getInt("id");
                name=result.getString("name");
                math=result.getString("math");
                System.out.println(number+" "+name+" "+math);
            }
            sql.close();
            con.close();
        }catch (java.lang.ClassNotFoundException e){
            System.err.println("ClassNotFoundException:"+e.getMessage());
        }catch(SQLException ex){
            System.err.println("SQLException:"+ex.getMessage());
        }
    }
}

