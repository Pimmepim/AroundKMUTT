/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;
import java.awt.*;
import javax.swing.*;

public class GUILogin {
    private JFrame jfLogin;
    private JTextField jtfUName;
    private JTextField jtfPassword;
    private JButton jbtOk;
    private JButton jbtCencel;
    

    public GUILogin() {
    }

    public GUILogin(JFrame jfLogin, JTextField jtfUName, JTextField jtfPassword, JButton jbtOk, JButton jbtCencel) {
        this.jfLogin = jfLogin;
        this.jtfUName = jtfUName;
        this.jtfPassword = jtfPassword;
        this.jbtOk = jbtOk;
        this.jbtCencel = jbtCencel;
    }

    public JFrame getJfLogin() {
        return jfLogin;
    }

    public JTextField getJtfUName() {
        return jtfUName;
    }

    public JTextField getJtfPassword() {
        return jtfPassword;
    }

    public JButton getJbtOk() {
        return jbtOk;
    }

    public JButton getJbtCencel() {
        return jbtCencel;
    }
    
    public GUILogin(String userN , String passw){
        jfLogin = new JFrame("Login");
 
        jtfUName = new JTextField(userN); 
        jtfPassword = new JTextField(passw);
        jbtOk =new JButton("OK");
        jbtCencel =new JButton("Cencel");
     
    }
    
    
}
