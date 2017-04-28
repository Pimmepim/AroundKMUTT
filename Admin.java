/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.sql.*;
import java.util.Scanner;
public class Admin {

    private static String username;
    private static String password;
    private static int id;

    public Admin() {
    }

    public Admin(String username, String password,int id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static boolean login(String user, String pass) {

        Admin a = new Admin();

        boolean result = false;

        Connection con;

        try {
            con = ConnectionBuilder.connectionDB();
            String sql = "select * from ADMIN WHERE lower(USERNAME) = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.toLowerCase());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                a.setUsername(rs.getString("USERNAME"));
                a.setPassword(rs.getString("PASSWORD"));
                System.out.println(a.getUsername());
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            

        if (user.equalsIgnoreCase(a.getUsername()) && a.getPassword().equals(pass)) {
            System.out.println("Login Complete");
            result = true;
        } else {
            System.out.println("Password incorrect");
        }

        return result;
    }
    public static void editData(String user ,String pass,int id ) throws SQLDataException{//edit
       Connection con;
       PreparedStatement ps;
        try{
             String sql = "UPDATE ADMIN SET USERNAME=?, PASSWORD=? WHERE IDADMIN=?";
             con = ConnectionBuilder.connectionDB();

            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setInt(3, id);
            
            int query = ps.executeUpdate();
        }
        catch(Exception e){
            System.err.println(e.getMessage()); 
        }
    }
        
        
    
    
    public static void insertAdmin(String user, String pass) throws SQLException {//add
        Connection con;
        con = ConnectionBuilder.connectionDB();
        String sql1 = "select * from Admin"; 
        Statement ps = con.createStatement();
        ResultSet rs = ps.executeQuery(sql1);
                                             
        int count = 0; 
        while (rs.next()) {
            count++;        
        }
        int id = count + 1; 

        String sql2 = "insert into Admin values ('" + user + "','" + pass + "'," + id + ")";
        int s = ps.executeUpdate(sql2); 

    }
    public static void deleteData(int id) throws SQLException{
        Connection con;//ประกาศobject connection con
        try{
        con = ConnectionBuilder.connectionDB();
        //เชื่อต่อดาต้าเบสจากคลาสconnectBuilder
        String sql2 = "DELETE FROM ADMIN WHERE IDADMIN = ?";
        //ใช้คำสั่งsql delete โดยเลือกจากตาราง IDADMIN
        PreparedStatement ps = con.prepareStatement(sql2);
        //เตรียมข้อมูลเพื่อรออัพเดท
        ps.setInt(1,id);
        int rs = ps.executeUpdate();
        //อัพเดทข้อมูลหลังจากdelete
        }
        
        catch(SQLException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws SQLException {
        Admin a1 = new Admin();

        Scanner sc = new Scanner(System.in);
        System.out.print("ID :");
        String u = sc.nextLine();
        System.out.print("PW :");
        String p = sc.nextLine();

        //System.out.println(Admin.login(u, p));

        //Admin.upddateAdmin(u, p);
       // Admin.editData(u, p);
            
        

    }
}
