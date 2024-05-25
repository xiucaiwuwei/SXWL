/*
 * Created by JFormDesigner on Sat May 18 09:20:46 CST 2024
 */

package com.forms.administrators;

import com.database.operatetable.operatecustom;
import com.database.operatetable.operategoods;
import com.database.operatetable.operatestaff;
import com.forms.share.forms_modify;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 * @author Administrator
 */
public class forms_administrators extends JFrame {
    public forms_administrators() {
        initComponents();
    }

    private void bg_passwork(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        forms_modify modify = new forms_modify();
        modify.setVisible(true);
    }

    private void bg_exit(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        System.exit(0);
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        Vector<Vector<Object>> datas = operatestaff.readstaffs();
        Vector<String> title = new Vector<>();
        title.add("员工编号");
        title.add("姓名");
        title.add("性别");
        title.add("年龄");
        title.add("职位");
        title.add("联系方式");
        title.add("入职时间");
        title.add("账号");
        title.add("密码");
        table1.setModel(new DefaultTableModel(datas, title));
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        Vector<Vector<Object>> datas = operatecustom.readcustoms();
        Vector<String> title = new Vector<>();
        title.add("账户");
        title.add("密码");
        title.add("电话");
        title.add("地址1");
        title.add("地址2");
        table1.setModel(new DefaultTableModel(datas, title));
    }

    private void button4(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        Vector<Vector<Object>> datas = operategoods.readgoods();
        Vector<String> title = new Vector<>();
        title.add("订单编号");
        title.add("名称");
        title.add("数量");
        title.add("收货人姓名");
        title.add("联系电话");
        title.add("收货地址");
        title.add("付款时间");
        title.add("发货时间");
        title.add("备注");
        title.add("付款方式");
        title.add("商品图片");
        title.add("客户");
        title.add("配送员");
        title.add("签收情况");
        title.add("签收时间");
        table1.setModel(new DefaultTableModel(datas, title));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        actionbar = new JMenuBar();
        setup = new JMenu();
        bg_passwork = new JMenuItem();
        bg_exit = new JMenuItem();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        hSpacer1 = new JPanel(null);
        textField1 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setTitle("\u53cc\u96c4\u7269\u6d41");
        setName("administrators");
        setPreferredSize(new Dimension(1000, 600));
        setMinimumSize(null);
        setMaximumSize(null);
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== actionbar ========
        {

            //======== setup ========
            {
                setup.setText("\u8bbe\u7f6e");
                setup.setPreferredSize(new Dimension(40, 19));
                setup.setHorizontalAlignment(SwingConstants.CENTER);

                //---- bg_passwork ----
                bg_passwork.setText("\u4fee\u6539\u5bc6\u7801");
                bg_passwork.addActionListener(e -> bg_passwork(e));
                setup.add(bg_passwork);

                //---- bg_exit ----
                bg_exit.setText("\u9000\u51fa\u7cfb\u7edf");
                bg_exit.addActionListener(e -> bg_exit(e));
                setup.add(bg_exit);
            }
            actionbar.add(setup);

            //---- button2 ----
            button2.setText("\u5458\u5de5\u8868");
            button2.addActionListener(e -> button2(e));
            actionbar.add(button2);

            //---- button3 ----
            button3.setText("\u5ba2\u6237\u8868");
            button3.addActionListener(e -> button3(e));
            actionbar.add(button3);

            //---- button4 ----
            button4.setText("\u8d27\u7269\u8868");
            button4.addActionListener(e -> button4(e));
            actionbar.add(button4);

            //---- hSpacer1 ----
            hSpacer1.setPreferredSize(new Dimension(1000, 10));
            actionbar.add(hSpacer1);

            //---- textField1 ----
            textField1.setMaximumSize(null);
            textField1.setMinimumSize(null);
            textField1.setPreferredSize(new Dimension(240, 25));
            actionbar.add(textField1);

            //---- button1 ----
            button1.setText("\u641c\u7d22");
            actionbar.add(button1);
        }
        setJMenuBar(actionbar);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(15, 15, 950, 490);

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
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar actionbar;
    private JMenu setup;
    private JMenuItem bg_passwork;
    private JMenuItem bg_exit;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel hSpacer1;
    private JTextField textField1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
