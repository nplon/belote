package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Constant;
import controler.command.Command;

public class UiButton extends JPanel implements MouseListener{

	private static final long serialVersionUID = 5770097659653586543L;
	JLabel content;
	Command command;
	String action;
	
	public UiButton(Command cmd, String action) {
		super();
		//this.uiControler = uiControler;
		this.action = action;
		content = new JLabel();
		content.setIcon(new ImageIcon(Constant.UISOURCE  + action +".png"));
		this.addMouseListener(this);
		this.add(content);
		this.command = cmd;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		command.execute();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public JLabel getContent() {
		return content;
	}

	public void setContent(JLabel content) {
		this.content = content;
	}
	
}
