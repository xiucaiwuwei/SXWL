/*
 * Created by JFormDesigner on Sat May 18 14:18:04 CST 2024
 */

package com.forms;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.*;

import com.database.*;

import static java.lang.Integer.*;

/**
 * @author Administrator
 */
public class forms_custom extends JFrame {
    public forms_custom() {
        initComponents();
    }
    //读取信息
    private void assignment() {
        wbk_id.setText(String.valueOf(datas.get(n).get(0)));
        wbk_name.setText(String.valueOf(datas.get(n).get(1)));
        wbk_number.setText(String.valueOf(datas.get(n).get(2)));
        wbk_name2.setText(String.valueOf(datas.get(n).get(3)));
        wbk_phone.setText(String.valueOf(datas.get(n).get(4)));
        wbk_address.setText(String.valueOf(datas.get(n).get(5)));
        wbk_paymenttime.setText(String.valueOf(datas.get(n).get(6)));
        wbk_deliverytime.setText(String.valueOf(datas.get(n).get(7)));
        wbk_notes.setText(String.valueOf(datas.get(n).get(8)));
        Object paymentTypeObj = datas.get(n).get(9);
        if (paymentTypeObj instanceof Boolean) {
            boolean isPayAsYouGo = (Boolean) paymentTypeObj;
            dx_payasyougo.setSelected(isPayAsYouGo);
            dx_collectpayment.setSelected(!isPayAsYouGo);
        } else if (paymentTypeObj instanceof String) {
            String paymentTypeString = (String) paymentTypeObj;
            boolean isPayAsYouGo = Boolean.parseBoolean(paymentTypeString);
            group.setSelected(dx_payasyougo.getModel(), false);
            group.setSelected(dx_collectpayment.getModel(), true);
            dx_payasyougo.setSelected(isPayAsYouGo);
            dx_collectpayment.setSelected(!isPayAsYouGo);
        } else {
            group.setSelected(dx_payasyougo.getModel(), true);
            group.setSelected(dx_collectpayment.getModel(), false);
            dx_payasyougo.setSelected(true);
            dx_collectpayment.setSelected(false);
        }
    }
    //修改按钮事件
    private void assignment(){
        wbk_id.setText(String.valueOf(datas.get(n).get(0)));
        wbk_name.setText(String.valueOf(datas.get(n).get(1)));
        wbk_number.setText(String.valueOf(datas.get(n).get(2)));
        wbk_address.setText(String.valueOf(datas.get(n).get(4)));
        wbk_paymenttime.setText(String.valueOf(datas.get(n).get(5)));
        wbk_deliverytime.setText(String.valueOf(datas.get(n).get(6)));
        wbk_notes.setText(String.valueOf(datas.get(n).get(7)));
        wbk_name2.setText(String.valueOf(datas.get(n).get(10)));
        wbk_phone.setText(String.valueOf(datas.get(n).get(11)));
        if(Boolean.parseBoolean(String.valueOf(datas.get(n).get(9)))){
            dx_payasyougo.setSelected(true);
            dx_collectpayment.setSelected(false);
        }else {
            dx_payasyougo.setSelected(false);
            dx_collectpayment.setSelected(true);
        }
    }
    private void al_modify(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        wbk_name2.setEnabled(true);
        wbk_phone.setEnabled(true);
        wbk_address.setEnabled(true);
        wbk_notes.setEnabled(true);
        dx_collectpayment.setEnabled(true);
        dx_payasyougo.setEnabled(true);
    }

    //退出按钮事件
    private void al_exit(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        System.exit(0);
    }

    //下一件按钮事件
    private void al_next(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        if (n >= datas.size() - 1) {
            JOptionPane.showMessageDialog(null, "没有下一件订单！", "警告", JOptionPane.PLAIN_MESSAGE, null);
        } else {
            n++;
            assignment();
        }
    }

    //上一件按钮事件
    private void al_previous(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        if (n <= 0) {
            JOptionPane.showMessageDialog(null, "已经到首件！", "警告", JOptionPane.PLAIN_MESSAGE, null);
        } else {
            n--;
            assignment();
        }
    }


