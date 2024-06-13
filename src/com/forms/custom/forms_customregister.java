/*
 * Created by JFormDesigner on Sun May 26 16:45:45 CST 2024
 */

package com.forms.custom;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;

import com.database.operatetable.IncreaseTable;
import com.database.operatetable.InspectionTable;
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
                    if(InspectionTable.InspectionCustomID(wbk_name.getText())) {
                        JOptionPane.showMessageDialog(null,"该用户名已存在！");
                    }else {
                        JOptionPane.showMessageDialog(null,"注册成功！");
                        Vector<String> data = new Vector<>();
                        data.add(wbk_name.getText());
                        data.add(wbk_password.getText());
                        data.add(wbk_name2.getText());
                        data.add(wbk_phone.getText());
                        data.add(wbk_address1.getText());
                        data.add(wbk_address2.getText());
                        IncreaseTable.IncreaseCustom(data);
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
        menuBar1 = new JMenuBar();
        hSpacer1 = new JPanel(null);
        bq_title = new JLabel();
        hSpacer2 = new JPanel(null);
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
        label8 = new JLabel();
        al_cancellation = new JButton();
        al_publish = new JButton();
        wbk_name2 = new JTextField();
        bq_name2 = new JLabel();
        label1 = new JLabel();

        //======== this ========
        setPreferredSize(new Dimension(480, 500));
        setTitle("\u6ce8\u518c");
        setResizable(false);
        setName("customregister");
        setIconImage(new ImageIcon(getClass().getResource("/com/picture/log.png")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {
            menuBar1.add(hSpacer1);

            //---- bq_title ----
            bq_title.setText("\u6ce8  \u518c  \u4e2a  \u4eba  \u4fe1  \u606f");
            bq_title.setFont(new Font("\u6977\u4f53", Font.BOLD, 20));
            menuBar1.add(bq_title);
            menuBar1.add(hSpacer2);
        }
        setJMenuBar(menuBar1);

        //---- bq_name ----
        bq_name.setText("\u7528\u6237\u540d");
        bq_name.setHorizontalAlignment(SwingConstants.RIGHT);
        bq_name.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(bq_name);
        bq_name.setBounds(10, 40, 80, 17);

        //---- wbk_name ----
        wbk_name.setPreferredSize(new Dimension(80, 30));
        wbk_name.setMaximumSize(null);
        wbk_name.setMinimumSize(null);
        wbk_name.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        wbk_name.setBorder(new LineBorder(Color.black, 1, true));
        contentPane.add(wbk_name);
        wbk_name.setBounds(100, 35, 140, 30);

        //---- bq_password ----
        bq_password.setText("\u5bc6\u7801");
        bq_password.setHorizontalAlignment(SwingConstants.RIGHT);
        bq_password.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(bq_password);
        bq_password.setBounds(10, 80, 80, 17);

        //---- wbk_password ----
        wbk_password.setPreferredSize(new Dimension(66, 30));
        wbk_password.setMaximumSize(null);
        wbk_password.setMinimumSize(null);
        wbk_password.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        wbk_password.setBorder(new LineBorder(Color.black, 1, true));
        contentPane.add(wbk_password);
        wbk_password.setBounds(100, 75, 140, 30);

        //---- bq_passwords ----
        bq_passwords.setText("\u786e\u8ba4\u5bc6\u7801");
        bq_passwords.setHorizontalAlignment(SwingConstants.RIGHT);
        bq_passwords.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(bq_passwords);
        bq_passwords.setBounds(10, 120, 80, 17);

        //---- wbk_passwords ----
        wbk_passwords.setPreferredSize(new Dimension(66, 30));
        wbk_passwords.setMaximumSize(null);
        wbk_passwords.setMinimumSize(null);
        wbk_passwords.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        wbk_passwords.setBorder(new LineBorder(Color.black, 1, true));
        contentPane.add(wbk_passwords);
        wbk_passwords.setBounds(100, 115, 140, 30);

        //---- bq_pass ----
        bq_pass.setText("\u9a8c\u8bc1\u7801");
        bq_pass.setHorizontalAlignment(SwingConstants.RIGHT);
        bq_pass.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(bq_pass);
        bq_pass.setBounds(10, 160, 80, 17);

        //---- wbk_pass ----
        wbk_pass.setPreferredSize(new Dimension(66, 30));
        wbk_pass.setMaximumSize(null);
        wbk_pass.setMinimumSize(null);
        wbk_pass.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        wbk_pass.setBorder(new LineBorder(Color.black, 1, true));
        contentPane.add(wbk_pass);
        wbk_pass.setBounds(100, 155, 70, 30);

        //---- wbk_passed ----
        wbk_passed.setPreferredSize(new Dimension(66, 30));
        wbk_passed.setMaximumSize(null);
        wbk_passed.setMinimumSize(null);
        wbk_passed.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        wbk_passed.setBorder(new LineBorder(Color.black, 1, true));
        wbk_passed.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(wbk_passed);
        wbk_passed.setBounds(175, 155, 65, 30);

        //---- bq_phone ----
        bq_phone.setText("\u7535\u8bdd");
        bq_phone.setHorizontalAlignment(SwingConstants.RIGHT);
        bq_phone.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(bq_phone);
        bq_phone.setBounds(170, 200, 80, 17);

        //---- wbk_phone ----
        wbk_phone.setPreferredSize(new Dimension(66, 30));
        wbk_phone.setMaximumSize(null);
        wbk_phone.setMinimumSize(null);
        wbk_phone.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        wbk_phone.setBorder(new LineBorder(Color.black, 1, true));
        contentPane.add(wbk_phone);
        wbk_phone.setBounds(260, 195, 140, 30);

        //---- bq_address1 ----
        bq_address1.setText("\u6536\u8d27\u5730\u57401");
        bq_address1.setHorizontalAlignment(SwingConstants.RIGHT);
        bq_address1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(bq_address1);
        bq_address1.setBounds(10, 240, 80, 17);

        //---- wbk_address1 ----
        wbk_address1.setPreferredSize(new Dimension(66, 30));
        wbk_address1.setMaximumSize(null);
        wbk_address1.setMinimumSize(null);
        wbk_address1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        wbk_address1.setBorder(new LineBorder(Color.black, 1, true));
        contentPane.add(wbk_address1);
        wbk_address1.setBounds(100, 235, 300, 30);

        //---- bq_address2 ----
        bq_address2.setText("\u6536\u8d27\u5730\u57402");
        bq_address2.setHorizontalAlignment(SwingConstants.RIGHT);
        bq_address2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(bq_address2);
        bq_address2.setBounds(10, 280, 80, 17);

        //---- wbk_address2 ----
        wbk_address2.setPreferredSize(new Dimension(66, 30));
        wbk_address2.setMaximumSize(null);
        wbk_address2.setMinimumSize(null);
        wbk_address2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        wbk_address2.setBorder(new LineBorder(Color.black, 1, true));
        contentPane.add(wbk_address2);
        wbk_address2.setBounds(100, 275, 300, 30);

        //---- label8 ----
        label8.setText("\u5934\u50cf");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(315, 165), label8.getPreferredSize()));

        //---- al_cancellation ----
        al_cancellation.setText("\u53d6\u6d88");
        al_cancellation.setFont(new Font("\u6977\u4f53", Font.PLAIN, 24));
        al_cancellation.setForeground(Color.blue);
        al_cancellation.setBackground(Color.white);
        al_cancellation.addActionListener(e -> al_cancellation(e));
        contentPane.add(al_cancellation);
        al_cancellation.setBounds(250, 340, 150, 50);

        //---- al_publish ----
        al_publish.setText("\u767b\u5f55");
        al_publish.setFont(new Font("\u6977\u4f53", Font.PLAIN, 24));
        al_publish.setForeground(Color.blue);
        al_publish.setBackground(Color.white);
        al_publish.addActionListener(e -> al_publish(e));
        contentPane.add(al_publish);
        al_publish.setBounds(55, 340, 150, 50);

        //---- wbk_name2 ----
        wbk_name2.setPreferredSize(new Dimension(66, 30));
        wbk_name2.setMaximumSize(null);
        wbk_name2.setMinimumSize(null);
        wbk_name2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        wbk_name2.setBorder(new LineBorder(Color.black, 1, true));
        contentPane.add(wbk_name2);
        wbk_name2.setBounds(100, 195, 100, 30);

        //---- bq_name2 ----
        bq_name2.setText("\u6536\u8d27\u4eba\u59d3\u540d");
        bq_name2.setHorizontalAlignment(SwingConstants.RIGHT);
        bq_name2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(bq_name2);
        bq_name2.setBounds(10, 200, 80, 17);

        //---- label1 ----
        label1.setIcon(new ImageIcon(getClass().getResource("/com/picture/\u5934\u50cf.jpg")));
        label1.setBorder(new LineBorder(Color.black, 1, true));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(270, 35), label1.getPreferredSize()));

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
        wbk_passed.setText(Code.getCode());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JPanel hSpacer1;
    private JLabel bq_title;
    private JPanel hSpacer2;
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
    private JLabel label8;
    private JButton al_cancellation;
    private JButton al_publish;
    private JTextField wbk_name2;
    private JLabel bq_name2;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
