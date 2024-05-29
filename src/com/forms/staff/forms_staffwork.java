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

    private void al_delete(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        int[] selectedRows = bg_goods.getSelectedRows();
        if (selectedRows.length > 0) {
            DefaultTableModel model = (DefaultTableModel) bg_goods.getModel();
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                int rowIndex = selectedRows[i];
                DeleteTable.deleteTable("goods",model.getValueAt(rowIndex, 0).toString());
                model.removeRow(rowIndex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "请选择至少一行进行删除");
        }
    }

    private void al_save(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        DefaultTableModel model = (DefaultTableModel) bg_goods.getModel();
        for (int i = 0; i < bg_goods.getRowCount(); i++) {
            if (bg_goods.isCellSelected(i, 1)) {
                Vector<Object> data = new Vector<>();
                for (int j = 0; j < bg_goods.getColumnCount(); j++){
                    data.add(model.getValueAt(i, j));
                    if (j==6){
                        if(model.getValueAt(i, j).toString().equals("货到付款")){
                            data.set(j,1);
                        }else{
                            data.set(j,0);
                        }
                    }
                    if(j==7){
                        if(model.getValueAt(i, j).toString().equals("已签收")){
                            data.set(j,1);
                        }else{
                            data.set(j,0);
                        }
                    }
                }
                data.add(datas.get(i).get(0));
                operategoods.updategoodsstaff(data);
            }
        }
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        datas = operategoods.selectstaff(String.valueOf(ReadTable.readTable("temporary").get(0).get(0)));
        bg_goods.setModel(new DefaultTableModel(datas, title));
    }

    private void initComponents() {
        datas = operategoods.selectstaff(String.valueOf(ReadTable.readTable("temporary").get(0).get(0)));
        title = new Vector<>();
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
        hSpacer1 = new JPanel(null);
        bq_id2 = new JLabel();
        wbk_search = new JTextField();
        al_search = new JButton();
        al_exit = new JButton();
        rq_goods = new JScrollPane();
        bg_goods = new JTable();

        bq_sort = new JLabel();
        al_save = new JButton();
        rq_sort = new JPanel();
        dx_rise = new JRadioButton();
        dx_fall = new JRadioButton();
        al_delete = new JButton();
        button1 = new JButton();
        button2 = new JButton();

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

        //---- al_save ----
        al_save.setText("\u4fdd\u5b58");
        al_save.addActionListener(e -> al_save(e));
        contentPane.add(al_save);
        al_save.setBounds(new Rectangle(new Point(700, 515), al_save.getPreferredSize()));

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
        rq_sort.setBounds(185, 515, 115, rq_sort.getPreferredSize().height);

        //---- al_delete ----
        al_delete.setText("\u5220\u9664");
        al_delete.addActionListener(e -> al_delete(e));
        contentPane.add(al_delete);
        al_delete.setBounds(new Rectangle(new Point(530, 515), al_delete.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u5237\u65b0");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(785, 515), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u6dfb\u52a0");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(615, 515), button2.getPreferredSize()));

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
    private JPanel hSpacer1;
    private JLabel bq_id2;
    private JTextField wbk_search;
    private JButton al_search;
    private JButton al_exit;
    private JScrollPane rq_goods;
    private JTable bg_goods;
    private JComboBox typesof;
    private JLabel bq_sort;
    private JButton al_save;
    private JPanel rq_sort;
    private JRadioButton dx_rise;
    private JRadioButton dx_fall;
    private JButton al_delete;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private ButtonGroup sort = new ButtonGroup();
    private Vector<Vector<Object>> datas;
    private Vector<String> title;
}
