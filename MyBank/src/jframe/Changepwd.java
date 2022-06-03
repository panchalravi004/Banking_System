/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author RAVI PANCHAL
 */
public class Changepwd extends javax.swing.JFrame {

    /**
     * Creates new form Deposit
     */
    public Changepwd() {
        initComponents();
    }
    public void change()
    {
        String acc = SignupPage.acc;
        int oldpwd = Integer.parseInt(txt_oldpwd.getText());
        int newpwd = Integer.parseInt(txt_newpwd.getText());
        try
        {
            Connection con = Dbconnection.getConnection();
            String sql = "select * from bank2 where no=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,acc);
            
            ResultSet rs = pst.executeQuery();
            rs.next();
            int o_pwd = rs.getInt(4);
            if(oldpwd==o_pwd)
            {
                if(oldpwd==newpwd)
                {
                    JOptionPane.showMessageDialog(this,"New Password is Same as old Password");
                }
                else
                {
                    String sql1 = "update bank2 set pwd=? where no = ?";
                    PreparedStatement pst1 = con.prepareStatement(sql1);
                    pst1.setInt(1,newpwd);
                    pst1.setString(2,acc);
                    int updateRowCount = pst1.executeUpdate();
                    if(updateRowCount > 0)
                    {
                        JOptionPane.showMessageDialog(this,"Password Has Been Changed");
                    }
                }
                
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Ols Passoword Is Incorrect");
            }
            //JOptionPane.showMessageDialog(this,new_bal);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public Boolean checkField()
    {
        String oldpwd = txt_oldpwd.getText();
        String newpwd = txt_newpwd.getText();
        if(oldpwd.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please Enter Old Password");
            return false;
        }
        if(newpwd.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please Enter New Password");
            return false;
        }
        else
        {
            return true;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelImage1 = new rojerusan.RSPanelImage();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_oldpwd = new app.bolivia.swing.JCTextField();
        txt_newpwd = new app.bolivia.swing.JCTextField();
        deposit = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/MyBankicon/Changepwd.png"))); // NOI18N
        rSPanelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Old Password");
        rSPanelImage1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 150, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("New Password");
        rSPanelImage1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 150, 50));

        txt_oldpwd.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 102, 0)));
        txt_oldpwd.setPlaceholder("Enter Your Old Password");
        rSPanelImage1.add(txt_oldpwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 250, 50));

        txt_newpwd.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 102, 0)));
        txt_newpwd.setPlaceholder("Enter Your New Password");
        rSPanelImage1.add(txt_newpwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 250, 50));

        deposit.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        deposit.setForeground(new java.awt.Color(255, 255, 255));
        deposit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deposit.setText("Change");
        deposit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                depositMouseClicked(evt);
            }
        });
        rSPanelImage1.add(deposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, 180, 36));

        back.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back.setText("Back");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        rSPanelImage1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 38, 100, 30));

        getContentPane().add(rSPanelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 650));

        setSize(new java.awt.Dimension(600, 650));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void depositMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_depositMouseClicked
        // TODO add your handling code here:
        if(checkField())
        {
            change();
        }    
    }//GEN-LAST:event_depositMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        HomePage h = new HomePage();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseClicked
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Changepwd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Changepwd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Changepwd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Changepwd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Changepwd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel deposit;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private rojerusan.RSPanelImage rSPanelImage1;
    private app.bolivia.swing.JCTextField txt_newpwd;
    private app.bolivia.swing.JCTextField txt_oldpwd;
    // End of variables declaration//GEN-END:variables
}
