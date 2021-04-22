package sk.stuba.fei.uim.oop.button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyButtonQuit extends JButton implements ActionListener {

    public MyButtonQuit(String label){
        super(label);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            System.exit(0); //Quit game
    }
}
