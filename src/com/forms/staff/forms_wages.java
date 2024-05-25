/*
 * Created by JFormDesigner on Sun May 26 14:38:13 CST 2024
 */

package com.forms.staff;

import java.awt.event.*;
import com.database.operatetable.operatewages;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * @author Administrator
 */
public class forms_wages extends JFrame {
    public forms_wages() {
        initComponents();
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        hSpacer1 = new JPanel(null);
        bq_title = new JLabel();
        hSpacer2 = new JPanel(null);
        al_return = new JButton();
        rq_wages = new JScrollPane();
        bg_wages = new JTable();

        //======== this ========
        setPreferredSize(new Dimension(1000, 110));
        setResizable(false);
        setName("wages");
        setTitle("\u53cc\u96c4\u7269\u6d41");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {
            menuBar1.add(hSpacer1);

            //---- bq_title ----
            bq_title.setText("\u5de5      \u8d44      \u6761");
            bq_title.setFont(new Font("\u6977\u4f53", Font.BOLD, 20));
            menuBar1.add(bq_title);
            menuBar1.add(hSpacer2);

            //---- al_return ----
            al_return.setText("\u8fd4\u56de");
            al_return.addActionListener(e -> button2(e));
            menuBar1.add(al_return);
        }
        setJMenuBar(menuBar1);

        //======== rq_wages ========
        {
            rq_wages.setViewportView(bg_wages);
        }
        contentPane.add(rq_wages);
        rq_wages.setBounds(0, 0, 985, 55);

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
        Vector<Vector<Object>> datas = new Vector<>();
        datas.add(operatewages.readwages());
        Vector<String> title = new Vector<>();
        title.add("工号");
        title.add("姓名");
        title.add("基本工资");
        title.add("在职天数");
        title.add("应发工资");
        title.add("奖金");
        title.add("应扣工资");
        title.add("实发工资");
        title.add("备注");
        DefaultTableModel model = new DefaultTableModel(datas, title);
        bg_wages.setModel(model);
        JTableHeader header = bg_wages.getTableHeader();
        header.setReorderingAllowed(false);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JPanel hSpacer1;
    private JLabel bq_title;
    private JPanel hSpacer2;
    private JButton al_return;
    private JScrollPane rq_wages;
    private JTable bg_wages;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
