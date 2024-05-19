/*
 * Created by JFormDesigner on Sun May 19 11:12:22 CST 2024
 */

package com.forms;

import java.awt.*;
import javax.swing.*;

/**
 * @author Administrator
 */
public class forms_staffwork extends JFrame {
    public forms_staffwork() {
        initComponents();
    }

    private void initComponents() {
        String[] titleforrow ={"订单编号","订单时间","发货时间","联系电话","收货地址","签收情况","收货时间"};
        Object[][] record = new Object[40][titleforrow.length];
        scrollPane1 = new JScrollPane();
        table1 = new JTable(record,titleforrow);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();
        button2 = new JButton();
        comboBox1 = new JComboBox();
        textField1 = new JTextField();
        label1 = new JLabel();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        panel1 = new JPanel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();

        //======== this ========
        setResizable(false);
        setPreferredSize(new Dimension(1000, 640));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u8bbe\u7f6e");

                //---- menuItem1 ----
                menuItem1.setText("\u4fee\u6539\u5bc6\u7801");
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("\u4e2a\u4eba\u4fe1\u606f");
                menu1.add(menuItem2);

                //---- menuItem3 ----
                menuItem3.setText("\u9000\u51fa\u7cfb\u7edf");
                menu1.add(menuItem3);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //---- button2 ----
        button2.setText("\u9000\u51fa");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(868, 515), button2.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setPreferredSize(new Dimension(600, 350));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(45, 10, 900, 475);
        contentPane.add(comboBox1);
        comboBox1.setBounds(new Rectangle(new Point(75, 515), comboBox1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(395, 515, 200, textField1.getPreferredSize().height);

        //---- label1 ----
        label1.setText("text");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(50, 519), label1.getPreferredSize()));

        //---- button5 ----
        button5.setText("text");
        contentPane.add(button5);
        button5.setBounds(new Rectangle(new Point(610, 515), button5.getPreferredSize()));

        //---- button6 ----
        button6.setText("text");
        contentPane.add(button6);
        button6.setBounds(new Rectangle(new Point(696, 515), button6.getPreferredSize()));

        //---- button7 ----
        button7.setText("text");
        contentPane.add(button7);
        button7.setBounds(new Rectangle(new Point(782, 515), button7.getPreferredSize()));

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- radioButton1 ----
            radioButton1.setText("text");
            panel1.add(radioButton1);
            radioButton1.setBounds(new Rectangle(new Point(55, 0), radioButton1.getPreferredSize()));

            //---- radioButton2 ----
            radioButton2.setText("text");
            panel1.add(radioButton2);
            radioButton2.setBounds(new Rectangle(new Point(0, 0), radioButton2.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(160, 517, 115, panel1.getPreferredSize().height);

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
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JLabel label1;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JPanel panel1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
