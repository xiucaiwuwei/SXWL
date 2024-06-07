/*
 * Created by JFormDesigner on Sat May 18 09:20:46 CST 2024
 */

package com.forms.administrators;

import com.database.operatetable.*;
import com.forms.share.forms_modify;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import static com.database.operatetable.DeleteTable.*;


/**
 * @author Administrator
 */
public class forms_administrators extends JFrame {
    public forms_administrators() {
        initComponents();
    }

    /**
     * 根据条件选择要操作的表格。
     *
     * @return 表格名称，作为后续操作的数据源。
     */
    private boolean deletetable(String id){
        if (n==1) {
            return deleteTable("custom",id);
        }else if (n==2){
            return deleteTable("staff",id);
        }else if (n==3){
            return deleteTable("goods",id);
        }else if (n==4){
            return deleteTable("wages",id);
        }else {
            return false;
        }
    }

    private void al_password(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        forms_modify modify = new forms_modify();
        modify.setVisible(true);
    }

    private void al_staff(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        bq_title.setText("员    工    表");
        datas = ReadTable.readTable("staff");
        title = new Vector<>();
        title.add("员工编号");
        title.add("姓名");
        title.add("性别");
        title.add("年龄");
        title.add("入职时间");
        title.add("职位");
        title.add("联系电话");
        title.add("账号");
        title.add("密码");
        bg_table.setModel(new DefaultTableModel(datas, title));
        JTableHeader header = bg_table.getTableHeader();
        header.setReorderingAllowed(false);
        n=2;
    }

    private void al_custom(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        bq_title.setText("客    户    表");
        datas = ReadTable.readTable("custom");
        title = new Vector<>();
        title.add("账户");
        title.add("密码");
        title.add("电话");
        title.add("地址1");
        title.add("地址2");
        bg_table.setModel(new DefaultTableModel(datas, title));
        JTableHeader header = bg_table.getTableHeader();
        header.setReorderingAllowed(false);
        n=1;
    }

    private void al_goods(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        bq_title.setText("货    物    表");
        datas = ReadTable.readTable("goods");
        title = new Vector<>();
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
        bg_table.setModel(new DefaultTableModel(datas, title));
        JTableHeader header = bg_table.getTableHeader();
        header.setReorderingAllowed(false);
        n=3;
    }

    private void al_delete(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        int[] selectedRows = bg_table.getSelectedRows();
        if (selectedRows.length > 0) {
            DefaultTableModel model = (DefaultTableModel) bg_table.getModel();
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                int rowIndex = selectedRows[i];
                if(deletetable(model.getValueAt(rowIndex, 0).toString())){
                    JOptionPane.showMessageDialog(null, "删除成功");
                }else {
                    JOptionPane.showMessageDialog(null, "删除失败");
                }
                model.removeRow(rowIndex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "请选择至少一行进行删除");
        }
    }

    private void al_increase(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        DefaultTableModel model = (DefaultTableModel) bg_table.getModel();
        if(title.isEmpty()){
            JOptionPane.showMessageDialog(null, "请选择表格");
        }else {
            model.addRow(new Object[title.size()]);
        }
    }

    private void al_exit(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        System.exit(0);
    }

    private void al_save(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        if(title.isEmpty()){
            JOptionPane.showMessageDialog(null, "未选择表格");
        }else {
            DefaultTableModel model = (DefaultTableModel) bg_table.getModel();
            for (int i = 0; i < bg_table.getRowCount(); i++) {
                if(bg_table.isCellSelected(i, 1)){
                    Vector<String> data = new Vector<>();
                    for (int j = 0; j < bg_table.getColumnCount(); j++) {
                        data.add(model.getValueAt(i, j).toString());
                    }
                    data.add(datas.get(i).get(0).toString());
                    UpdateTable.UpdateStaff(data);
                }

            }
        }
    }

