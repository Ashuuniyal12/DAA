package com.JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vote extends JFrame implements ActionListener {
    JLabel l1, l2;
    JTextField t1 ,t2, t3;
    JRadioButton r1 , r2;
    ButtonGroup bg;
    Button b;

    Vote(){
        l1  = new JLabel("Name");
        t1 =new JTextField(40);
        l2 = new JLabel("Age");
        t2 = new JTextField(10);
        t3 = new JTextField(70);
        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");
        b = new Button("SUBMIT");

        setLayout(new FlowLayout());

        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        b.addActionListener(this);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(r1);
        add(r2);
        add(b);
        add(t3);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        Vote v = new Vote();
        v.setSize(400,300);
        v.setVisible(true);
    }
}


