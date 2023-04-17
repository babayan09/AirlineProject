

package airline.management.system;

import java.sql.*;  

public class conn{
    Connection c;
    Statement s;
    public conn(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c = DriverManager.getConnection("jdbc:mysql:///airline","root","root@23!");    
            s =c.createStatement(); 
           System.out.println("RUNNING");
         
            
        }catch(Exception e){ 
            System.out.println(e);
 System.out.println("NOT oK");
        }  
    }  
 public static void main(String[] args) {
       System.out.println("HELLO2");
       conn myob1= new conn();
    }
}  