    //保存按钮事件
    private void al_save(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        wbk_name2.setEnabled(false);
        wbk_phone.setEnabled(false);
        wbk_address.setEnabled(false);
        wbk_notes.setEnabled(false);
        dx_collectpayment.setEnabled(false);
        dx_payasyougo.setEnabled(false);
        Vector<Object> data = new Vector<>(datas.get(n));
        data.set(3, wbk_name2.getText());
        data.set(4, wbk_phone.getText());
        data.set(5, wbk_address.getText());
        data.set(8, wbk_notes.getText());
        if (dx_payasyougo.isSelected()) {
            data.set(9, false);
        } else {
            data.set(9, true);
        }
        datas.set(n, data);
        String sql = "update goods set putawayname =?,phone=?,address=?,notes=?,way=? where id=?";
        Connection connection = linksql.getconnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, wbk_name2.getText());
            statement.setString(2, wbk_phone.getText());
            statement.setString(3, wbk_address.getText());
            statement.setString(4, wbk_notes.getText());
            if (dx_payasyougo.isSelected()) {
                statement.setInt(5, 0);
            } else {
                statement.setInt(5, 1);
            }
            statement.setString(6, wbk_id.getText());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            linksql.closesql(connection, statement, null);
        }
    }

    //删除此订单按钮事件
    private void al_delete(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        String sql = "delete from goods where id = ?";
        Connection connection = linksql.getconnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, wbk_id.getText());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            linksql.closesql(connection, statement, null);
        }
        data.set(10,wbk_name2.getText());
        data.set(11, wbk_phone.getText());
        data.set(4,wbk_address.getText());
        data.set(7,wbk_notes.getText());
        if(dx_payasyougo.isSelected()){
            data.set(9,0);
        }else {
            data.set(9,1);
        }
        datas.set(n,data);
        String sql = "update goods set putawayname =?,phone=?,address=?,notes=?,way=? where id=?";
        Connection connection = linksql.getconnection();
        PreparedStatement statement =null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,wbk_name2.getText());
            statement.setString(2,wbk_phone.getText());
            statement.setString(3,wbk_address.getText());
            statement.setString(4,wbk_notes.getText());
            if(dx_payasyougo.getInheritsPopupMenu()){
                statement.setInt(5,0);
            }else {
                statement.setInt(5,1);
            }
            statement.setString(6,wbk_id.getText());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally {
            linksql.closesql(connection,statement,null);
        }
    }

    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        hSpacer1 = new JPanel(null);
        wbk_search = new JTextField();
        hSpacer2 = new JPanel(null);
        al_search = new JButton();
        bq_title = new JLabel();
        al_previous = new JButton();
        al_next = new JButton();
        al_delete = new JButton();
        al_exit = new JButton();
        al_modify = new JButton();
        al_save = new JButton();
        al_modifymy = new JButton();
        rq_mainbody = new JPanel();
        rq_photo = new JPanel();
        bq_id = new JLabel();
        wbk_id = new JTextField();
        bq_name = new JLabel();
        wbk_name = new JTextField();
        bq_number = new JLabel();
        wbk_number = new JTextField();
        bq_phone = new JLabel();
        wbk_phone = new JTextField();
        bq_paymenttime = new JLabel();
        wbk_paymenttime = new JTextField();
        bq_deliverytime = new JLabel();
        wbk_deliverytime = new JTextField();
        bq_address = new JLabel();
        bq_notes = new JLabel();
        rq_notes = new JScrollPane();
        wbk_notes = new JTextArea();
        bq_photo = new JLabel();
        rq_paymentmethod = new JPanel();
        dx_payasyougo = new JRadioButton();
        dx_collectpayment = new JRadioButton();
        bq_name2 = new JLabel();
        wbk_name2 = new JTextField();
        wbk_address = new JTextField();

        //======== this ========
        setTitle("\u53cc\u96c4\u7269\u6d41");
        setPreferredSize(new Dimension(800, 520));
        setResizable(false);
        setBackground(Color.white);
        setMinimumSize(null);
        setMaximumSize(null);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //---- hSpacer1 ----
            hSpacer1.setMinimumSize(null);
            hSpacer1.setMaximumSize(null);
            hSpacer1.setPreferredSize(new Dimension(1000, 25));
            menuBar1.add(hSpacer1);

            //---- wbk_search ----
            wbk_search.setPreferredSize(new Dimension(200, 25));
            wbk_search.setMinimumSize(null);
            wbk_search.setMaximumSize(null);
            menuBar1.add(wbk_search);

            //---- hSpacer2 ----
            hSpacer2.setMinimumSize(null);
            hSpacer2.setMaximumSize(null);
            hSpacer2.setPreferredSize(new Dimension(10, 25));
            menuBar1.add(hSpacer2);

            //---- al_search ----
            al_search.setText("\u641c\u7d22");
            al_search.setMinimumSize(null);
            al_search.setMaximumSize(null);
            al_search.setPreferredSize(new Dimension(60, 25));
            menuBar1.add(al_search);
        }
        setJMenuBar(menuBar1);

        //---- bq_title ----
        bq_title.setText("\u8ba2        \u5355        \u8be6        \u60c5");
        bq_title.setFont(new Font("\u6977\u4f53", Font.BOLD | Font.ITALIC, 20));
        bq_title.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(bq_title);
        bq_title.setBounds(40, 10, 700, bq_title.getPreferredSize().height);

        //---- al_previous ----
        al_previous.setText("\u4e0a\u4e00\u4ef6");
        al_previous.setMaximumSize(null);
        al_previous.setMinimumSize(null);
        al_previous.setPreferredSize(new Dimension(75, 25));
        al_previous.addActionListener(e -> al_previous(e));
        contentPane.add(al_previous);
        al_previous.setBounds(new Rectangle(new Point(495, 410), al_previous.getPreferredSize()));

        //---- al_next ----
        al_next.setText("\u4e0b\u4e00\u4ef6");
        al_next.setMaximumSize(null);
        al_next.setMinimumSize(null);
        al_next.setPreferredSize(new Dimension(75, 25));
        al_next.addActionListener(e -> al_next(e));
        contentPane.add(al_next);
        al_next.setBounds(new Rectangle(new Point(580, 410), al_next.getPreferredSize()));

        //---- al_delete ----
        al_delete.setText("\u5220\u9664\u6b64\u8ba2\u5355");
        al_delete.setMaximumSize(null);
        al_delete.setMinimumSize(null);
        al_delete.setPreferredSize(new Dimension(110, 25));
        al_delete.addActionListener(e -> al_delete(e));
        contentPane.add(al_delete);
        al_delete.setBounds(new Rectangle(new Point(160, 410), al_delete.getPreferredSize()));

        //---- al_exit ----
        al_exit.setText("\u9000\u51fa");
        al_exit.setMaximumSize(null);
        al_exit.setMinimumSize(null);
        al_exit.setPreferredSize(new Dimension(75, 25));
        al_exit.addActionListener(e -> al_exit(e));
        contentPane.add(al_exit);
        al_exit.setBounds(new Rectangle(new Point(665, 410), al_exit.getPreferredSize()));

        //---- al_modify ----
        al_modify.setText("\u4fee\u6539");
        al_modify.setMaximumSize(null);
        al_modify.setMinimumSize(null);
        al_modify.setPreferredSize(new Dimension(75, 25));
        al_modify.addActionListener(e -> al_modify(e));
        contentPane.add(al_modify);
        al_modify.setBounds(new Rectangle(new Point(325, 410), al_modify.getPreferredSize()));

        //---- al_save ----
        al_save.setText("\u4fdd\u5b58");
        al_save.setMaximumSize(null);
        al_save.setMinimumSize(null);
        al_save.setPreferredSize(new Dimension(75, 25));
        al_save.addActionListener(e -> al_save(e));
        contentPane.add(al_save);
        al_save.setBounds(410, 410, 75, 25);

        //---- al_modifymy ----
        al_modifymy.setText("\u4fee\u6539\u4e2a\u4eba\u4fe1\u606f");
        al_modifymy.setMaximumSize(null);
        al_modifymy.setMinimumSize(null);
        al_modifymy.setPreferredSize(new Dimension(110, 25));
        contentPane.add(al_modifymy);
        al_modifymy.setBounds(new Rectangle(new Point(40, 410), al_modifymy.getPreferredSize()));

        //======== rq_mainbody ========
        {
            rq_mainbody.setPreferredSize(new Dimension(300, 300));
            rq_mainbody.setBackground(new Color(0xcccccc));
            rq_mainbody.setLayout(null);

            //======== rq_photo ========
            {
                rq_photo.setPreferredSize(new Dimension(60, 80));
                rq_photo.setBackground(Color.white);
                rq_photo.setLayout(null);

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
            rq_mainbody.add(rq_photo);
            rq_photo.setBounds(515, 25, 150, 200);

            //---- bq_id ----
            bq_id.setText("\u8ba2\u5355\u7f16\u53f7");
            bq_id.setHorizontalAlignment(SwingConstants.RIGHT);
            rq_mainbody.add(bq_id);
            bq_id.setBounds(new Rectangle(new Point(25, 32), bq_id.getPreferredSize()));

            //---- wbk_id ----
            wbk_id.setPreferredSize(new Dimension(80, 30));
            wbk_id.setEnabled(false);
            rq_mainbody.add(wbk_id);
            wbk_id.setBounds(86, 25, 400, wbk_id.getPreferredSize().height);

            //---- bq_name ----
            bq_name.setText("\u540d\u79f0");
            bq_name.setHorizontalAlignment(SwingConstants.RIGHT);
            rq_mainbody.add(bq_name);
            bq_name.setBounds(new Rectangle(new Point(50, 74), bq_name.getPreferredSize()));

            //---- wbk_name ----
            wbk_name.setEnabled(false);
            rq_mainbody.add(wbk_name);
            wbk_name.setBounds(85, 70, 150, wbk_name.getPreferredSize().height);

            //---- bq_number ----
            bq_number.setText("\u6570\u91cf");
            rq_mainbody.add(bq_number);
            bq_number.setBounds(305, 75, bq_number.getPreferredSize().width, 15);

            //---- wbk_number ----
            wbk_number.setMinimumSize(new Dimension(150, 25));
            wbk_number.setEnabled(false);
            rq_mainbody.add(wbk_number);
            wbk_number.setBounds(340, 70, 146, wbk_number.getPreferredSize().height);

            //---- bq_phone ----
            bq_phone.setText("\u8054\u7cfb\u7535\u8bdd");
            bq_phone.setHorizontalAlignment(SwingConstants.RIGHT);
            rq_mainbody.add(bq_phone);
            bq_phone.setBounds(new Rectangle(new Point(280, 115), bq_phone.getPreferredSize()));

            //---- wbk_phone ----
            wbk_phone.setEnabled(false);
            rq_mainbody.add(wbk_phone);
            wbk_phone.setBounds(340, 110, 145, wbk_phone.getPreferredSize().height);

            //---- bq_paymenttime ----
            bq_paymenttime.setText("\u4ed8\u6b3e\u65f6\u95f4");
            bq_paymenttime.setHorizontalAlignment(SwingConstants.RIGHT);
            rq_mainbody.add(bq_paymenttime);
            bq_paymenttime.setBounds(new Rectangle(new Point(25, 150), bq_paymenttime.getPreferredSize()));

            //---- wbk_paymenttime ----
            wbk_paymenttime.setEnabled(false);
            rq_mainbody.add(wbk_paymenttime);
            wbk_paymenttime.setBounds(86, 146, 150, wbk_paymenttime.getPreferredSize().height);

            //---- bq_deliverytime ----
            bq_deliverytime.setText("\u53d1\u8d27\u65f6\u95f4");
            rq_mainbody.add(bq_deliverytime);
            bq_deliverytime.setBounds(new Rectangle(new Point(280, 150), bq_deliverytime.getPreferredSize()));

            //---- wbk_deliverytime ----
            wbk_deliverytime.setEnabled(false);
            rq_mainbody.add(wbk_deliverytime);
            wbk_deliverytime.setBounds(340, 146, 146, wbk_deliverytime.getPreferredSize().height);

            //---- bq_address ----
            bq_address.setText("\u6536\u8d27\u5730\u5740");
            bq_address.setHorizontalAlignment(SwingConstants.RIGHT);
            rq_mainbody.add(bq_address);
            bq_address.setBounds(18, 190, 55, bq_address.getPreferredSize().height);

            //---- bq_notes ----
            bq_notes.setText("\u5907\u6ce8");
            bq_notes.setHorizontalAlignment(SwingConstants.RIGHT);
            rq_mainbody.add(bq_notes);
            bq_notes.setBounds(new Rectangle(new Point(49, 230), bq_notes.getPreferredSize()));

            //======== rq_notes ========
            {

                //---- wbk_notes ----
                wbk_notes.setEnabled(false);
                rq_notes.setViewportView(wbk_notes);
            }
            rq_mainbody.add(rq_notes);
            rq_notes.setBounds(86, 225, 400, 100);

            //---- bq_photo ----
            bq_photo.setText("\u5546\u54c1\u56fe\u7247");
            rq_mainbody.add(bq_photo);
            bq_photo.setBounds(565, 230, bq_photo.getPreferredSize().width, 20);

            //======== rq_paymentmethod ========
            {
                rq_paymentmethod.setLayout(null);

                //---- dx_payasyougo ----
                dx_payasyougo.setText("\u73b0\u4ed8");
                dx_payasyougo.setEnabled(false);
                rq_paymentmethod.add(dx_payasyougo);
                dx_payasyougo.setBounds(5, 0, 50, 20);

                //---- dx_collectpayment ----
                dx_collectpayment.setText("\u5230\u4ed8");
                dx_collectpayment.setEnabled(false);
                rq_paymentmethod.add(dx_collectpayment);
                dx_collectpayment.setBounds(70, 0, 50, 20);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < rq_paymentmethod.getComponentCount(); i++) {
                        Rectangle bounds = rq_paymentmethod.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = rq_paymentmethod.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    rq_paymentmethod.setMinimumSize(preferredSize);
                    rq_paymentmethod.setPreferredSize(preferredSize);
                }
            }
            rq_mainbody.add(rq_paymentmethod);
            rq_paymentmethod.setBounds(530, 280, 120, rq_paymentmethod.getPreferredSize().height);

            //---- bq_name2 ----
            bq_name2.setText("\u6536\u8d27\u4eba\u59d3\u540d");
            bq_name2.setHorizontalAlignment(SwingConstants.RIGHT);
            rq_mainbody.add(bq_name2);
            bq_name2.setBounds(0, 115, 74, 17);

            //---- wbk_name2 ----
            wbk_name2.setEnabled(false);
            rq_mainbody.add(wbk_name2);
            wbk_name2.setBounds(85, 110, 150, 25);

            //---- wbk_address ----
            wbk_address.setPreferredSize(new Dimension(80, 30));
            wbk_address.setEnabled(false);
            rq_mainbody.add(wbk_address);
            wbk_address.setBounds(85, 185, 400, 30);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < rq_mainbody.getComponentCount(); i++) {
                    Rectangle bounds = rq_mainbody.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = rq_mainbody.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                rq_mainbody.setMinimumSize(preferredSize);
                rq_mainbody.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(rq_mainbody);
        rq_mainbody.setBounds(40, 45, 700, 345);

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
        datas = inspection.readdata(arrange);
        assignment();
        group.add(dx_payasyougo);
        group.add(dx_collectpayment);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JPanel hSpacer1;
    private JTextField wbk_search;
    private JPanel hSpacer2;
    private JButton al_search;
    private JLabel bq_title;
    private JButton al_previous;
    private JButton al_next;
    private JButton al_delete;
    private JButton al_exit;
    private JButton al_modify;
    private JButton al_save;
    private JButton al_modifymy;
    private JPanel rq_mainbody;
    private JPanel rq_photo;
    private JLabel bq_id;
    private JTextField wbk_id;
    private JLabel bq_name;
    private JTextField wbk_name;
    private JLabel bq_number;
    private JTextField wbk_number;
    private JLabel bq_phone;
    private JTextField wbk_phone;
    private JLabel bq_paymenttime;
    private JTextField wbk_paymenttime;
    private JLabel bq_deliverytime;
    private JTextField wbk_deliverytime;
    private JLabel bq_address;
    private JLabel bq_notes;
    private JScrollPane rq_notes;
    private JTextArea wbk_notes;
    private JLabel bq_photo;
    private JPanel rq_paymentmethod;
    private JRadioButton dx_payasyougo;
    private JRadioButton dx_collectpayment;
    private JLabel bq_name2;
    private JTextField wbk_name2;
    private JTextField wbk_address;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    //获得账户名
    private String account;
    private final ButtonGroup group = new ButtonGroup();
    private Vector<Vector<Object>> datas = new Vector<Vector<Object>>();
    //列的数量
    private int arrange = 11;
    private int n = 0;
}
