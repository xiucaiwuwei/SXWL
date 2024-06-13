/*
 * Created by JFormDesigner on Sun May 19 11:12:22 CST 2024
 */

package com.forms.staff;

import com.database.operatetable.*;
import com.forms.share.forms_modify;

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

    private void xx_modify(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        forms_modify modify = new forms_modify();
        modify.setVisible(true);
    }

    private void al_search(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        datas = SelectTable.selectgoodsstaff(wbk_search.getText());
        bg_goods.setModel(new DefaultTableModel(datas, title));
    }

    private void al_search2(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        al_increase.setEnabled(false);
        datas = SelectTable.selectstaff(ReadTable.ReadTemporary().get(0));
        bg_goods.setModel(new DefaultTableModel(datas, title));
    }

    private void al_return(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        al_increase.setEnabled(true);
        datas = SelectTable.SelectUndistributed();
        bg_goods.setModel(new DefaultTableModel(datas, title));
    }

    private void al_increase(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        int[] selectedRows = bg_goods.getSelectedRows();
        if (selectedRows.length > 0) {
            DefaultTableModel model = (DefaultTableModel) bg_goods.getModel();
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                int rowIndex = selectedRows[i];
                UpdateTable.UpdateAllocation(model.getValueAt(rowIndex, 0).toString(), ReadTable.ReadTemporary().get(0));
                model.removeRow(rowIndex);
            }
        }
    }

    private void al_delete2(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        if (DeleteTable.DeleteSigned()){
            JOptionPane.showMessageDialog(null, "删除成功");
            datas = SelectTable.SelectUndistributed();
            bg_goods.setModel(new DefaultTableModel(datas, title));
        }else {
            JOptionPane.showMessageDialog(null, "无需删除记录");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        xx_modify = new JMenuItem();
        xx_information = new JMenuItem();
        hSpacer1 = new JPanel(null);
        bq_id2 = new JLabel();
        wbk_search = new JTextField();
        al_search = new JButton();
        al_exit = new JButton();
        rq_goods = new JScrollPane();
        bg_goods = new JTable();
        rq_sort = new JPanel();
        al_delete2 = new JButton();
        al_increase = new JButton();
        al_search2 = new JButton();
        al_return = new JButton();

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
            }
            menuBar1.add(menu1);

            //---- hSpacer1 ----
            hSpacer1.setPreferredSize(new Dimension(1000, 10));
            menuBar1.add(hSpacer1);

            //---- bq_id2 ----
            bq_id2.setText("\u6536\u8d27\u5730\u5740");
            bq_id2.setPreferredSize(new Dimension(60, 17));
            bq_id2.setHorizontalAlignment(SwingConstants.CENTER);
            menuBar1.add(bq_id2);

            //---- wbk_search ----
            wbk_search.setPreferredSize(new Dimension(240, 25));
            menuBar1.add(wbk_search);

            //---- al_search ----
            al_search.setText("\u67e5\u8be2");
            al_search.addActionListener(e -> al_search(e));
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

        //======== rq_sort ========
        {
            rq_sort.setLayout(null);

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
        rq_sort.setBounds(185, 515, 115, rq_sort.getPreferredSize().height);

        //---- al_delete2 ----
        al_delete2.setText("\u5220\u9664\u5168\u90e8\u5df2\u7b7e\u6536");
        al_delete2.addActionListener(e -> al_delete2(e));
        contentPane.add(al_delete2);
        al_delete2.setBounds(new Rectangle(new Point(740, 515), al_delete2.getPreferredSize()));

        //---- al_increase ----
        al_increase.setText("\u6dfb\u52a0\u5230\u672c\u4eba\u63a5\u7ba1");
        al_increase.addActionListener(e -> al_increase(e));
        contentPane.add(al_increase);
        al_increase.setBounds(new Rectangle(new Point(610, 515), al_increase.getPreferredSize()));

        //---- al_search2 ----
        al_search2.setText("\u67e5\u8be2\u672c\u4eba\u7ba1\u8f96\u8bb0\u5f55");
        al_search2.addActionListener(e -> al_search2(e));
        contentPane.add(al_search2);
        al_search2.setBounds(new Rectangle(new Point(45, 515), al_search2.getPreferredSize()));

        //---- al_return ----
        al_return.setText("\u8fd4\u56de");
        al_return.addActionListener(e -> al_return(e));
        contentPane.add(al_return);
        al_return.setBounds(new Rectangle(new Point(185, 515), al_return.getPreferredSize()));

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
        title = new Vector<>();
        title.add("订单编号");
        title.add("签收人姓名");
        title.add("联系电话");
        title.add("收货地址");
        title.add("订单备注");
        title.add("付款方式");
        title.add("签收情况");
        title.add("签收时间");
        datas = SelectTable.SelectUndistributed();
        bg_goods.setModel(new DefaultTableModel(datas, title));
        JTableHeader header = bg_goods.getTableHeader();
        header.setReorderingAllowed(false);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem xx_modify;
    private JMenuItem xx_information;
    private JPanel hSpacer1;
    private JLabel bq_id2;
    private JTextField wbk_search;
    private JButton al_search;
    private JButton al_exit;
    private JScrollPane rq_goods;
    private JTable bg_goods;
    private JPanel rq_sort;
    private JButton al_delete2;
    private JButton al_increase;
    private JButton al_search2;
    private JButton al_return;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private final ButtonGroup sort = new ButtonGroup();
    private Vector<Vector<Object>> datas;
    private Vector<String> title;
}
