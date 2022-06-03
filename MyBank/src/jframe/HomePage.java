/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author RAVI PANCHAL
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    public HomePage() {
        initComponents();
        showData();
        showHistory();
    }
    public void showData()
    {
        String acc = SignupPage.acc;
        try
        {
            Connection con = Dbconnection.getConnection();
            String sql = "select * from bank2 where no = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,acc);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                String name = rs.getString(2);
                String accno = rs.getString(1);
                String bal = rs.getString(3);
                
                txt_showuser.setText(name);
                txt_shownum.setText(accno);
                txt_showbal.setText(bal);
                
                //JOptionPane.showMessageDialog(this,name);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    //show transaction history
    public void showHistory()
    {
        jScrollPane1.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        String acc = SignupPage.acc;
        try
        {
            Connection con = Dbconnection.getConnection();
            String sql = "select * from bank_tran where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,acc);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                String t_id = rs.getString(2);
                String amt = rs.getString(3);
                String type = rs.getString(4);
                String t_type = rs.getString(5);
                
                //txt_showuser.setText(name);
                
                Object[] obj = {t_id,t_type,amt,type};
                
                DefaultTableModel model = (DefaultTableModel) tran_table.getModel();
                model.addRow(obj);
                //JOptionPane.showMessageDialog(this,name);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tran_table = new rojeru_san.complementos.RSTableMetro();
        jLabel1 = new javax.swing.JLabel();
        txt_showuser = new javax.swing.JLabel();
        txt_shownum = new javax.swing.JLabel();
        txt_showbal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        deposit = new javax.swing.JLabel();
        withdraw = new javax.swing.JLabel();
        neft = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        txt_changepwd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/MyBankicon/Dashboard.png"))); // NOI18N
        rSPanelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(new javax.swing.border.MatteBorder(null));

        tran_table.setBorder(new javax.swing.border.MatteBorder(null));
        tran_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "From/To", "Tran. Type", "Amount", "type"
            }
        ));
        tran_table.setColorBackgoundHead(new java.awt.Color(153, 204, 0));
        tran_table.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tran_table.setColorBordeHead(new java.awt.Color(153, 204, 0));
        tran_table.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tran_table.setFocusable(false);
        tran_table.setGridColor(new java.awt.Color(255, 255, 255));
        tran_table.setRequestFocusEnabled(false);
        tran_table.setRowHeight(25);
        jScrollPane1.setViewportView(tran_table);

        rSPanelImage1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 830, 300));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jLabel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jLabel1PropertyChange(evt);
            }
        });
        rSPanelImage1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, -10, 50, 60));

        txt_showuser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rSPanelImage1.add(txt_showuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 190, 30));

        txt_shownum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rSPanelImage1.add(txt_shownum, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 190, 30));

        txt_showbal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rSPanelImage1.add(txt_showbal, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 190, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("My Profile");
        rSPanelImage1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 170, 30));

        deposit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deposit.setForeground(new java.awt.Color(255, 255, 255));
        deposit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deposit.setText("Deposit");
        deposit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                depositMouseClicked(evt);
            }
        });
        rSPanelImage1.add(deposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 180, 30));

        withdraw.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        withdraw.setForeground(new java.awt.Color(255, 255, 255));
        withdraw.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        withdraw.setText("Withdraw");
        withdraw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                withdrawMouseClicked(evt);
            }
        });
        rSPanelImage1.add(withdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 180, 30));

        neft.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        neft.setForeground(new java.awt.Color(255, 255, 255));
        neft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        neft.setText("NEFT");
        neft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                neftMouseClicked(evt);
            }
        });
        rSPanelImage1.add(neft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 180, 30));

        logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setText("LOG OUT");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        rSPanelImage1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 550, 140, 40));

        txt_changepwd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_changepwd.setForeground(new java.awt.Color(255, 255, 255));
        txt_changepwd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_changepwd.setText("Change Password");
        txt_changepwd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_changepwdMouseClicked(evt);
            }
        });
        rSPanelImage1.add(txt_changepwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 137, 170, 34));

        getContentPane().add(rSPanelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 650));

        setSize(new java.awt.Dimension(1200, 650));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void depositMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_depositMouseClicked
        // TODO add your handling code here:
        Deposit d = new Deposit();
        d.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_depositMouseClicked

    private void withdrawMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_withdrawMouseClicked
        // TODO add your handling code here:
        Withdraw w = new Withdraw();
        w.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_withdrawMouseClicked

    private void neftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_neftMouseClicked
        // TODO add your handling code here:
        Neft n = new Neft();
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_neftMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        SignupPage s = new SignupPage();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void jLabel1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabel1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1PropertyChange

    private void txt_changepwdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_changepwdMouseClicked
        // TODO add your handling code here:
        Changepwd pwd = new Changepwd();
        pwd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txt_changepwdMouseClicked

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel deposit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel neft;
    private rojerusan.RSPanelImage rSPanelImage1;
    private rojeru_san.complementos.RSTableMetro tran_table;
    private javax.swing.JLabel txt_changepwd;
    private javax.swing.JLabel txt_showbal;
    private javax.swing.JLabel txt_shownum;
    private javax.swing.JLabel txt_showuser;
    private javax.swing.JLabel withdraw;
    // End of variables declaration//GEN-END:variables
}
