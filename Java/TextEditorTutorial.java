import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;

@SuppressWarnings("serial")
public class TextEditorTutorial extends JFrame implements ActionListener{
	
	private Scanner scan;
	private JTextArea textArea = new JTextArea();
    private JScrollPane areaScrollPane;
    private JMenuBar menuBar = new JMenuBar();
    
    private JMenu file = new JMenu();
    private JMenu edit = new JMenu();
    private JMenu help = new JMenu();
    
    //for file menu
    private JMenuItem openFile = new JMenuItem();
    private JMenuItem saveFile = new JMenuItem();
    private JMenuItem newFile = new JMenuItem();
    //for edit menu
    private JMenuItem cut = new JMenuItem(new DefaultEditorKit.CutAction());
    private JMenuItem copy = new JMenuItem(new DefaultEditorKit.CopyAction());
    private JMenuItem paste = new JMenuItem(new DefaultEditorKit.PasteAction());
    //for help menu
    private JMenuItem about = new JMenuItem();
    
    public TextEditorTutorial() {
    	this.setSize(800, 400);
        this.setTitle("ZedCoder Notepad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        this.textArea.setDragEnabled(true);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(textArea);
        this.areaScrollPane = new JScrollPane(textArea);
        this.areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.areaScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.getContentPane().add(areaScrollPane);
 
        this.setJMenuBar(this.menuBar);
        this.menuBar.add(this.file);
        this.menuBar.add(this.edit);
        this.menuBar.add(this.help);
 
        this.file.setText("File");
        this.edit.setText("Edit");
        this.help.setText("Help");
 
        this.openFile.setText("Open");
        this.openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        this.openFile.addActionListener(this);
        this.openFile.setMnemonic(KeyEvent.VK_O);       
 
        this.saveFile.setText("Save");
        this.saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        this.saveFile.addActionListener(this);
        this.saveFile.setMnemonic(KeyEvent.VK_S);
        
        this.newFile.setText("New");
        this.newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        this.newFile.addActionListener(this);
        this.newFile.setMnemonic(KeyEvent.VK_N);
        
        this.cut.setText("Cut");
        this.cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        this.cut.setMnemonic(KeyEvent.VK_T);
 
        this.copy.setText("Copy");
        this.copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        this.copy.setMnemonic(KeyEvent.VK_C);
        this.copy.addActionListener(this);
 
        this.paste.setText("Paste");
        this.paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        this.paste.setMnemonic(KeyEvent.VK_P);
        this.paste.addActionListener(this);
 
        this.about.setText("Author");
        this.about.addActionListener(this);
        
        this.file.add(this.openFile);
        this.file.add(this.saveFile);
        this.file.add(this.newFile);
        
        this.edit.add(this.cut);
        this.edit.add(this.copy);
        this.edit.add(this.paste);
        
        this.help.add(this.about);
    }

	 public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == this.openFile) {
	            JFileChooser open = new JFileChooser();
	            int option = open.showOpenDialog(this);
	            if (option == JFileChooser.APPROVE_OPTION) {
	                this.textArea.setText("");
	                try {
	                    scan = new Scanner(new FileReader(open
	                            .getSelectedFile().getPath()));
	                    while (scan.hasNext())
	                        this.textArea.append(scan.nextLine() + "\n");
	                } catch (Exception ex) {
	                    System.out.println(ex.getMessage());
	                }
	            }
	        }
	 
	        else if (e.getSource() == this.saveFile) {
	            JFileChooser save = new JFileChooser();
	            int option = save.showSaveDialog(this);
	            if (option == JFileChooser.APPROVE_OPTION) {
	                try {
	                    BufferedWriter out = new BufferedWriter(new FileWriter(save
	                            .getSelectedFile().getPath()));
	                    out.write(this.textArea.getText());
	                    out.close();
	                } catch (Exception ex) {
	                    System.out.println(ex.getMessage());
	                }
	            }
	        }
	 
	        else if (e.getSource() == this.newFile) {
	            Object[] options = { "Save", "Don't Save"};
	            int button = JOptionPane.showOptionDialog(null,
	                    "Do you want to save changes to " + getTitle(), "Notepad",
	                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
	                    null, options, options[0]);
	            if (button == 0) {
	                JFileChooser newFile = new JFileChooser();
	                int option = newFile.showSaveDialog(this);
	                if (option == JFileChooser.APPROVE_OPTION) {
	                    try {
	                        BufferedWriter out = new BufferedWriter(new FileWriter(
	                                newFile.getSelectedFile().getPath()));
	                        out.write(this.textArea.getText());
	                        out.close();
	                    } catch (Exception ex) {
	                        System.out.println(ex.getMessage());
	                    }
	                }
	            } else if (button == 1) {
	                textArea.setText(null);
	            } 
	        } else if (e.getSource() == this.about) {
	            JOptionPane.showMessageDialog(null, "Created by ZedCoder (Seda Kunda) Copyright 2017.");
		}
	}
	 public static void main (String args[]) {
			new TextEditorTutorial().setVisible(true);
		}
}
