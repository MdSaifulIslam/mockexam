/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocktest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author saiful
 */
public class Review extends JDialog{
    QuestionFrame qf= new QuestionFrame();
    private JButton qButton [] = new JButton[40];

    public Review(final QuestionFrame qf) {
        setTitle("review");
        setModal(true);
        this.qf=qf;
        Container con= getContentPane();
        JPanel pane= new JPanel();
        if(this.qf.maxQue<10){
            pane.setLayout(new GridLayout(2, 5));
        }
        if(this.qf.maxQue<20){
            pane.setLayout(new GridLayout(4, 5));
        }
        if(this.qf.maxQue<30){
            pane.setLayout(new GridLayout(6, 5));
        }
        if(this.qf.maxQue<40){
            pane.setLayout(new GridLayout(8, 5));
        }
        int j=0;
        for (int i = 0; i < this.qf.maxQue; i++) {
            j= i+1;
            qButton[i]=new JButton("Ques No: "+j+"/40");
            if(this.qf.ansOption[i][5]==true){
                qButton[i].setBackground(Color.red);
            }
            qButton[i].addActionListener(new ActionList());
            pane.add(qButton[i]);
        }
        JButton ok= new JButton("ok");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        con.add(pane, BorderLayout.CENTER);
        con.add(ok, BorderLayout.SOUTH);
        setSize(600,400);
        setVisible(true);
        
    }
    
    class ActionList implements ActionListener{
        int i;
        @Override
        public void actionPerformed(ActionEvent e) {
            String s= e.getActionCommand();
            if (s.length()==11) {
                s=s.substring(7,8);
            }
            else{
                s.substring(7,9);
            }
            i=new Integer(s).intValue();
            qf.quesNo=i;
            qf.makeQues(i);
        }
    }
    
}
