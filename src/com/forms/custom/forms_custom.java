/*
 * Created by JFormDesigner on Wed May 22 13:55:56 CST 2024
 */

package com.forms.custom;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

import com.database.operatetable.ReadTable;
import com.database.operatetable.UpdateTable;

public class forms_custom extends JFrame {
    public forms_custom() {
        initComponents();
    }

    private void al_return(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        this.setVisible(false);
    }

    private void al_save(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        if(wbk_account.getText().isEmpty()||wbk_name.getText().isEmpty() || wbk_password.getText().isEmpty() || wbk_phone.getText().isEmpty() || wbk_address1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "请填写完整信息");
        }
        else
        {
            data.set(0,wbk_account.getText());
            data.set(1,wbk_password.getText());
            data.set(2,wbk_name.getText());
            data.set(3,wbk_phone.getText());
            data.set(4,wbk_address1.getText());
            data.set(5,wbk_address2.getText());
            UpdateTable.UpdateCustom(data);
            UpdateTable.ModifyTemp(wbk_account.getText(),wbk_password.getText());
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        hSpacer1 = new JPanel(null);
        al_save = new JButton();
        al_return = new JButton();
        bq_title = new JLabel();
        bq_account = new JLabel();
        wbk_account = new JTextField();
        bq_password = new JLabel();
        wbk_password = new JTextField();
        bq_phone = new JLabel();
        wbk_phone = new JTextField();
        bq_address1 = new JLabel();
        wbk_address1 = new JTextField();
        bq_address2 = new JLabel();
        wbk_address2 = new JTextField();
        rq_profilepicture = new JPanel();
        bq_profilepicture = new JLabel();
        wbk_name = new JTextField();
        bq_name = new JLabel();

        //======== this ========
        setPreferredSize(new Dimension(430, 450));
        setResizable(false);
        setTitle("\u4fee\u6539\u4e2a\u4eba\u4fe1\u606f");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {
            menuBar1.add(hSpacer1);

            //---- al_save ----
            al_save.setText("\u4fdd\u5b58");
            al_save.setPreferredSize(new Dimension(80, 30));
            al_save.setMinimumSize(null);
            al_save.setMaximumSize(null);
            al_save.addActionListener(e -> al_save(e));
            menuBar1.add(al_save);

            //---- al_return ----
            al_return.setText("\u8fd4\u56de");
            al_return.setMinimumSize(null);
            al_return.setMaximumSize(null);
            al_return.setPreferredSize(new Dimension(80, 30));
            al_return.addActionListener(e -> al_return(e));
            menuBar1.add(al_return);
        }
        setJMenuBar(menuBar1);

        //---- bq_title ----
        bq_title.setText("\u4e2a    \u4eba    \u4fe1    \u606f");
        bq_title.setFont(new Font("\u6977\u4f53", Font.BOLD, 24));
        contentPane.add(bq_title);
        bq_title.setBounds(new Rectangle(new Point(85, 20), bq_title.getPreferredSize()));

        //---- bq_account ----
        bq_account.setText("\u7528\u6237\u540d");
        bq_account.setHorizontalTextPosition(SwingConstants.RIGHT);
        contentPane.add(bq_account);
        bq_account.setBounds(50, 75, bq_account.getPreferredSize().width, 15);

        //---- wbk_account ----
        wbk_account.setPreferredSize(new Dimension(120, 30));
        contentPane.add(wbk_account);
        wbk_account.setBounds(100, 65, 120, wbk_account.getPreferredSize().height);

        //---- bq_password ----
        bq_password.setText("\u5bc6\u7801");
        bq_password.setHorizontalTextPosition(SwingConstants.RIGHT);
        bq_password.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(bq_password);
        bq_password.setBounds(50, 119, 40, 20);

        //---- wbk_password ----
        wbk_password.setMaximumSize(null);
        wbk_password.setMinimumSize(null);
        wbk_password.setPreferredSize(new Dimension(120, 30));
        contentPane.add(wbk_password);
        wbk_password.setBounds(100, 114, 120, 30);

        //---- bq_phone ----
        bq_phone.setText("\u7535\u8bdd");
        bq_phone.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(bq_phone);
        bq_phone.setBounds(50, 215, 40, 18);

        //---- wbk_phone ----
        wbk_phone.setPreferredSize(new Dimension(120, 30));
        wbk_phone.setMinimumSize(null);
        wbk_phone.setMaximumSize(null);
        contentPane.add(wbk_phone);
        wbk_phone.setBounds(100, 212, 120, 30);

        //---- bq_address1 ----
        bq_address1.setText("\u6536\u8d27\u5730\u57401");
        bq_address1.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(bq_address1);
        bq_address1.setBounds(20, 262, 70, 20);

        //---- wbk_address1 ----
        wbk_address1.setMaximumSize(null);
        wbk_address1.setMinimumSize(null);
        wbk_address1.setPreferredSize(new Dimension(260, 30));
        contentPane.add(wbk_address1);
        wbk_address1.setBounds(100, 261, 260, 30);

        //---- bq_address2 ----
        bq_address2.setText("\u6536\u8d27\u5730\u57402");
        bq_address2.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(bq_address2);
        bq_address2.setBounds(20, 311, 70, 18);

        //---- wbk_address2 ----
        wbk_address2.setPreferredSize(new Dimension(260, 30));
        wbk_address2.setMinimumSize(null);
        wbk_address2.setMaximumSize(null);
        contentPane.add(wbk_address2);
        wbk_address2.setBounds(100, 310, 260, 30);

        //======== rq_profilepicture ========
        {
            rq_profilepicture.setPreferredSize(new Dimension(120, 120));
            rq_profilepicture.setBackground(new Color(0x999999));
            rq_profilepicture.setMaximumSize(null);
            rq_profilepicture.setMinimumSize(null);
            rq_profilepicture.setLayout(null);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < rq_profilepicture.getComponentCount(); i++) {
                    Rectangle bounds = rq_profilepicture.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = rq_profilepicture.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                rq_profilepicture.setMinimumSize(preferredSize);
                rq_profilepicture.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(rq_profilepicture);
        rq_profilepicture.setBounds(new Rectangle(new Point(235, 65), rq_profilepicture.getPreferredSize()));

        //---- bq_profilepicture ----
        bq_profilepicture.setText("\u5934\u50cf");
        contentPane.add(bq_profilepicture);
        bq_profilepicture.setBounds(new Rectangle(new Point(280, 195), bq_profilepicture.getPreferredSize()));

        //---- wbk_name ----
        wbk_name.setPreferredSize(new Dimension(120, 30));
        wbk_name.setMinimumSize(null);
        wbk_name.setMaximumSize(null);
        contentPane.add(wbk_name);
        wbk_name.setBounds(100, 163, 120, 30);

        //---- bq_name ----
        bq_name.setText("\u59d3\u540d");
        bq_name.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(bq_name);
        bq_name.setBounds(50, 168, 40, 18);

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
        for (int i = 0; i < ReadTable.QueryCustom(ReadTable.ReadTemporary().get(0)).size(); i++) {
            data.add(String.valueOf(ReadTable.QueryCustom(ReadTable.ReadTemporary().get(0)).get(i)));
        }
        data.add(String.valueOf(ReadTable.ReadTemporary().get(0)));
        wbk_account.setText(data.get(0));
        wbk_password.setText(data.get(1));
        wbk_name.setText(data.get(2));
        wbk_phone.setText(data.get(3));
        wbk_address1.setText(data.get(4));
        wbk_address2.setText(data.get(5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JPanel hSpacer1;
    private JButton al_save;
    private JButton al_return;
    private JLabel bq_title;
    private JLabel bq_account;
    private JTextField wbk_account;
    private JLabel bq_password;
    private JTextField wbk_password;
    private JLabel bq_phone;
    private JTextField wbk_phone;
    private JLabel bq_address1;
    private JTextField wbk_address1;
    private JLabel bq_address2;
    private JTextField wbk_address2;
    private JPanel rq_profilepicture;
    private JLabel bq_profilepicture;
    private JTextField wbk_name;
    private JLabel bq_name;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private Vector<String> data = new Vector<>();
}
