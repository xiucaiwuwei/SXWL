/*
 * Created by JFormDesigner on Sat May 18 14:18:04 CST 2024
 */

package com.forms;

import java.awt.*;
import javax.swing.*;

/**
 * @author Administrator
 */
public class forms_custom extends JFrame {
    public forms_custom() {
        initComponents();
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
        wbk_address = new JTextField();
        bq_notes = new JLabel();
        rq_notes = new JScrollPane();
        wbk_notes = new JTextArea();
        bq_photo = new JLabel();
        rq_paymentmethod = new JPanel();
        dx_payasyougo = new JRadioButton();
        dx_collectpayment = new JRadioButton();

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
        contentPane.add(al_previous);
        al_previous.setBounds(new Rectangle(new Point(495, 410), al_previous.getPreferredSize()));

        //---- al_next ----
        al_next.setText("\u4e0b\u4e00\u4ef6");
        al_next.setMaximumSize(null);
        al_next.setMinimumSize(null);
        al_next.setPreferredSize(new Dimension(75, 25));
        contentPane.add(al_next);
        al_next.setBounds(new Rectangle(new Point(580, 410), al_next.getPreferredSize()));

        //---- al_delete ----
        al_delete.setText("\u5220\u9664\u6b64\u8ba2\u5355");
        al_delete.setMaximumSize(null);
        al_delete.setMinimumSize(null);
        al_delete.setPreferredSize(new Dimension(110, 25));
        contentPane.add(al_delete);
        al_delete.setBounds(new Rectangle(new Point(160, 410), al_delete.getPreferredSize()));

        //---- al_exit ----
        al_exit.setText("\u9000\u51fa");
        al_exit.setMaximumSize(null);
        al_exit.setMinimumSize(null);
        al_exit.setPreferredSize(new Dimension(75, 25));
        contentPane.add(al_exit);
        al_exit.setBounds(new Rectangle(new Point(665, 410), al_exit.getPreferredSize()));

        //---- al_modify ----
        al_modify.setText("\u4fee\u6539");
        al_modify.setMaximumSize(null);
        al_modify.setMinimumSize(null);
        al_modify.setPreferredSize(new Dimension(75, 25));
        contentPane.add(al_modify);
        al_modify.setBounds(new Rectangle(new Point(410, 410), al_modify.getPreferredSize()));

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
            rq_mainbody.add(wbk_id);
            wbk_id.setBounds(86, 25, 400, wbk_id.getPreferredSize().height);

            //---- bq_name ----
            bq_name.setText("\u540d\u79f0");
            bq_name.setHorizontalAlignment(SwingConstants.RIGHT);
            rq_mainbody.add(bq_name);
            bq_name.setBounds(new Rectangle(new Point(50, 74), bq_name.getPreferredSize()));
            rq_mainbody.add(wbk_name);
            wbk_name.setBounds(85, 70, 150, wbk_name.getPreferredSize().height);

            //---- bq_number ----
            bq_number.setText("\u6570\u91cf");
            rq_mainbody.add(bq_number);
            bq_number.setBounds(305, 75, bq_number.getPreferredSize().width, 15);

            //---- wbk_number ----
            wbk_number.setMinimumSize(new Dimension(150, 25));
            rq_mainbody.add(wbk_number);
            wbk_number.setBounds(340, 70, 146, wbk_number.getPreferredSize().height);

            //---- bq_phone ----
            bq_phone.setText("\u8054\u7cfb\u7535\u8bdd");
            bq_phone.setHorizontalAlignment(SwingConstants.RIGHT);
            rq_mainbody.add(bq_phone);
            bq_phone.setBounds(new Rectangle(new Point(25, 112), bq_phone.getPreferredSize()));
            rq_mainbody.add(wbk_phone);
            wbk_phone.setBounds(85, 108, 150, wbk_phone.getPreferredSize().height);

            //---- bq_paymenttime ----
            bq_paymenttime.setText("\u4ed8\u6b3e\u65f6\u95f4");
            bq_paymenttime.setHorizontalAlignment(SwingConstants.RIGHT);
            rq_mainbody.add(bq_paymenttime);
            bq_paymenttime.setBounds(new Rectangle(new Point(25, 150), bq_paymenttime.getPreferredSize()));
            rq_mainbody.add(wbk_paymenttime);
            wbk_paymenttime.setBounds(86, 146, 150, wbk_paymenttime.getPreferredSize().height);

            //---- bq_deliverytime ----
            bq_deliverytime.setText("\u53d1\u8d27\u65f6\u95f4");
            rq_mainbody.add(bq_deliverytime);
            bq_deliverytime.setBounds(new Rectangle(new Point(280, 150), bq_deliverytime.getPreferredSize()));
            rq_mainbody.add(wbk_deliverytime);
            wbk_deliverytime.setBounds(340, 146, 146, wbk_deliverytime.getPreferredSize().height);

            //---- bq_address ----
            bq_address.setText("\u6536\u8d27\u5730\u5740");
            bq_address.setHorizontalAlignment(SwingConstants.RIGHT);
            rq_mainbody.add(bq_address);
            bq_address.setBounds(18, 190, 55, bq_address.getPreferredSize().height);
            rq_mainbody.add(wbk_address);
            wbk_address.setBounds(86, 186, 400, wbk_address.getPreferredSize().height);

            //---- bq_notes ----
            bq_notes.setText("\u5907\u6ce8");
            bq_notes.setHorizontalAlignment(SwingConstants.RIGHT);
            rq_mainbody.add(bq_notes);
            bq_notes.setBounds(new Rectangle(new Point(49, 230), bq_notes.getPreferredSize()));

            //======== rq_notes ========
            {
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
                rq_paymentmethod.add(dx_payasyougo);
                dx_payasyougo.setBounds(5, 0, 50, 20);

                //---- dx_collectpayment ----
                dx_collectpayment.setText("\u5230\u4ed8");
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
    private JTextField wbk_address;
    private JLabel bq_notes;
    private JScrollPane rq_notes;
    private JTextArea wbk_notes;
    private JLabel bq_photo;
    private JPanel rq_paymentmethod;
    private JRadioButton dx_payasyougo;
    private JRadioButton dx_collectpayment;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
