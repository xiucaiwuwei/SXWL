/*
 * Created by JFormDesigner on Sun May 19 11:12:22 CST 2024
 */

package com.forms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Administrator
 */
public class forms_staffwork extends JFrame {
    public forms_staffwork() {
        initComponents();
    }

    private void menuItem2(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        forms_staff staff = new forms_staff();
        staff.setVisible(true);
    }

    private void al_exit(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        System.exit(0);
    }

    private void menuItem3(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        System.exit(0);
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
        al_exit = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        typesof = new JComboBox();
        wbk_search = new JTextField();
        bq_sort = new JLabel();
        al_search = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        rq_sort = new JPanel();
        dx_rise = new JRadioButton();
        dx_fall = new JRadioButton();
        button1 = new JButton();

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
                menuItem2.addActionListener(e -> menuItem2(e));
                menu1.add(menuItem2);

                //---- menuItem3 ----
                menuItem3.setText("\u9000\u51fa\u7cfb\u7edf");
                menuItem3.addActionListener(e -> menuItem3(e));
                menu1.add(menuItem3);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //---- al_exit ----
        al_exit.setText("\u9000\u51fa");
        al_exit.addActionListener(e -> al_exit(e));
        contentPane.add(al_exit);
        al_exit.setBounds(new Rectangle(new Point(868, 515), al_exit.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setPreferredSize(new Dimension(600, 350));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(45, 10, 900, 475);
        contentPane.add(typesof);
        typesof.setBounds(new Rectangle(new Point(85, 515), typesof.getPreferredSize()));
        contentPane.add(wbk_search);
        wbk_search.setBounds(280, 515, 200, wbk_search.getPreferredSize().height);

        //---- bq_sort ----
        bq_sort.setText("\u6392\u5e8f");
        contentPane.add(bq_sort);
        bq_sort.setBounds(new Rectangle(new Point(50, 519), bq_sort.getPreferredSize()));

        //---- al_search ----
        al_search.setText("\u67e5\u8be2");
        contentPane.add(al_search);
        al_search.setBounds(new Rectangle(new Point(490, 515), al_search.getPreferredSize()));

        //---- button6 ----
        button6.setText("\u4fee\u6539");
        contentPane.add(button6);
        button6.setBounds(new Rectangle(new Point(696, 515), button6.getPreferredSize()));

        //---- button7 ----
        button7.setText("\u4fdd\u5b58");
        contentPane.add(button7);
        button7.setBounds(new Rectangle(new Point(782, 515), button7.getPreferredSize()));

        //======== rq_sort ========
        {
            rq_sort.setLayout(null);

            //---- dx_rise ----
            dx_rise.setText("\u5347\u5e8f");
            rq_sort.add(dx_rise);
            dx_rise.setBounds(new Rectangle(new Point(5, 0), dx_rise.getPreferredSize()));

            //---- dx_fall ----
            dx_fall.setText("\u964d\u5e8f");
            rq_sort.add(dx_fall);
            dx_fall.setBounds(new Rectangle(new Point(60, 0), dx_fall.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < rq_sort.getComponentCount(); i++) {
                    Rectangle bounds = rq_sort.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = rq_sort.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                rq_sort.setMinimumSize(preferredSize);
                rq_sort.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(rq_sort);
        rq_sort.setBounds(160, 517, 115, rq_sort.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u5220\u9664");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(610, 515), button1.getPreferredSize()));

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
    private JButton al_exit;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JComboBox typesof;
    private JTextField wbk_search;
    private JLabel bq_sort;
    private JButton al_search;
    private JButton button6;
    private JButton button7;
    private JPanel rq_sort;
    private JRadioButton dx_rise;
    private JRadioButton dx_fall;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
