package binaryclockdemo;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class ClockBox extends JLabel {
	public ClockBox(){
		super.setSize(new Dimension(50,50));
		super.setPreferredSize(new Dimension(50,50));
		super.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}
