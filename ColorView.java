package LashonWilliams.project2;
    
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorView implements ActionListener, ColorObserver, ViewInterface{
    ColorModelInterface model;
    ControllerInterface controller;
    JFrame viewFrame;
    JPanel viewPanel;
    JFrame controlFrame;
    JPanel controlPanel;
    JLabel redLabel;
    JLabel blueLabel;
    JLabel greenLabel;
    JTextField redTextField;
    JTextField blueTextField;
    JTextField greenTextField;
    JButton setRedButton;
    JButton setBlueButton;
    JButton setGreenButton;
    JButton increaseRedButton;
    JButton decreaseRedButton;
    JButton increaseBlueButton;
    JButton decreaseBlueButton;
    JButton increaseGreenButton;
    JButton decreaseGreenButton;
    JTable table;
    JLabel hex;
    int gr;
    int bl;
    int re;
    String hextext;
  

    public ColorView(ControllerInterface controller, ColorModelInterface model) {	
	this.controller = controller;
	this.model = model;
	model.registerObserver((ColorObserver)this);	
    }
    
    public void createView() {
        viewFrame= new JFrame();     
        increaseRedButton= new JButton("+10");
        increaseRedButton.setSize(10,40);
        increaseRedButton.addActionListener(this);
        decreaseRedButton= new JButton("-10");
        decreaseRedButton.addActionListener(this);
        redTextField = new JTextField();
        setRedButton= new JButton("Set Red");
        setRedButton.addActionListener(this);
        redLabel= new JLabel("Red");
        
        increaseBlueButton= new JButton("+10");
        increaseBlueButton.addActionListener(this);
        decreaseBlueButton= new JButton("-10");
        decreaseBlueButton.addActionListener(this);
        blueTextField = new JTextField();
        blueLabel= new JLabel("Blue");
        setBlueButton= new JButton("Set Blue");
        setBlueButton.addActionListener(this);
        
        increaseGreenButton= new JButton("+10");
        increaseGreenButton.addActionListener(this);
        decreaseGreenButton= new JButton("-10");
        decreaseGreenButton.addActionListener(this);
        greenTextField= new JTextField();
        greenLabel= new JLabel("Green");
        setGreenButton= new JButton("Set Green");
        setGreenButton.addActionListener(this);
        
        viewPanel= new JPanel();
        viewPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        viewPanel.setLayout(new GridLayout(0,1));
        
        viewPanel.add(redLabel);
        viewPanel.add(increaseRedButton);
        viewPanel.add(decreaseRedButton);
        viewPanel.add(redTextField);
        viewPanel.add(setRedButton);
        
        viewPanel.add(greenLabel);
        viewPanel.add(increaseGreenButton);
        viewPanel.add(decreaseGreenButton);
        viewPanel.add(greenTextField);
        viewPanel.add(setGreenButton);
        
        viewPanel.add(blueLabel);
        viewPanel.add(increaseBlueButton);
        viewPanel.add(decreaseBlueButton);
        viewPanel.add(blueTextField);
        viewPanel.add(setBlueButton);
        
        table= new JTable();
        hextext= " ";
        hex= new JLabel(hextext);
        hex.setOpaque(true);
        hex.setBackground(Color.black);
        hex.setForeground(Color.white);
      
        viewPanel.add(table);
        viewPanel.add(hex);
          
        viewFrame.add(viewPanel,BorderLayout.CENTER);
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setTitle("View78");
        viewFrame.pack();
        viewFrame.setVisible(true);    
    }
  
    public void actionPerformed(ActionEvent event) {
	if (event.getSource() == increaseRedButton) {
            int redtemp= controller.getRed();
            if (redtemp >= 0 && redtemp <=255){
                controller.increaseRed();
                table.setBackground(new Color(re,gr,bl));
                Color your_color = new Color(redtemp,0,0);
                hextext = "Hex: "+Integer.toHexString(your_color.getRGB()).substring(2);
                hex.setBackground(new Color(redtemp,0,0));
                hex.setText(hextext);
            }  
            
            else{
                hex.setText("RGB values are out of range");
            }
         
	} else if (event.getSource() == increaseBlueButton) {
            bl= controller.getBlue();
            if (bl >= 0 && bl <=255){
                controller.increaseBlue();
                table.setBackground(new Color(re,gr,bl));
                int bluetemp= controller.getBlue();
                Color your_color = new Color(0,0,bluetemp);
                hextext = "#"+Integer.toHexString(your_color.getRGB()).substring(2);
                hex.setBackground(new Color(0,0,bluetemp));
                hex.setText(hextext);
            }    
            else{
                hex.setText("RGB values are out of range");
            }
	} else if (event.getSource() == increaseGreenButton) {
            controller.increaseGreen();
            gr=controller.getGreen();
            table.setBackground(new Color(re,gr,bl));
            int greentemp= controller.getGreen();
            Color your_color = new Color(0,greentemp,0);
            hextext = "#"+Integer.toHexString(your_color.getRGB()).substring(2);
            hex.setText(hextext);
            hex.setBackground(new Color(0,greentemp,0));
            
	} else if (event.getSource() == setRedButton) {
            int red = Integer.parseInt(redTextField.getText());
            if (red >=0 && red <= 255){
                controller.setRed(red);
                re=controller.getRed();
                table.setBackground(new Color(re,gr,bl));
                Color your_color = new Color(re,0,0);
                hextext = "#"+Integer.toHexString(your_color.getRGB()).substring(2);
                hex.setText(hextext);
                hex.setBackground(new Color(re,0,0));
            }
            else{
                hex.setText("RGB values are out of a range");
            }
	} else if (event.getSource() == setBlueButton) {
            int blue = Integer.parseInt(blueTextField.getText());
            if (blue >=0 && blue <= 255){
                controller.setBlue(blue);
                bl=controller.getBlue();
                table.setBackground(new Color(re,gr,bl));
                Color your_color = new Color(0,0,bl);
                hextext = "#"+Integer.toHexString(your_color.getRGB()).substring(2);
                hex.setText(hextext);
                hex.setBackground(new Color(0,0,bl));
            }
            else{
                hex.setText("RGB values are out of range");
            }
            
	} else if (event.getSource() == setGreenButton) {
            int green = Integer.parseInt(greenTextField.getText());
            if (green >=0 && green <= 255){
                controller.setGreen(green);
                gr=controller.getGreen();
                table.setBackground(new Color(re,gr,bl));
                Color your_color = new Color(0,gr,0);
                hextext = "#"+Integer.toHexString(your_color.getRGB()).substring(2);
                hex.setBackground(new Color(0,gr,0));
                hex.setText(hextext);
            }
            
            else{
                hex.setText("RGB values are out of range");
            }
	}
        else if (event.getSource() == decreaseRedButton) {
            controller.decreaseRed();
            re=controller.getRed();
            table.setBackground(new Color(re,gr,bl));
            Color your_color = new Color(re,0,0);
            hextext = "#"+Integer.toHexString(your_color.getRGB()).substring(2);
            hex.setBackground(new Color(re,0,0));
            hex.setText(hextext);
            
	} else if (event.getSource() == decreaseBlueButton) {
            controller.decreaseBlue();
            bl=controller.getBlue();
            table.setBackground(new Color(re,gr,bl));
            Color your_color = new Color(0,0,bl);
            hextext = "#"+Integer.toHexString(your_color.getRGB()).substring(2);
            hex.setBackground(new Color(0,0,bl));
            hex.setText(hextext);
            
	} else if (event.getSource() == decreaseGreenButton) {
            controller.decreaseGreen();
            gr=controller.getGreen();
            table.setBackground(new Color(re,gr,bl));
            hex.setBackground(new Color(0,gr,0));
            Color your_color = new Color(0,gr,0);
            hextext = "#"+Integer.toHexString(your_color.getRGB()).substring(2);
            hex.setBackground(new Color(0,gr,0));
            hex.setText(hextext);
	} 
    }

    public void updateGreen() {
        if (model != null) {
            int green = model.getGreen();
        }
    }
        
    public void updateBlue() {
        if (model != null) {
            int blue = model.getBlue();
        }
    }
        
    public void updateRed() {
        if (model != null) {
            int red = model.getRed();
        }
    }	
}
