package lesson9;

import java.sql.*;

/**
 * a typical crud program
 */
public class CRUD {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            String url = "jdbc:mysql://219.246.90.88:3306/test";
            String userName = "lucas";
            String password = "368611020Xyq....";
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement sql = con.createStatement();
            sql.execute("drop table if exists student");
            sql.execute("create table student(id int,name varchar(20),math int)");
            sql.execute("insert student values(1,'AAA','99')");
            sql.execute("insert student values(2,'BBB','77')");
            sql.execute("insert student values(3,'CCC','65')");
            String query = "select * from student";
            ResultSet result = sql.executeQuery(query);
            System.out.println("student 表如下：");
            System.out.println("-------------------------------------------------------------");
            System.out.println("学号" + " " + "姓名" + " " + "数学成绩");
            System.out.println("-------------------------------------------------------------");
            int number;
            String name;
            String math;
            while (result.next()) {
                number = result.getInt("id");
                name = result.getString("name");
                math = result.getString("math");
                System.out.println(number + " " + name + " " + math);
            }
            //delete
            sql.execute("delete from student where id=2");
            sql.execute("select * from student");
            result = sql.executeQuery(query);
            System.out.println("student 表如下：");
            System.out.println("-------------------------------------------------------------");
            System.out.println("学号" + " " + "姓名" + " " + "数学成绩");
            System.out.println("-------------------------------------------------------------");
            while (result.next()) {
                number = result.getInt("id");
                name = result.getString("name");
                math = result.getString("math");
                System.out.println(number + " " + name + " " + math);
            }
            //change
            sql.execute("update student set math=88 where id=1");
            sql.execute("select * from student");
            result = sql.executeQuery(query);
            System.out.println("student 表如下：");
            System.out.println("-------------------------------------------------------------");
            System.out.println("学号" + " " + "姓名" + " " + "数学成绩");
            System.out.println("-------------------------------------------------------------");
            while (result.next()) {
                number = result.getInt("id");
                name = result.getString("name");
                math = result.getString("math");
                System.out.println(number + " " + name + " " + math);
            }
            //insert
            sql.execute("insert student values(4,'DDD','66')");
            sql.execute("select * from student");
            result = sql.executeQuery(query);
            System.out.println("student 表如下：");
            System.out.println("-------------------------------------------------------------");
            System.out.println("学号" + " " + "姓名" + " " + "数学成绩");
            System.out.println("-------------------------------------------------------------");
            while (result.next()) {
                number = result.getInt("id");
                name = result.getString("name");
                math = result.getString("math");
                System.out.println(number + " " + name + " " + math);
            }
            sql.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}