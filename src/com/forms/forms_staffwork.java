/*
 * Created by JFormDesigner on Sun May 19 11:12:22 CST 2024
 */

package com.forms;

import com.database.inspection;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

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

    private void xx_modify(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        forms_modify modify = new forms_modify();
        modify.setVisible(true);
    }

    private void initComponents() {
        Vector<Vector<Object>> datas = inspection.readgoods(inspection.readaccount());
        Vector<String> title = new Vector<>();
        title.add("订单编号");
        title.add("发货时间");
        title.add("签收人姓名");
        title.add("联系电话");
        title.add("收货地址");
        title.add("订单备注");
        title.add("付款方式");
        title.add("签收情况");
        title.add("签收时间");
        typesof = new JComboBox<>(title);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        xx_modify = new JMenuItem();
        xx_information = new JMenuItem();
        xx_exit = new JMenuItem();
        hSpacer1 = new JPanel(null);
        bq_id2 = new JLabel();
        wbk_search = new JTextField();
        al_search = new JButton();
        al_exit = new JButton();
        rq_goods = new JScrollPane();
        bg_goods = new JTable();
        bq_sort = new JLabel();
        al_modify = new JButton();
        al_save = new JButton();
        rq_sort = new JPanel();
        dx_rise = new JRadioButton();
        dx_fall = new JRadioButton();
        al_delete = new JButton();

        //======== this ========
        setResizable(false);
        setPreferredSize(new Dimension(1000, 640));
        setTitle("\u53cc\u96c4\u7269\u6d41\u7cfb\u7edf");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u8bbe\u7f6e");

                //---- xx_modify ----
                xx_modify.setText("\u4fee\u6539\u5bc6\u7801");
                xx_modify.addActionListener(e -> xx_modify(e));
                menu1.add(xx_modify);

                //---- xx_information ----
                xx_information.setText("\u4e2a\u4eba\u4fe1\u606f");
                xx_information.addActionListener(e -> menuItem2(e));
                menu1.add(xx_information);

                //---- xx_exit ----
                xx_exit.setText("\u9000\u51fa\u7cfb\u7edf");
                xx_exit.addActionListener(e -> menuItem3(e));
                menu1.add(xx_exit);
            }
            menuBar1.add(menu1);

            //---- hSpacer1 ----
            hSpacer1.setPreferredSize(new Dimension(1000, 10));
            menuBar1.add(hSpacer1);

            //---- bq_id2 ----
            bq_id2.setText("\u8ba2\u5355\u7f16\u53f7");
            bq_id2.setPreferredSize(new Dimension(60, 17));
            bq_id2.setHorizontalAlignment(SwingConstants.CENTER);
            menuBar1.add(bq_id2);

            //---- wbk_search ----
            wbk_search.setPreferredSize(new Dimension(240, 25));
            menuBar1.add(wbk_search);

            //---- al_search ----
            al_search.setText("\u67e5\u8be2");
            menuBar1.add(al_search);
        }
        setJMenuBar(menuBar1);

        //---- al_exit ----
        al_exit.setText("\u9000\u51fa");
        al_exit.addActionListener(e -> al_exit(e));
        contentPane.add(al_exit);
        al_exit.setBounds(new Rectangle(new Point(868, 515), al_exit.getPreferredSize()));

        //======== rq_goods ========
        {
            rq_goods.setPreferredSize(new Dimension(600, 350));
            rq_goods.setViewportView(bg_goods);
        }
        contentPane.add(rq_goods);
        rq_goods.setBounds(45, 10, 900, 475);
        contentPane.add(typesof);
        typesof.setBounds(new Rectangle(new Point(85, 515), typesof.getPreferredSize()));

        //---- bq_sort ----
        bq_sort.setText("\u6392\u5e8f");
        contentPane.add(bq_sort);
        bq_sort.setBounds(new Rectangle(new Point(50, 519), bq_sort.getPreferredSize()));

        //---- al_modify ----
        al_modify.setText("\u4fee\u6539");
        contentPane.add(al_modify);
        al_modify.setBounds(new Rectangle(new Point(696, 515), al_modify.getPreferredSize()));

        //---- al_save ----
        al_save.setText("\u4fdd\u5b58");
        contentPane.add(al_save);
        al_save.setBounds(new Rectangle(new Point(782, 515), al_save.getPreferredSize()));

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
        rq_sort.setBounds(205, 517, 115, rq_sort.getPreferredSize().height);

        //---- al_delete ----
        al_delete.setText("\u5220\u9664");
        contentPane.add(al_delete);
        al_delete.setBounds(new Rectangle(new Point(610, 515), al_delete.getPreferredSize()));

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
        bg_goods.setModel(new DefaultTableModel(datas, title));
        sort.add(dx_rise);
        sort.add(dx_fall);
        JTableHeader header = bg_goods.getTableHeader();
        header.setReorderingAllowed(false);

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem xx_modify;
    private JMenuItem xx_information;
    private JMenuItem xx_exit;
    private JPanel hSpacer1;
    private JLabel bq_id2;
    private JTextField wbk_search;
    private JButton al_search;
    private JButton al_exit;
    private JScrollPane rq_goods;
    private JTable bg_goods;
    private JLabel bq_sort;
    private JButton al_modify;
    private JButton al_save;
    private JPanel rq_sort;
    private JRadioButton dx_rise;
    private JRadioButton dx_fall;
    private JButton al_delete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private JComboBox<String> typesof;
    private ButtonGroup sort = new ButtonGroup();
}
