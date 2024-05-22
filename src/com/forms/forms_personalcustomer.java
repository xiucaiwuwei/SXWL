/*
 * Created by JFormDesigner on Wed May 22 13:55:56 CST 2024
 */

package com.forms;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import com.database.*;
/**
 * @author 17529
 */
public class forms_personalcustomer extends JFrame {
    public forms_personalcustomer() {
        initComponents();
    }
    //退出按钮事件
    private void al_exit(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        System.exit(0);
    }

    private void al_return(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        this.setVisible(false);
        forms_custom custom = new forms_custom();
        custom.setVisible(true);
    }

    private void al_modify(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        wbk_account.setEnabled(true);
        wbk_password.setEnabled(true);
        wbk_phone.setEnabled(true);
        wbk_address1.setEnabled(true);
        wbk_address2.setEnabled(true);
    }

    private void al_save(ActionEvent e) {
        // TODO add your code here
        if(wbk_account.getText().isEmpty() || wbk_password.getText().isEmpty() || wbk_phone.getText().isEmpty()
                || wbk_address1.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "请填写完整信息", "提示", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            wbk_account.setEnabled(false);
            wbk_password.setEnabled(false);
            wbk_phone.setEnabled(false);
            wbk_address1.setEnabled(false);
            wbk_address2.setEnabled(false);
            String sql1 = "update custom set account=?,password = ?, phone = ?, address1 = ?, address2 = ? where account = ?";
            String sql2 = "update temporary set account=?,password=? where account=?";
            Connection connection = linksql.getconnection();
            PreparedStatement statement = null;
            try {
                statement = connection.prepareStatement(sql1);
                statement.setString(1, wbk_account.getText());
                statement.setString(2, wbk_password.getText());
                statement.setString(3, wbk_phone.getText());
                statement.setString(4, wbk_address1.getText());
                statement.setString(5, wbk_address2.getText());
                statement.setString(6, inspection.readaccount());
                statement.executeUpdate();
                statement = connection.prepareStatement(sql2);
                statement.setString(1, wbk_account.getText());
                statement.setString(2, wbk_password.getText());
                statement.setString(3, inspection.readaccount());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "修改成功", "提示", JOptionPane.WARNING_MESSAGE);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }finally {
                linksql.closesql(connection, statement, null);
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        hSpacer1 = new JPanel(null);
        al_modify = new JButton();
        al_save = new JButton();
        al_return = new JButton();
        al_exit = new JButton();
        bq_title = new JLabel();
        bq_account = new JLabel();
        wbk_account = new JTextField();
        bq_password = new JLabel();
        wbk_password = new JTextField();
        bq_phone = new JLabel();
        wbk_phone = new JTextField();
        bq_address1 = new JLabel();
        wbk_address1 = new JTextField();
        bq_address2 = new JLabel();
        wbk_address2 = new JTextField();
        rq_profilepicture = new JPanel();
        bq_profilepicture = new JLabel();

        //======== this ========
        setPreferredSize(new Dimension(430, 400));
        setResizable(false);
        setTitle("\u4fee\u6539\u4e2a\u4eba\u4fe1\u606f");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {
            menuBar1.add(hSpacer1);

            //---- al_modify ----
            al_modify.setText("\u4fee\u6539");
            al_modify.setPreferredSize(new Dimension(80, 30));
            al_modify.setMinimumSize(null);
            al_modify.setMaximumSize(null);
            al_modify.addActionListener(e -> al_modify(e));
            menuBar1.add(al_modify);

            //---- al_save ----
            al_save.setText("\u4fdd\u5b58");
            al_save.setPreferredSize(new Dimension(80, 30));
            al_save.setMinimumSize(null);
            al_save.setMaximumSize(null);
            al_save.addActionListener(e -> al_save(e));
            menuBar1.add(al_save);

            //---- al_return ----
            al_return.setText("\u8fd4\u56de");
            al_return.setMinimumSize(null);
            al_return.setMaximumSize(null);
            al_return.setPreferredSize(new Dimension(80, 30));
            al_return.addActionListener(e -> al_return(e));
            menuBar1.add(al_return);

            //---- al_exit ----
            al_exit.setText("\u9000\u51fa");
            al_exit.setMinimumSize(null);
            al_exit.setPreferredSize(new Dimension(80, 30));
            al_exit.setMaximumSize(null);
            al_exit.addActionListener(e -> al_exit(e));
            menuBar1.add(al_exit);
        }
        setJMenuBar(menuBar1);

        //---- bq_title ----
        bq_title.setText("\u4e2a    \u4eba    \u4fe1    \u606f");
        bq_title.setFont(new Font("\u6977\u4f53", Font.BOLD, 24));
        contentPane.add(bq_title);
        bq_title.setBounds(new Rectangle(new Point(85, 20), bq_title.getPreferredSize()));

        //---- bq_account ----
        bq_account.setText("\u7528\u6237\u540d");
        bq_account.setHorizontalTextPosition(SwingConstants.RIGHT);
        contentPane.add(bq_account);
        bq_account.setBounds(50, 75, bq_account.getPreferredSize().width, 15);

        //---- wbk_account ----
        wbk_account.setEnabled(false);
        wbk_account.setPreferredSize(new Dimension(120, 30));
        contentPane.add(wbk_account);
        wbk_account.setBounds(100, 65, 120, wbk_account.getPreferredSize().height);

        //---- bq_password ----
        bq_password.setText("\u5bc6\u7801");
        bq_password.setHorizontalTextPosition(SwingConstants.RIGHT);
        bq_password.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(bq_password);
        bq_password.setBounds(50, 125, 40, 20);

        //---- wbk_password ----
        wbk_password.setEnabled(false);
        wbk_password.setMaximumSize(null);
        wbk_password.setMinimumSize(null);
        wbk_password.setPreferredSize(new Dimension(120, 30));
        contentPane.add(wbk_password);
        wbk_password.setBounds(100, 120, 120, 30);

        //---- bq_phone ----
        bq_phone.setText("\u7535\u8bdd");
        bq_phone.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(bq_phone);
        bq_phone.setBounds(50, 175, 40, 18);

        //---- wbk_phone ----
        wbk_phone.setEnabled(false);
        wbk_phone.setPreferredSize(new Dimension(120, 30));
        wbk_phone.setMinimumSize(null);
        wbk_phone.setMaximumSize(null);
        contentPane.add(wbk_phone);
        wbk_phone.setBounds(100, 170, 120, 30);

        //---- bq_address1 ----
        bq_address1.setText("\u6536\u8d27\u5730\u57401");
        bq_address1.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(bq_address1);
        bq_address1.setBounds(20, 230, 70, 20);

        //---- wbk_address1 ----
        wbk_address1.setEnabled(false);
        wbk_address1.setMaximumSize(null);
        wbk_address1.setMinimumSize(null);
        wbk_address1.setPreferredSize(new Dimension(260, 30));
        contentPane.add(wbk_address1);
        wbk_address1.setBounds(100, 225, 260, 30);

        //---- bq_address2 ----
        bq_address2.setText("\u6536\u8d27\u5730\u57402");
        bq_address2.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(bq_address2);
        bq_address2.setBounds(20, 281, 70, 18);

        //---- wbk_address2 ----
        wbk_address2.setEnabled(false);
        wbk_address2.setPreferredSize(new Dimension(260, 30));
        wbk_address2.setMinimumSize(null);
        wbk_address2.setMaximumSize(null);
        contentPane.add(wbk_address2);
        wbk_address2.setBounds(100, 275, 260, 30);

        //======== rq_profilepicture ========
        {
            rq_profilepicture.setPreferredSize(new Dimension(120, 120));
            rq_profilepicture.setBackground(new Color(0x999999));
            rq_profilepicture.setMaximumSize(null);
            rq_profilepicture.setMinimumSize(null);
            rq_profilepicture.setLayout(null);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < rq_profilepicture.getComponentCount(); i++) {
                    Rectangle bounds = rq_profilepicture.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = rq_profilepicture.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                rq_profilepicture.setMinimumSize(preferredSize);
                rq_profilepicture.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(rq_profilepicture);
        rq_profilepicture.setBounds(new Rectangle(new Point(235, 65), rq_profilepicture.getPreferredSize()));

        //---- bq_profilepicture ----
        bq_profilepicture.setText("\u5934\u50cf");
        contentPane.add(bq_profilepicture);
        bq_profilepicture.setBounds(new Rectangle(new Point(280, 195), bq_profilepicture.getPreferredSize()));

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
        String account = inspection.readaccount();
        String sql = "select * from custom where account=?";
        Connection connection = linksql.getconnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,account);
            resultSet = statement.executeQuery();
            resultSet.next();
            account = resultSet.getString(1);
            wbk_account.setText(account);
            wbk_password.setText(resultSet.getString(2));
            wbk_phone.setText(resultSet.getString(3));
            wbk_address1.setText(resultSet.getString(4));
            wbk_address2.setText(resultSet.getString(5));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            linksql.closesql(connection,statement,resultSet);
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JPanel hSpacer1;
    private JButton al_modify;
    private JButton al_save;
    private JButton al_return;
    private JButton al_exit;
    private JLabel bq_title;
    private JLabel bq_account;
    private JTextField wbk_account;
    private JLabel bq_password;
    private JTextField wbk_password;
    private JLabel bq_phone;
    private JTextField wbk_phone;
    private JLabel bq_address1;
    private JTextField wbk_address1;
    private JLabel bq_address2;
    private JTextField wbk_address2;
    private JPanel rq_profilepicture;
    private JLabel bq_profilepicture;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private String account;
}
