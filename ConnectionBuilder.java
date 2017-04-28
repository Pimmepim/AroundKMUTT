/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionBuilder {
    public static Connection connectionDB(){
        Connection conn=null;
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Driver loaded and registered");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
                   System.out.println("Derby Connection created");
        }catch(Exception e){
            System.out.println(e);
        }
        return conn;
    }
}
