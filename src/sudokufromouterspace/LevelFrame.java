/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokufromouterspace;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author jeanaguilar
 */
public class LevelFrame extends JFrame implements ActionListener {

    JMenuBar menu;
    JMenu menustrip, difficulty, help;
    JMenuItem about, instructions;// Menu items variables for help
    JMenuItem easy, medium, hard;// Menu items variables for game
    JMenuItem returnmenu, exit;
    JLabel title;
    JButton btneasy, btnclose, btnmedium, btnhard, btnreturn;
    Color plateado = new Color(204, 204, 204);
    Color red = new Color(159, 16, 16);
    image2 window = new image2();

    public LevelFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 100, 750, 550);
        window.setBorder(new EmptyBorder(5, 5, 5, 5));
        window.setLayout(new BorderLayout(0, 0));
        window.setLayout(null);
        setContentPane(window);
        setResizable(false);
        window.add(menuGUI());
        window.add(title());
        //Add buttons on window
        window.add(buttonEasy());
        window.add(buttonMedium());
        window.add(buttonHard());
        window.add(buttonClose());
        window.add(buttonReturn());

    }

    public JMenuBar menuGUI() {
        menu = new JMenuBar();
        menu.setBounds(0, 0, 750, 25);
        window.add(menu);
        menustrip = new JMenu("Menu");
        menustrip.setFont(new Font("Roboto", Font.BOLD, 16));
        menu.add(menustrip);
        difficulty = new JMenu("Nivel");
        difficulty.setFont(new Font("Roboto", Font.BOLD, 16));
        menu.add(difficulty);
        help = new JMenu("Ayuda");
        help.setFont(new Font("Roboto", Font.BOLD, 16));
        menu.add(help);

        //Add help values
        about = new JMenuItem("Acerca de");
        about.setFont(new Font("Roboto", Font.PLAIN, 16));
        about.addActionListener(this);
        help.add(about);

        instructions = new JMenuItem("Instrucciones");
        instructions.setFont(new Font("Roboto", Font.PLAIN, 16));
        instructions.addActionListener(this);
        help.add(instructions);

        //Add difficulty values
        easy = new JMenuItem("Facil");
        easy.setFont(new Font("Roboto", Font.PLAIN, 16));
        easy.addActionListener(this);
        difficulty.add(easy);

        medium = new JMenuItem("Medio");
        medium.setFont(new Font("Roboto", Font.PLAIN, 16));
        medium.addActionListener(this);
        difficulty.add(medium);

        hard = new JMenuItem("Difícil");
        hard.setFont(new Font("Roboto", Font.PLAIN, 16));
        hard.addActionListener(this);
        difficulty.add(hard);

        returnmenu = new JMenuItem("Regresar");
        returnmenu.setFont(new Font("Roboto", Font.PLAIN, 16));
        returnmenu.addActionListener(this);
        menustrip.add(returnmenu);

        exit = new JMenuItem("Salir");
        exit.setFont(new Font("Roboto", Font.PLAIN, 16));
        exit.addActionListener(this);
        menustrip.add(exit);

        return menu;

    }

    public JLabel title() {
        //Add title
        title = new JLabel("SUD-OKU™");
        title.setFont(new Font("THE AMAZING SPIDER-MAN", Font.BOLD, 100));
        String nm = null;
        title.setForeground(Color.getColor(nm, Color.white));
        title.setBounds(225, 5, 400, 200);
        title.setBorder(new EmptyBorder(5, 5, 5, 5));
        title.setLayout(new BorderLayout(0, 0));
        return title;
    }

    public JButton buttonEasy() {
//Add Buttons
        String nm = null;
        btneasy = new JButton("FACIL");
        btneasy.setFont(new Font("THE AMAZING SPIDER-MAN", Font.CENTER_BASELINE, 20));
        btneasy.setBounds(80, 200, 120, 45);
        btneasy.setForeground(Color.getColor(nm, red));
        btneasy.addActionListener(this);

        return btneasy;
    }

    public JButton buttonMedium() {
//Add Buttons
        String nm = null;
        btnmedium = new JButton("MEDIO");
        btnmedium.setFont(new Font("THE AMAZING SPIDER-MAN", Font.CENTER_BASELINE, 20));
        btnmedium.setBounds(80, 300, 120, 45);
        btnmedium.setForeground(Color.getColor(nm, red));
        btnmedium.addActionListener(this);

        return btnmedium;
    }

    public JButton buttonHard() {
//Add Buttons
        String nm = null;
        btnhard = new JButton("DIFICIL");
        btnhard.setFont(new Font("THE AMAZING SPIDER-MAN", Font.CENTER_BASELINE, 20));
        btnhard.setBounds(80, 400, 120, 45);
        btnhard.setForeground(Color.getColor(nm, red));
        btnhard.addActionListener(this);

        return btnhard;
    }

    public JButton buttonReturn() {
//Add Buttons
        String nm = null;
        btnreturn = new JButton("REGRESAR");
        btnreturn.setFont(new Font("THE AMAZING SPIDER-MAN", Font.CENTER_BASELINE, 20));
        btnreturn.setBounds(550, 250, 120, 45);
        btnreturn.setForeground(Color.getColor(nm, red));
        btnreturn.addActionListener(this);

        return btnreturn;
    }

    public JButton buttonClose() {
//Add Buttons
        String nm = null;
        btnclose = new JButton("CERRAR@");
        btnclose.setFont(new Font("THE AMAZING SPIDER-MAN", Font.CENTER_BASELINE, 20));
        btnclose.setBounds(550, 350, 120, 45);
        btnclose.setForeground(Color.getColor(nm, red));
        btnclose.addActionListener(this);

        return btnclose;
    }

    public int openEasyLevelFrame() {

        int easyLevel = JOptionPane.showConfirmDialog(null, "¿Desea comenzar una nueva partida en nivel fácil?", "Nivel Fácil Nuevo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/image/info1.png")));
        if (easyLevel == JOptionPane.YES_OPTION) {
            setVisible(false);
            SudokuGame jFrame = new SudokuGame();//"Frame2
            jFrame.setVisible(true);

        }
        return easyLevel;
    }

    public int openMediumLevelFrame() {

        int mediumLevel = JOptionPane.showConfirmDialog(null, "¿Desea comenzar una nueva partida en  nivel intermedio?", "Nivel Medio", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/image/info1.png")));
        if (mediumLevel == JOptionPane.YES_OPTION) {
            setVisible(false);
            SudokuGameMedium jFrame = new SudokuGameMedium();//"Frame2
            jFrame.setVisible(true);

        }
        return mediumLevel;
    }

    public int openHardLevelFrame() {

        int hardLevel = JOptionPane.showConfirmDialog(null, "¿Desea comenzar una nueva partida en  nivel difícil?", "Nivel Difícil", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/image/info1.png")));
        if (hardLevel == JOptionPane.YES_OPTION) {
            setVisible(false);
            SudokuGameHard jFrame = new SudokuGameHard();//"Frame2
            jFrame.setVisible(true);

        }
        return hardLevel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == about) {
            new SudokuFromOuterSpace().aboutDeveloper();
        }
        if (e.getSource() == instructions) {
            new SudokuFromOuterSpace().sudokuRules();
        }
        if (e.getSource() == btnclose) {
            new SudokuFromOuterSpace().exitProgram();
        }
        if (e.getSource() == exit) {
            new SudokuFromOuterSpace().exitProgram();
        }
        if (e.getSource() == btneasy) {
            openEasyLevelFrame();
        }
        if (e.getSource() == easy) {
            openEasyLevelFrame();
        }
        if (e.getSource() == medium) {
            openMediumLevelFrame();
        }
        if (e.getSource() == btnmedium) {
            openMediumLevelFrame();
        }
        if (e.getSource() == hard) {
            openHardLevelFrame();
        }
        if (e.getSource() == btnhard) {
            openHardLevelFrame();
        }
        if (e.getSource() == btnreturn) {
            int returnPrincipal = JOptionPane.showConfirmDialog(null, "¿Desea Regresar?", "Regresar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/image/info1.png")));
            if (returnPrincipal == JOptionPane.YES_OPTION) {
                SudokuFromOuterSpace ClassMain = new SudokuFromOuterSpace();
                ClassMain.returnPrincipalMenu();
                dispose();
            }
        }
        if (e.getSource() == returnmenu) {
            SudokuFromOuterSpace ClassMain = new SudokuFromOuterSpace();
            ClassMain.exitProgram();
        }

    }

}