    private void al_wages(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        datas = ReadTable.readTable("wages");
        title = new Vector<>();
        title.add("员工编号");
        title.add("姓名");
        title.add("基本工资");
        title.add("在职天数");
        title.add("应发工资");
        title.add("月奖金");
        title.add("应扣工资");
        title.add("实发工资");
        title.add("备注");
        bg_table.setModel(new DefaultTableModel(datas, title));
        JTableHeader header = bg_table.getTableHeader();
        header.setReorderingAllowed(false);
        n=4;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        actionbar = new JMenuBar();
        al_password = new JButton();
        al_staff = new JButton();
        al_custom = new JButton();
        al_goods = new JButton();
        al_wages = new JButton();
        hSpacer1 = new JPanel(null);
        bq_id = new JLabel();
        wbk_id = new JTextField();
        al_search = new JButton();
        al_exit = new JButton();
        al_delete = new JButton();
        al_save = new JButton();
        al_increase = new JButton();
        bq_title = new JLabel();
        rq_table = new JScrollPane();
        bg_table = new JTable();

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

            //---- al_password ----
            al_password.setText("\u4fee\u6539\u5bc6\u7801");
            al_password.addActionListener(e -> al_password(e));
            actionbar.add(al_password);

            //---- al_staff ----
            al_staff.setText("\u5458\u5de5\u8868");
            al_staff.addActionListener(e -> al_staff(e));
            actionbar.add(al_staff);

            //---- al_custom ----
            al_custom.setText("\u5ba2\u6237\u8868");
            al_custom.addActionListener(e -> al_custom(e));
            actionbar.add(al_custom);

            //---- al_goods ----
            al_goods.setText("\u8d27\u7269\u8868");
            al_goods.addActionListener(e -> al_goods(e));
            actionbar.add(al_goods);

            //---- al_wages ----
            al_wages.setText("\u5de5\u8d44\u8868");
            al_wages.addActionListener(e -> al_wages(e));
            actionbar.add(al_wages);

            //---- hSpacer1 ----
            hSpacer1.setPreferredSize(new Dimension(1000, 10));
            actionbar.add(hSpacer1);

            //---- bq_id ----
            bq_id.setText("\u7f16\u53f7");
            actionbar.add(bq_id);

            //---- wbk_id ----
            wbk_id.setMaximumSize(null);
            wbk_id.setMinimumSize(null);
            wbk_id.setPreferredSize(new Dimension(240, 25));
            actionbar.add(wbk_id);

            //---- al_search ----
            al_search.setText("\u641c\u7d22");
            actionbar.add(al_search);
        }
        setJMenuBar(actionbar);

        //---- al_exit ----
        al_exit.setText("\u9000\u51fa");
        al_exit.addActionListener(e -> al_exit(e));
        contentPane.add(al_exit);
        al_exit.setBounds(new Rectangle(new Point(890, 10), al_exit.getPreferredSize()));

        //---- al_delete ----
        al_delete.setText("\u5220\u9664");
        al_delete.addActionListener(e -> al_delete(e));
        contentPane.add(al_delete);
        al_delete.setBounds(new Rectangle(new Point(810, 10), al_delete.getPreferredSize()));

        //---- al_save ----
        al_save.setText("\u4fdd\u5b58");
        al_save.addActionListener(e -> al_save(e));
        contentPane.add(al_save);
        al_save.setBounds(new Rectangle(new Point(730, 10), al_save.getPreferredSize()));

        //---- al_increase ----
        al_increase.setText("\u6dfb\u52a0");
        al_increase.addActionListener(e -> al_increase(e));
        contentPane.add(al_increase);
        al_increase.setBounds(new Rectangle(new Point(650, 10), al_increase.getPreferredSize()));

        //---- bq_title ----
        bq_title.setText("\u8bf7\u5148\u9009\u62e9\u8868");
        bq_title.setFont(new Font("\u6977\u4f53", Font.BOLD, 24));
        contentPane.add(bq_title);
        bq_title.setBounds(20, 5, 620, 40);

        //======== rq_table ========
        {

            //---- bg_table ----
            bg_table.setFont(bg_table.getFont().deriveFont(bg_table.getFont().getStyle() & ~Font.ITALIC));
            rq_table.setViewportView(bg_table);
        }
        contentPane.add(rq_table);
        rq_table.setBounds(15, 50, 950, 460);

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar actionbar;
    private JButton al_password;
    private JButton al_staff;
    private JButton al_custom;
    private JButton al_goods;
    private JButton al_wages;
    private JPanel hSpacer1;
    private JLabel bq_id;
    private JTextField wbk_id;
    private JButton al_search;
    private JButton al_exit;
    private JButton al_delete;
    private JButton al_save;
    private JButton al_increase;
    private JLabel bq_title;
    private JScrollPane rq_table;
    private JTable bg_table;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private int n=0;
    private Vector<String> title;
    private Vector<Vector<Object>> datas;
}
