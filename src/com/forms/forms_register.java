/*
 * Created by JFormDesigner on Sat May 18 08:45:25 CST 2024
 */

package com.forms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.database.*;
/**
 * @author Administrator
 */
@SuppressWarnings("rawtypes")
public class forms_register extends JFrame {
    public forms_register() {
        initComponents();
    }

    private void al_publish(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        int select = limitation.getSelectedIndex();
        String account = wbk_account.getText();
        String password = String.valueOf(wbk_password.getPassword());
        if (account.isEmpty() && password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "用户名和密码不能为空！", "警告", JOptionPane.PLAIN_MESSAGE, null);
        } else if (!account.isEmpty() && password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "密码不能为空！", "警告", JOptionPane.PLAIN_MESSAGE, null);
        } else if (account.isEmpty()) {
            JOptionPane.showMessageDialog(null, "用户名不能为空！", "警告", JOptionPane.PLAIN_MESSAGE, null);
        }else {
            if(select==0){
                String sql = "select account,password from custom";
                if(inspection.validate(sql,account,password)){
                    inspection.valitemp(account,password);
                    this.setVisible(false);
                    forms_custom custom = new forms_custom();
                    custom.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "用户名和密码错误！", "警告", JOptionPane.PLAIN_MESSAGE, null);
                }
            }else if(select==1){
                String sql = "select account,password from staff";
                if(inspection.validate(sql,account,password)){
                    inspection.valitemp(account,password);
                    this.setVisible(false);
                    forms_staff staff = new forms_staff();
                    staff.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "用户名和密码错误！", "警告", JOptionPane.PLAIN_MESSAGE, null);
                }
            }else {
                String sql = "select account,password from administrators";
                if (inspection.validate(sql, account, password)) {
                    inspection.valitemp(account,password);
                    this.setVisible(false);
                    forms_administrators administrators = new forms_administrators();
                    administrators.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "用户名和密码错误！", "警告", JOptionPane.PLAIN_MESSAGE, null);
                }
            }
        }
    }

    private void limitation(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        int select = limitation.getSelectedIndex();
        al_register.setEnabled(select == 0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        bq_title = new JLabel();
        bq_account = new JLabel();
        bq_password = new JLabel();
        wbk_account = new JFormattedTextField();
        wbk_password = new JPasswordField();
        //noinspection rawtypes
        limitation = new JComboBox();
        al_publish = new JButton();
        al_register = new JButton();

        //======== this ========
        setTitle("\u767b\u5f55\u754c\u9762");
        setName("register");
        setResizable(false);
        setMinimumSize(null);
        setPreferredSize(new Dimension(400, 300));
        setMaximumSize(null);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- bq_title ----
        bq_title.setText("\u53cc\u96c4\u7269\u6d41\u7ba1\u7406\u7cfb\u7edf");
        bq_title.setFont(new Font("\u6977\u4f53", Font.BOLD, 24));
        contentPane.add(bq_title);
        bq_title.setBounds(new Rectangle(new Point(90, 45), bq_title.getPreferredSize()));

        //---- bq_account ----
        bq_account.setText("\u8d26\u6237\uff1a");
        bq_account.setMinimumSize(null);
        bq_account.setMaximumSize(null);
        bq_account.setPreferredSize(new Dimension(40, 30));
        contentPane.add(bq_account);
        bq_account.setBounds(100, 105, bq_account.getPreferredSize().width, 20);

        //---- bq_password ----
        bq_password.setText("\u5bc6\u7801\uff1a");
        bq_password.setMaximumSize(null);
        bq_password.setMinimumSize(null);
        bq_password.setPreferredSize(new Dimension(40, 30));
        contentPane.add(bq_password);
        bq_password.setBounds(100, 150, bq_password.getPreferredSize().width, 20);

        //---- wbk_account ----
        wbk_account.setMinimumSize(null);
        wbk_account.setPreferredSize(new Dimension(150, 30));
        wbk_account.setMaximumSize(null);
        contentPane.add(wbk_account);
        wbk_account.setBounds(new Rectangle(new Point(135, 100), wbk_account.getPreferredSize()));

        //---- wbk_password ----
        wbk_password.setPreferredSize(new Dimension(150, 30));
        contentPane.add(wbk_password);
        wbk_password.setBounds(new Rectangle(new Point(135, 145), wbk_password.getPreferredSize()));

        //---- limitation ----
        limitation.setMaximumSize(null);
        limitation.setMinimumSize(null);
        limitation.setPreferredSize(new Dimension(80, 25));
        limitation.setActionCommand("\u6743\u9650");
        limitation.addActionListener(e -> limitation(e));
        contentPane.add(limitation);
        limitation.setBounds(new Rectangle(new Point(305, 0), limitation.getPreferredSize()));

        //---- al_publish ----
        al_publish.setText("\u767b\u5f55");
        al_publish.setMaximumSize(null);
        al_publish.setMinimumSize(null);
        al_publish.setPreferredSize(new Dimension(75, 30));
        al_publish.addActionListener(e -> al_publish(e));
        contentPane.add(al_publish);
        al_publish.setBounds(new Rectangle(new Point(205, 195), al_publish.getPreferredSize()));

        //---- al_register ----
        al_register.setText("\u6ce8\u518c");
        al_register.setMaximumSize(null);
        al_register.setMinimumSize(null);
        al_register.setPreferredSize(new Dimension(75, 30));
        contentPane.add(al_register);
        al_register.setBounds(new Rectangle(new Point(105, 195), al_register.getPreferredSize()));

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
        limitation.setPrototypeDisplayValue("客户");
        limitation.addItem("客户");
        limitation.addItem("员工");
        limitation.addItem("管理员");
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel bq_title;
    private JLabel bq_account;
    private JLabel bq_password;
    private JFormattedTextField wbk_account;
    private JPasswordField wbk_password;
    private JComboBox limitation;
    private JButton al_publish;
    private JButton al_register;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
