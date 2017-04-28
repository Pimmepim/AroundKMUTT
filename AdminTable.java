/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PiMS
 */
public class AdminTable {
    private String username;
    private String password;
    private int idAdmin;

    public AdminTable() {
    }

    public AdminTable(String username, String password, int idAdmin) {
        this.username = username;
        this.password = password;
        this.idAdmin = idAdmin;
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

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
    
    public static void getDataFromDB(ResultSet rs,AdminTable at) throws Exception{
        at.setUsername(rs.getString("USERNAME"));
        at.setPassword(rs.getString("PASSWORD"));
        at.setIdAdmin(rs.getInt("IDADMIN"));
    }
    public static ArrayList<AdminTable>AdminTableList(){
        ArrayList<AdminTable> AdminTableList = null;
        Statement st;
        
        try{
            String sql = "SELECT * FROM ADMIN";
            Connection c = ConnectionBuilder.connectionDB();
            st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                AdminTable at = new AdminTable();
                if(AdminTableList == null){
                    AdminTableList = new ArrayList<>();
                }
                getDataFromDB(rs , at);
                AdminTableList.add(at);
            }
            c.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return AdminTableList;
    }
}
