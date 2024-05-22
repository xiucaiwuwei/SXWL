/*
 * Created by JFormDesigner on Sat May 18 22:16:23 CST 2024
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
 * @author Administrator
 */
public class forms_staff extends JFrame {
    public forms_staff() {
        initComponents();
    }

    private void al_modify(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        wbk_phone.setEnabled(true);
    }

    private void al_save(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        wbk_phone.setEnabled(false);
        if(wbk_phone.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "联系电话不能为空！", "警告", JOptionPane.PLAIN_MESSAGE, null);
        }else {
            String sql ="update staff set phone=? where id=?";
            Connection connection = linksql.getconnection();
            PreparedStatement statement;
            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, wbk_phone.getText());
                statement.setString(2, wbk_id.getText());
                statement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            linksql.closesql(connection,statement,null);
        }
    }

    private void al_return(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        hSpacer1 = new JPanel(null);
        al_modify = new JButton();
        al_save = new JButton();
        al_return = new JButton();
        bq_id = new JLabel();
        wbk_id = new JTextField();
        bq_name = new JLabel();
        wbk_name = new JTextField();
        bq_gender = new JLabel();
        wbk_gender = new JTextField();
        bq_age = new JLabel();
        wbk_age = new JTextField();
        bq_phone = new JLabel();
        wbk_phone = new JTextField();
        bq_position = new JLabel();
        wbk_position = new JTextField();
        bq_data = new JLabel();
        wbk_data = new JTextField();
        al_query = new JButton();
        al_print = new JButton();
        bq_title = new JLabel();
        rq_photo = new JPanel();
        label10 = new JLabel();

        //======== this ========
        setPreferredSize(new Dimension(380, 400));
        setResizable(false);
        setTitle("\u4e2a\u4eba\u754c\u9762");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {
            menuBar1.add(hSpacer1);

            //---- al_modify ----
            al_modify.setText("\u66f4\u6539\u7535\u8bdd");
            al_modify.setPreferredSize(new Dimension(100, 25));
            al_modify.setMinimumSize(null);
            al_modify.setMaximumSize(null);
            al_modify.addActionListener(e -> al_modify(e));
            menuBar1.add(al_modify);

            //---- al_save ----
            al_save.setText("\u4fdd\u5b58");
            al_save.setPreferredSize(new Dimension(60, 25));
            al_save.addActionListener(e -> al_save(e));
            menuBar1.add(al_save);

            //---- al_return ----
            al_return.setText("\u8fd4\u56de");
            al_return.setPreferredSize(new Dimension(60, 25));
            al_return.addActionListener(e -> al_return(e));
            menuBar1.add(al_return);
        }
        setJMenuBar(menuBar1);

        //---- bq_id ----
        bq_id.setText("\u5de5\u53f7");
        contentPane.add(bq_id);
        bq_id.setBounds(new Rectangle(new Point(50, 85), bq_id.getPreferredSize()));

        //---- wbk_id ----
        wbk_id.setEnabled(false);
        contentPane.add(wbk_id);
        wbk_id.setBounds(80, 80, 100, wbk_id.getPreferredSize().height);

        //---- bq_name ----
        bq_name.setText("\u59d3\u540d");
        contentPane.add(bq_name);
        bq_name.setBounds(new Rectangle(new Point(50, 120), bq_name.getPreferredSize()));

        //---- wbk_name ----
        wbk_name.setEnabled(false);
        contentPane.add(wbk_name);
        wbk_name.setBounds(80, 115, 100, wbk_name.getPreferredSize().height);

        //---- bq_gender ----
        bq_gender.setText("\u6027\u522b");
        contentPane.add(bq_gender);
        bq_gender.setBounds(new Rectangle(new Point(50, 150), bq_gender.getPreferredSize()));

        //---- wbk_gender ----
        wbk_gender.setEnabled(false);
        contentPane.add(wbk_gender);
        wbk_gender.setBounds(80, 145, 100, wbk_gender.getPreferredSize().height);

        //---- bq_age ----
        bq_age.setText("\u5e74\u9f84");
        contentPane.add(bq_age);
        bq_age.setBounds(new Rectangle(new Point(50, 185), bq_age.getPreferredSize()));

        //---- wbk_age ----
        wbk_age.setEnabled(false);
        contentPane.add(wbk_age);
        wbk_age.setBounds(80, 180, 100, wbk_age.getPreferredSize().height);

        //---- bq_phone ----
        bq_phone.setText("\u7535\u8bdd");
        contentPane.add(bq_phone);
        bq_phone.setBounds(new Rectangle(new Point(50, 215), bq_phone.getPreferredSize()));

        //---- wbk_phone ----
        wbk_phone.setEnabled(false);
        contentPane.add(wbk_phone);
        wbk_phone.setBounds(80, 210, 100, wbk_phone.getPreferredSize().height);

        //---- bq_position ----
        bq_position.setText("\u804c\u4f4d");
        contentPane.add(bq_position);
        bq_position.setBounds(new Rectangle(new Point(50, 250), bq_position.getPreferredSize()));

        //---- wbk_position ----
        wbk_position.setEnabled(false);
        contentPane.add(wbk_position);
        wbk_position.setBounds(80, 245, 100, wbk_position.getPreferredSize().height);

        //---- bq_data ----
        bq_data.setText("\u5165\u804c\u65e5\u671f");
        contentPane.add(bq_data);
        bq_data.setBounds(new Rectangle(new Point(25, 285), bq_data.getPreferredSize()));

        //---- wbk_data ----
        wbk_data.setEnabled(false);
        contentPane.add(wbk_data);
        wbk_data.setBounds(80, 280, 100, wbk_data.getPreferredSize().height);

        //---- al_query ----
        al_query.setText("\u67e5\u8be2\u5de5\u8d44");
        al_query.setPreferredSize(new Dimension(120, 25));
        contentPane.add(al_query);
        al_query.setBounds(new Rectangle(new Point(205, 245), al_query.getPreferredSize()));

        //---- al_print ----
        al_print.setText("\u6253\u5370\u5de5\u8d44\u6761");
        al_print.setPreferredSize(new Dimension(120, 25));
        contentPane.add(al_print);
        al_print.setBounds(new Rectangle(new Point(205, 280), al_print.getPreferredSize()));

        //---- bq_title ----
        bq_title.setText("\u5458\u5de5\u4fe1\u606f");
        bq_title.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 28));
        contentPane.add(bq_title);
        bq_title.setBounds(new Rectangle(new Point(130, 20), bq_title.getPreferredSize()));

        //======== rq_photo ========
        {
            rq_photo.setPreferredSize(new Dimension(120, 150));
            rq_photo.setBackground(new Color(0x999999));
            rq_photo.setMinimumSize(null);
            rq_photo.setMaximumSize(null);
            rq_photo.setLayout(null);

            //---- label10 ----
            label10.setText("\u7167\u7247");
            label10.setHorizontalAlignment(SwingConstants.CENTER);
            rq_photo.add(label10);
            label10.setBounds(0, 0, 120, 150);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < rq_photo.getComponentCount(); i++) {
                    Rectangle bounds = rq_photo.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = rq_photo.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                rq_photo.setMinimumSize(preferredSize);
                rq_photo.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(rq_photo);
        rq_photo.setBounds(new Rectangle(new Point(205, 80), rq_photo.getPreferredSize()));

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
        wbk_id.setText(inspection.readaccount());
        String sql = "select * from staff where account=?";
        Connection connection = linksql.getconnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement= connection.prepareStatement(sql);
            statement.setString(1,wbk_id.getText());
            resultSet=statement.executeQuery();
            resultSet.next();
            wbk_name.setText(resultSet.getString(2));
            wbk_gender.setText(resultSet.getString(3));
            wbk_age.setText(resultSet.getString(4)); 
            wbk_data.setText(resultSet.getString(5));
            wbk_position.setText(resultSet.getString(6));
            wbk_phone.setText(resultSet.getString(7));
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
    private JLabel bq_id;
    private JTextField wbk_id;
    private JLabel bq_name;
    private JTextField wbk_name;
    private JLabel bq_gender;
    private JTextField wbk_gender;
    private JLabel bq_age;
    private JTextField wbk_age;
    private JLabel bq_phone;
    private JTextField wbk_phone;
    private JLabel bq_position;
    private JTextField wbk_position;
    private JLabel bq_data;
    private JTextField wbk_data;
    private JButton al_query;
    private JButton al_print;
    private JLabel bq_title;
    private JPanel rq_photo;
    private JLabel label10;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
