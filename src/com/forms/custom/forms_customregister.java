/*
 * Created by JFormDesigner on Sun May 26 16:45:45 CST 2024
 */

package com.forms.custom;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

import com.database.operatetable.operatecustom;
import com.forms.share.*;
import com.database.*;
/**
 * @author Administrator
 */
public class forms_customregister extends JFrame {
    public forms_customregister() {
        initComponents();
    }

    private void al_exit(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        System.exit(0);
    }

    private void al_cancellation(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        setVisible(false);
        forms_register forms_register = new forms_register();
        forms_register.setVisible(true);
    }

    private void al_publish(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        if(wbk_name.getText().isEmpty() || wbk_password.getText().isEmpty() || wbk_passwords.getText().isEmpty()
                || wbk_pass.getText().isEmpty() || wbk_passed.getText().isEmpty() || wbk_phone.getText().isEmpty()
                || wbk_address1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"请填写完整信息");
        }else{
            if(wbk_password.getText().equals(wbk_passwords.getText())) {
                if(wbk_pass.getText().equals(wbk_passed.getText())) {
                    if(operatecustom.selectaccount(wbk_name.getText())) {
                        JOptionPane.showMessageDialog(null,"该用户名已存在！");
                    }else {
                        JOptionPane.showMessageDialog(null,"注册成功！");
                        Vector<String> data = new Vector<>();
                        data.add(wbk_name.getText());
                        data.add(wbk_password.getText());
                        data.add(wbk_phone.getText());
                        data.add(wbk_address1.getText());
                        data.add(wbk_address2.getText());
                        operatecustom.importcustom(data);
                        setVisible(false);
                        forms_register register = new forms_register();
                        register.setVisible(true);
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"验证码输入错误！");
                }
            }else {
                JOptionPane.showMessageDialog(null,"密码和确认密码不一致！");
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        bq_name = new JLabel();
        wbk_name = new JTextField();
        bq_password = new JLabel();
        wbk_password = new JTextField();
        bq_passwords = new JLabel();
        wbk_passwords = new JTextField();
        bq_pass = new JLabel();
        wbk_pass = new JTextField();
        wbk_passed = new JTextField();
        bq_phone = new JLabel();
        wbk_phone = new JTextField();
        bq_address1 = new JLabel();
        wbk_address1 = new JTextField();
        bq_address2 = new JLabel();
        wbk_address2 = new JTextField();
        textField8 = new JTextField();
        label8 = new JLabel();
        bq_title = new JLabel();
        al_cancellation = new JButton();
        al_publish = new JButton();
        al_exit = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(400, 360));
        setTitle("\u53cc\u96c4\u7269\u6d41");
        setResizable(false);
        setName("customregister");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- bq_name ----
        bq_name.setText("\u7528\u6237\u540d");
        bq_name.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(bq_name);
        bq_name.setBounds(20, 60, 59, 17);

        //---- wbk_name ----
        wbk_name.setPreferredSize(new Dimension(66, 30));
        contentPane.add(wbk_name);
        wbk_name.setBounds(95, 55, 140, 25);

        //---- bq_password ----
        bq_password.setText("\u5bc6\u7801");
        bq_password.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(bq_password);
        bq_password.setBounds(20, 90, 59, 17);

        //---- wbk_password ----
        wbk_password.setPreferredSize(new Dimension(66, 30));
        contentPane.add(wbk_password);
        wbk_password.setBounds(95, 85, 140, 25);

        //---- bq_passwords ----
        bq_passwords.setText("\u786e\u8ba4\u5bc6\u7801");
        bq_passwords.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(bq_passwords);
        bq_passwords.setBounds(20, 120, 59, 17);

        //---- wbk_passwords ----
        wbk_passwords.setPreferredSize(new Dimension(66, 30));
        contentPane.add(wbk_passwords);
        wbk_passwords.setBounds(95, 115, 140, 25);

        //---- bq_pass ----
        bq_pass.setText("\u9a8c\u8bc1\u7801");
        bq_pass.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(bq_pass);
        bq_pass.setBounds(20, 150, 59, 17);

        //---- wbk_pass ----
        wbk_pass.setPreferredSize(new Dimension(66, 30));
        contentPane.add(wbk_pass);
        wbk_pass.setBounds(95, 145, 70, 25);

        //---- wbk_passed ----
        wbk_passed.setPreferredSize(new Dimension(66, 30));
        contentPane.add(wbk_passed);
        wbk_passed.setBounds(165, 145, 70, 25);

        //---- bq_phone ----
        bq_phone.setText("\u7535\u8bdd");
        bq_phone.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(bq_phone);
        bq_phone.setBounds(20, 180, 59, 17);

        //---- wbk_phone ----
        wbk_phone.setPreferredSize(new Dimension(66, 30));
        contentPane.add(wbk_phone);
        wbk_phone.setBounds(95, 175, 140, 25);

        //---- bq_address1 ----
        bq_address1.setText("\u6536\u8d27\u5730\u57401");
        bq_address1.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(bq_address1);
        bq_address1.setBounds(20, 210, 59, 17);

        //---- wbk_address1 ----
        wbk_address1.setPreferredSize(new Dimension(66, 30));
        contentPane.add(wbk_address1);
        wbk_address1.setBounds(95, 205, 260, 25);

        //---- bq_address2 ----
        bq_address2.setText("\u6536\u8d27\u5730\u57402");
        bq_address2.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(bq_address2);
        bq_address2.setBounds(20, 240, 59, 17);

        //---- wbk_address2 ----
        wbk_address2.setPreferredSize(new Dimension(66, 30));
        contentPane.add(wbk_address2);
        wbk_address2.setBounds(95, 235, 260, 25);

        //---- textField8 ----
        textField8.setPreferredSize(new Dimension(60, 60));
        contentPane.add(textField8);
        textField8.setBounds(255, 55, 100, 100);

        //---- label8 ----
        label8.setText("\u5934\u50cf");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(290, 165), label8.getPreferredSize()));

        //---- bq_title ----
        bq_title.setText("\u6ce8  \u518c  \u4e2a  \u4eba  \u4fe1  \u606f");
        bq_title.setFont(new Font("\u6977\u4f53", Font.BOLD, 20));
        contentPane.add(bq_title);
        bq_title.setBounds(new Rectangle(new Point(85, 15), bq_title.getPreferredSize()));

        //---- al_cancellation ----
        al_cancellation.setText("\u53d6\u6d88");
        al_cancellation.addActionListener(e -> al_cancellation(e));
        contentPane.add(al_cancellation);
        al_cancellation.setBounds(new Rectangle(new Point(35, 280), al_cancellation.getPreferredSize()));

        //---- al_publish ----
        al_publish.setText("\u767b\u5f55");
        al_publish.addActionListener(e -> al_publish(e));
        contentPane.add(al_publish);
        al_publish.setBounds(new Rectangle(new Point(160, 280), al_publish.getPreferredSize()));

        //---- al_exit ----
        al_exit.setText("\u9000\u51fa");
        al_exit.addActionListener(e -> al_exit(e));
        contentPane.add(al_exit);
        al_exit.setBounds(new Rectangle(new Point(280, 280), al_exit.getPreferredSize()));

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
        wbk_passed.setEnabled(false);
        wbk_passed.setText(code.getcode());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel bq_name;
    private JTextField wbk_name;
    private JLabel bq_password;
    private JTextField wbk_password;
    private JLabel bq_passwords;
    private JTextField wbk_passwords;
    private JLabel bq_pass;
    private JTextField wbk_pass;
    private JTextField wbk_passed;
    private JLabel bq_phone;
    private JTextField wbk_phone;
    private JLabel bq_address1;
    private JTextField wbk_address1;
    private JLabel bq_address2;
    private JTextField wbk_address2;
    private JTextField textField8;
    private JLabel label8;
    private JLabel bq_title;
    private JButton al_cancellation;
    private JButton al_publish;
    private JButton al_exit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
