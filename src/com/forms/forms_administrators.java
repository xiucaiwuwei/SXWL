/*
 * Created by JFormDesigner on Sat May 18 09:20:46 CST 2024
 */

package com.forms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Administrator
 */
public class forms_administrators extends JFrame {
    public forms_administrators() {
        initComponents();
    }

    private void bg_passwork(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        forms_modify modify = new forms_modify();
        modify.setVisible(true);
    }

    private void bg_exit(ActionEvent e) {
        // TODO add your code here
        System.out.println(e.getActionCommand());
        System.exit(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        actionbar = new JMenuBar();
        setup = new JMenu();
        bg_passwork = new JMenuItem();
        bg_exit = new JMenuItem();

        //======== this ========
        setTitle("\u53cc\u96c4\u7269\u6d41");
        setName("administrators");
        setPreferredSize(new Dimension(1000, 600));
        setMinimumSize(null);
        setMaximumSize(null);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== actionbar ========
        {

            //======== setup ========
            {
                setup.setText("\u8bbe\u7f6e");

                //---- bg_passwork ----
                bg_passwork.setText("\u4fee\u6539\u5bc6\u7801");
                bg_passwork.addActionListener(e -> bg_passwork(e));
                setup.add(bg_passwork);

                //---- bg_exit ----
                bg_exit.setText("\u9000\u51fa\u7cfb\u7edf");
                bg_exit.addActionListener(e -> bg_exit(e));
                setup.add(bg_exit);
            }
            actionbar.add(setup);
        }
        setJMenuBar(actionbar);

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
    private JMenuBar actionbar;
    private JMenu setup;
    private JMenuItem bg_passwork;
    private JMenuItem bg_exit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
