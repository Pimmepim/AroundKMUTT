/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.*;

/**
 *
 * @author PiMS
 */
public class AdminTableGUI extends javax.swing.JFrame {
    private static String aId;
//    private Admin admin = new Admin();
    public AdminTableGUI() {
        initComponents();
        addToTable(AdminTable.AdminTableList());
        adminT.setAutoCreateRowSorter(true);
    }
    
    //เอาข้อมูลจากฐานข้อมูลมาแสดงในรูปแบบของตารางโดยใช้ ArrayList
  DefaultTableModel model = new DefaultTableModel();
    public void addToTable(ArrayList<AdminTable> at){       
        model.setColumnIdentifiers(new Object[]{"USERNAME","PASSWORD","IDADMIN"});
        Object[] row = new Object[3];
        if(at != null){
            for(int i = 0; i < at.size(); i++){
                row[0] = at.get(i).getUsername();
                row[1] = at.get(i).getPassword();
                row[2] = at.get(i).getIdAdmin();               
                model.addRow(row);
            }
        }
       adminT.setModel(model);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        adminT = new javax.swing.JTable();
        editB = new javax.swing.JButton();
        deleteB = new javax.swing.JButton();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        insB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        adminT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        adminT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adminTFocusGained(evt);
            }
        });
        adminT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(adminT);

        editB.setText("Edit");
        editB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBActionPerformed(evt);
            }
        });

        deleteB.setText("Delete");
        deleteB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBActionPerformed(evt);
            }
        });

        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });

        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });

        insB.setText("Insert");
        insB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insBActionPerformed(evt);
            }
        });

        jLabel1.setText("ID :");

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pass, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(insB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 248, Short.MAX_VALUE)
                                .addComponent(editB, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(id)
                                .addGap(26, 26, 26)
                                .addComponent(deleteB)))
                        .addGap(1, 1, 1)))
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(insB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(editB)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteB)
                    .addComponent(jLabel1)
                    .addComponent(id))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActioninsertBd(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    //Delete
    private void deleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBActionPerformed
        int index = adminT.getSelectedRow();//คืนค่าข้อมูลในตารางออกมาเป็นตัวแปลประเภทInt
         DefaultTableModel model = (DefaultTableModel) adminT.getModel();
         //เรียกตารางที่เชื่อต่กับดาต้าเบสออกมาแสดง
         String username = (String) model.getValueAt(index, 0).toString();
         //ตั้งตัวแปลstring เพื่อรับชื่อผู้ใช้เข้ามาผ่านการคลิ๊กเลือกที่ตาราง
         String password = (String) model.getValueAt(index, 1).toString();
         //ตั้งตัวแปลstring เพื่อรับรหัสผู้ใช้เข้ามาผ่านการคลิ๊กเลือกที่ตาราง
         String aId = model.getValueAt(index, 2).toString();
         //ตั้งตัวแปลstring เพื่อรับIdผู้ใช้เข้ามาผ่านการคลิ๊กเลือกที่ตาราง
       
        
        adminT.setVisible(true);//ตั้งค่าให้มองเห็นตาราง
        user.setText(username);//รับชื่อusername ผ่าน text field
        pass.setText(password);//รับชื่อupassword ผ่าน text field
        id.setText(aId);//รับชื่อuid ผ่าน text field
         
        if(index < 0){ //ถ้า index น้อยกว่า0 แปลว่ายังไม่เลือกชื่อที่จะลบ
            JOptionPane.showMessageDialog(null, "Please select record for Deleting!");
            //ให้ขึ้นข้อความPlease select record for Deleting!
        }else{//ถ้าคลิกข้อมูล
            Object[] options = {"Yes", "No"};//สร้างอาเรย์ชื่อoption เพื่อเก็บข้อความyes,noไว้รอแสดง
            int n = JOptionPane.showOptionDialog(null, "Do you want to DELETE data?", 
             //ถ้าคลิ๊กเลือกข้อมูล ก็จะมีindexเข้ามา แปลว่าเลือกแล้วจะขึ้นข้อมูล Do you want to DELETE data?
             //Confirm to DELETE?แล้วขึ้น JOptionPane ให้กดเลือกyesเพื่อลบหรือnoเพื่อยกเลิก
           "Confirm to DELETE?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
            null, options, options[1]);
           
            if(n == 0){ //ถ้ากดyesเพื่อลบ
                try {
                    int id = Integer.parseInt(aId);
                    //แคสidจากstringให้เป็นint
                    Admin.deleteData(id);
                    //เรียกเมธอดdeleteจากคลาสAdmin
           
                    
                    this.setVisible(false);//ปิดตารางเก่าที่ไม่ได้อัพเดท
                    new AdminTableGUI().setVisible(true);
                    //เปิดตารางขึ้นมาใหม่เป็นตารางที่อัพเดทแล้ว
                } catch (Exception e) {
                   System.err.println(e.getMessage());
                }
            }
        }
       
        adminT.setVisible(false);
        this.setVisible(false);
        new AdminTableGUI().setVisible(true);
    }//GEN-LAST:event_deleteBActionPerformed

    //EditData
    private void editBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBActionPerformed
        int index = adminT.getSelectedRow();
         DefaultTableModel model = (DefaultTableModel) adminT.getModel();
         String username = user.getText();
         String password = pass.getText();
         String aId = id.getText();
   
        adminT.setVisible(true);
        user.setText(username);
        pass.setText(password);
        id.setText(aId);
        
       
         
        if(index < 0){ 
            JOptionPane.showMessageDialog(null, "Please select record for Deleting!");
        }else{
            Object[] options = {"Yes", "No"};
            int n = JOptionPane.showOptionDialog(null, "Do you want to EDIT data?", 
           "Confirm to EDIT?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
            null, options, options[1]);
            System.out.println("Confirm edit: "+n);
            
             
            if(n == 0){ //ถ้ากดyesเพื่อลบ
                try {
            Admin.editData(username, password,Integer.parseInt(aId));
             } catch (SQLException e) {
            System.err.println(e.getMessage());
             }
            }
        }
       
        adminT.setVisible(false);
        this.setVisible(false);
        new AdminTableGUI().setVisible(true);

        
      
    }//GEN-LAST:event_editBActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed
    //AddData
    private void insBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insBActionPerformed
        adminT.setVisible(false); 
        new AdminTableGUI().setVisible(true);
        
        int index = adminT.getSelectedRow();
         DefaultTableModel model = (DefaultTableModel) adminT.getModel();
         String username = user.getText();
         String password = pass.getText();
   
        adminT.setVisible(true);
        user.setText(username);
        pass.setText(password);
        id.setText(aId);
        
       
         
        if(index < 0){ 
            JOptionPane.showMessageDialog(null, "Please select record for Deleting!");
        }else{
            Object[] options = {"Yes", "No"};
            int n = JOptionPane.showOptionDialog(null, "Do you want to INSERT data?", 
           "Confirm to INSERT?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
            null, options, options[1]);
            System.out.println("Confirm edit: "+n);
            
             
            if(n == 0){ //ถ้ากดyesเพื่อลบ
                 try {
                Admin.insertAdmin(username,password); 
            
                } catch (SQLException e) {
                System.err.println(e.getMessage());
                }
            }
        }
       
        adminT.setVisible(false);
        this.setVisible(false);
        new AdminTableGUI().setVisible(true);
        
    }//GEN-LAST:event_insBActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void adminTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminTFocusGained
        
    }//GEN-LAST:event_adminTFocusGained

    
    
    
    
    //เมื่อคลิ๊กข้อมูลในตาราง ให้แสดงข้อมูลที่ Text Field 
    private void adminTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminTMouseClicked
         int index = adminT.getSelectedRow();
         DefaultTableModel model = (DefaultTableModel) adminT.getModel();
         String username = (String) model.getValueAt(index, 0).toString();
         String password = (String) model.getValueAt(index, 1).toString();
         String aId = model.getValueAt(index, 2).toString();
       
        
        adminT.setVisible(true);
        user.setText(username);
        pass.setText(password);
        id.setText(aId);
       
       
    }//GEN-LAST:event_adminTMouseClicked

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminTableGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminTableGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminTableGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminTableGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminTableGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable adminT;
    private javax.swing.JButton deleteB;
    private javax.swing.JButton editB;
    private javax.swing.JLabel id;
    private javax.swing.JButton insB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField pass;
    public static javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables

    
}
