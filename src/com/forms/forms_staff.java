/*
 * Created by JFormDesigner on Sat May 18 22:16:23 CST 2024
 */

package com.forms;

import java.awt.*;
import javax.swing.*;

/**
 * @author Administrator
 */
public class forms_staff extends JFrame {
    public forms_staff() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        textField3 = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        textField4 = new JTextField();
        label6 = new JLabel();
        textField5 = new JTextField();
        label7 = new JLabel();
        textField6 = new JTextField();
        label8 = new JLabel();
        textField7 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label9 = new JLabel();
        panel1 = new JPanel();
        label10 = new JLabel();

        //======== this ========
        setPreferredSize(new Dimension(380, 400));
        setResizable(false);
        setTitle("\u4e2a\u4eba\u754c\u9762");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5de5\u53f7");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(50, 99), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(80, 95, 100, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u59d3\u540d");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(50, 134), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(80, 194, 100, textField2.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(80, 128, 100, textField3.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u5e74\u9f84");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(50, 199), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u6027\u522b");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(50, 164), label5.getPreferredSize()));
        contentPane.add(textField4);
        textField4.setBounds(80, 227, 100, textField4.getPreferredSize().height);

        //---- label6 ----
        label6.setText("\u7535\u8bdd");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(50, 229), label6.getPreferredSize()));
        contentPane.add(textField5);
        textField5.setBounds(80, 161, 100, textField5.getPreferredSize().height);

        //---- label7 ----
        label7.setText("\u804c\u4f4d");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(50, 264), label7.getPreferredSize()));
        contentPane.add(textField6);
        textField6.setBounds(80, 260, 100, textField6.getPreferredSize().height);

        //---- label8 ----
        label8.setText("\u5165\u804c\u65e5\u671f");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(25, 299), label8.getPreferredSize()));
        contentPane.add(textField7);
        textField7.setBounds(80, 293, 100, textField7.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u67e5\u8be2\u5de5\u8d44");
        button1.setPreferredSize(new Dimension(120, 25));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(205, 260), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u6253\u5370\u5de5\u8d44\u6761");
        button2.setPreferredSize(new Dimension(120, 25));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(205, 295), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("\u8fd4\u56de");
        button3.setPreferredSize(new Dimension(60, 25));
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(300, 5), button3.getPreferredSize()));

        //---- label9 ----
        label9.setText("\u5458\u5de5\u4fe1\u606f");
        label9.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 28));
        contentPane.add(label9);
        label9.setBounds(new Rectangle(new Point(130, 35), label9.getPreferredSize()));

        //======== panel1 ========
        {
            panel1.setPreferredSize(new Dimension(120, 150));
            panel1.setBackground(new Color(0x999999));
            panel1.setMinimumSize(null);
            panel1.setMaximumSize(null);
            panel1.setLayout(null);

            //---- label10 ----
            label10.setText("\u7167\u7247");
            label10.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(label10);
            label10.setBounds(0, 0, 120, 150);

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
        panel1.setBounds(new Rectangle(new Point(205, 95), panel1.getPreferredSize()));

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
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField4;
    private JLabel label6;
    private JTextField textField5;
    private JLabel label7;
    private JTextField textField6;
    private JLabel label8;
    private JTextField textField7;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label9;
    private JPanel panel1;
    private JLabel label10;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
