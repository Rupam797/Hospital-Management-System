package hospital.management.system;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

public class Conn {

    Connection connection;
    Statement statement;


    public Conn(){

        try{
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system","root","12345");
            statement=connection.createStatement();
        }catch(Exception a){
            a.printStackTrace();
        }
    }
}

