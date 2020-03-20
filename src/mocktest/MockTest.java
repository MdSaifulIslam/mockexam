/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocktest;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Saiful-Islam
 */
public class MockTest {
    
    static QuestionFrame fm;

    public static void main(String[] args) {
        fm = new QuestionFrame();
        fm.setSize(600, 500);
        Rectangle winDim = fm.getBounds();
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        fm.setLocation((int) (screenDim.getWidth()
                - winDim.width) / 2, (int) (screenDim.getHeight()
                - winDim.height) / 2);
        fm.setIconImage(new ImageIcon("s.png").
                getImage());
        fm.setVisible(true);
        fm.setResizable(false);
        fm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                final  JDialog jd = new JDialog();
                jd.setModal(true);
                jd.setTitle("Mock Exam");
                JLabel msg;
                msg = new JLabel("Do you want to exit", JLabel.CENTER);
                final JButton b1= new JButton("ok");
                final JButton b2= new JButton("cancel");
                b1.addActionListener(new ActionListener() {
                    @Override
                    publiyc void actionPerformed(ActionEvent ae) {
                        System.exit(1);
                    }
                });
                b2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        jd.hide();
                    }
                });
                JPanel p= new JPanel();
                p.add(b1);
                p.add(b2);
                Container con = jd.getContentPane();
                con.add(msg, BorderLayout.NORTH);
                con.add(p, BorderLayout.SOUTH);
                jd.setSize(200,100);
                Rectangle winDim = jd.getBounds();
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        jd.setLocation((int) (screenDim.getWidth()
                - winDim.width) / 2, (int) (screenDim.getHeight()
                - winDim.height) / 2);
        jd.show();
            }
            
        });
    }
    
}
