/*
 * Created by JFormDesigner on Thu May 23 22:44:22 CST 2024
 */

package com.forms.share;

import javax.swing.border.*;
import com.database.operatetable.ReadTable;
import com.database.operatetable.UpdateTable;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Administrator
 */
public class forms_modify extends JFrame {
    public forms_modify() {
        initComponents();
    }

    private void al_cancellation(ActionEvent e) {
        System.out.println(e.getActionCommand());
        this.setVisible(false);
    }

    private void al_determine(ActionEvent e) {
        System.out.println(e.getActionCommand());
        //获得登录权限
        String table = ReadTable.ReadTemporary().get(2);
        //旧密码
        String passworded = ReadTable.ReadTemporary().get(1);
        //新密码
        String password = String.valueOf(wbk_password.getPassword());
        //确认密码
        String passwords = String.valueOf(wbk_passwords.getPassword());
        boolean nonull = true;
        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "密码不能为空！", "警告", JOptionPane.PLAIN_MESSAGE, null);
            nonull = false;
        }
        if (passwords.isEmpty()) {
            JOptionPane.showMessageDialog(null, "确认密码不能为空！", "警告", JOptionPane.PLAIN_MESSAGE, null);
            nonull = false;
        }
        if (nonull) {
            if (password.equals(passworded)) {
                JOptionPane.showMessageDialog(null, "新密码与旧密码相同！", "警告", JOptionPane.PLAIN_MESSAGE, null);
            } else {
                if (passwords.equals(password)) {
                    if (table.equals("2")){
                        UpdateTable.ModifyAdministrators(password);
                    }else if (table.equals("1")){
                        UpdateTable.ModifyStaff(password);
                    }else {
                        UpdateTable.ModifyCustom(password);
                    }
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "密码和确认密码不同！", "警告", JOptionPane.PLAIN_MESSAGE, null);
                }
            }
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        bq_account = new JLabel();
        bq_password = new JLabel();
        wbk_account = new JFormattedTextField();
        wbk_password = new JPasswordField();
        bq_passwords = new JLabel();
        wbk_passwords = new JPasswordField();
        al_cancellation = new JButton();
        al_determine = new JButton();
        bq_title = new JLabel();

        //======== this ========
        setTitle("\u5bc6\u7801");
        setResizable(false);
        setName("mod");
        setMaximumSize(null);
        setMinimumSize(null);
        setPreferredSize(new Dimension(300, 300));
        setIconImage(new ImageIcon(getClass().getResource("/com/picture/log.png")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- bq_account ----
        bq_account.setText("\u8d26\u6237");
        bq_account.setMinimumSize(null);
        bq_account.setMaximumSize(null);
        bq_account.setPreferredSize(new Dimension(40, 30));
        bq_account.setHorizontalAlignment(SwingConstants.RIGHT);
        bq_account.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(bq_account);
        bq_account.setBounds(20, 55, 60, 20);

        //---- bq_password ----
        bq_password.setText("\u65b0\u7684\u5bc6\u7801");
        bq_password.setMaximumSize(null);
        bq_password.setMinimumSize(null);
        bq_password.setPreferredSize(new Dimension(40, 30));
        bq_password.setHorizontalAlignment(SwingConstants.RIGHT);
        bq_password.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(bq_password);
        bq_password.setBounds(20, 105, 60, 20);

        //---- wbk_account ----
        wbk_account.setMinimumSize(null);
        wbk_account.setPreferredSize(new Dimension(150, 30));
        wbk_account.setMaximumSize(null);
        wbk_account.setEnabled(false);
        wbk_account.setBorder(LineBorder.createBlackLineBorder());
        contentPane.add(wbk_account);
        wbk_account.setBounds(90, 50, 150, 30);

        //---- wbk_password ----
        wbk_password.setPreferredSize(new Dimension(150, 30));
        wbk_password.setBorder(LineBorder.createBlackLineBorder());
        contentPane.add(wbk_password);
        wbk_password.setBounds(90, 100, 150, 30);

        //---- bq_passwords ----
        bq_passwords.setText("\u786e\u8ba4\u5bc6\u7801");
        bq_passwords.setMaximumSize(null);
        bq_passwords.setMinimumSize(null);
        bq_passwords.setPreferredSize(new Dimension(40, 30));
        bq_passwords.setHorizontalAlignment(SwingConstants.RIGHT);
        bq_passwords.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(bq_passwords);
        bq_passwords.setBounds(20, 150, 60, 20);

        //---- wbk_passwords ----
        wbk_passwords.setPreferredSize(new Dimension(150, 30));
        wbk_passwords.setBorder(LineBorder.createBlackLineBorder());
        contentPane.add(wbk_passwords);
        wbk_passwords.setBounds(90, 145, 150, 30);

        //---- al_cancellation ----
        al_cancellation.setText("\u53d6\u6d88");
        al_cancellation.setMaximumSize(null);
        al_cancellation.setMinimumSize(null);
        al_cancellation.setPreferredSize(new Dimension(60, 25));
        al_cancellation.setForeground(Color.blue);
        al_cancellation.setBackground(Color.white);
        al_cancellation.addActionListener(e -> al_cancellation(e));
        contentPane.add(al_cancellation);
        al_cancellation.setBounds(155, 195, 80, 40);

        //---- al_determine ----
        al_determine.setText("\u786e\u5b9a");
        al_determine.setPreferredSize(new Dimension(60, 25));
        al_determine.setForeground(Color.blue);
        al_determine.setBackground(Color.white);
        al_determine.addActionListener(e -> al_determine(e));
        contentPane.add(al_determine);
        al_determine.setBounds(50, 195, 80, 40);

        //---- bq_title ----
        bq_title.setText("\u4fee\u6539\u5bc6\u7801");
        bq_title.setFont(new Font("\u6977\u4f53", Font.BOLD, 24));
        contentPane.add(bq_title);
        bq_title.setBounds(new Rectangle(new Point(95, 10), bq_title.getPreferredSize()));

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        wbk_account.setText(ReadTable.ReadTemporary().get(0));
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel bq_account;
    private JLabel bq_password;
    private JFormattedTextField wbk_account;
    private JPasswordField wbk_password;
    private JLabel bq_passwords;
    private JPasswordField wbk_passwords;
    private JButton al_cancellation;
    private JButton al_determine;
    private JLabel bq_title;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
