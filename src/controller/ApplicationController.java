package controller;

import javax.swing.JFrame;

import view.LoginJFrame;

public class ApplicationController {
    
    public static void main(String[] args) {
        
        JFrame frame = new LoginJFrame();
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
    
}
