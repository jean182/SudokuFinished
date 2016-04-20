/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokufromouterspace;

/**
 *
 * @author jeanaguilar
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

public class SudokuFromOuterSpace extends JFrame implements ActionListener {

    JMenuBar menu;
    JMenu game, help;
    JMenuItem about, instructions;// Menu items variables for help
    JMenuItem newgame, exit;// Menu items variables for game
    JLabel title;
    JButton btnplay, btnclose, btncorrect, btnsave, btnresolve;
    Color plateado = new Color(204, 204, 204);
    Color red = new Color(159, 0, 0);
    JTabbedPane header; 
    image window = new image();

    public static void main(String[] args) {
        // TODO code application logic here
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SudokuFromOuterSpace frame = new SudokuFromOuterSpace();
                    frame.setVisible(true);
                    frame.setTitle("Sudoku");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SudokuFromOuterSpace() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 500);
        window.setBorder(new EmptyBorder(5, 5, 5, 5));
        window.setLayout(new BorderLayout(0, 0));
        window.setLayout(null);
        setContentPane(window);
        setResizable(false);
        window.add(menuGUI());
        window.add(title());
        //Add buttons on window
        window.add(buttonPlay());
        window.add(buttonClose());
    }
    
    
   

    public JMenuBar menuGUI() {
        menu = new JMenuBar();
        menu.setBounds(0, 0, 750, 25);
        window.add(menu);
        game = new JMenu("Juego");
        game.setFont(new Font("Roboto", Font.BOLD, 16));
        menu.add(game);
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

        //Add game values
        newgame = new JMenuItem("Juego Nuevo");
        newgame.setFont(new Font("Roboto", Font.PLAIN, 16));
        newgame.addActionListener(this);
        game.add(newgame);

        exit = new JMenuItem("Salir");
        exit.setFont(new Font("Roboto", Font.PLAIN, 16));
        exit.addActionListener(this);
        game.add(exit);

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

    public JButton buttonPlay() {
//Add Buttons
        String nm = null;
        btnplay = new JButton("JUGAR");
        btnplay.setFont(new Font("THE AMAZING SPIDER-MAN", Font.CENTER_BASELINE, 20));
        btnplay.setBounds(155, 380, 120, 45);
        btnplay.setForeground(Color.getColor(nm, red));
        btnplay.addActionListener(this);

        return btnplay;
    }

    public JButton buttonClose() {
//Add Buttons
        String nm = null;
        btnclose = new JButton("CERRAR@");
        btnclose.setFont(new Font("THE AMAZING SPIDER-MAN", Font.CENTER_BASELINE, 20));
        btnclose.setBounds(475, 380, 120, 45);
        btnclose.setForeground(Color.getColor(nm, red));
        btnclose.addActionListener(this);

        return btnclose;
    }

    public void sudokuRules() {
        JOptionPane.showMessageDialog(null, "Este juego está compuesto por una cuadrícula de 9x9 casillas, dividida en regiones de 3x3 casillas. "
                + "\nHay que completar las casillas vacías con dígitos del 1 al 9 sin que se repitan por fila, columna o región.\n"
                + "\n"
                + "Reglas:\n"
                + "\n"
                + "Regla 1: Hay que completar las casillas vacías con un solo número del 1 al 9.\n"
                + "\n"
                + "Regla 2: En una misma fila no puede haber números repetidos.\n"
                + "\n"
                + "Regla 3: En una misma columna no puede haber números repetidos.\n"
                + "\n"
                + "Regla 4: En una misma región no puede haber números repetidos.\n"
                + "\n"
                + "Regla 5: La solución de un sudoku es única. ", "Instrucciones:", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/image/info1.png")));

    }

    public void aboutDeveloper() {

        JOptionPane.showMessageDialog(null, "Sudoku v1.0 \nEste juego fue desarollado por: \nJean Aguilar \nRodiney Granados \nSebastian Alfaro ", "Acerca de: ", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/image/spideyface.png")));

    }

    public void openLevelFrame() {
        LevelFrame jFrame = new LevelFrame();//"Frame2
        jFrame.setVisible(true);
        setVisible(false);
    }

    public void exitProgram() {
        int confirmDialog = JOptionPane.showConfirmDialog(null, "¿Desea Salir?", "Salida", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/image/exit.png")));
        if (confirmDialog == JOptionPane.YES_OPTION) {
            System.exit(0);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

    }

    public void returnPrincipalMenu() {
      
            SudokuFromOuterSpace jFrame = new SudokuFromOuterSpace();//"Frame2
            jFrame.setVisible(true);

        

    }

    public void returnLevelMenu() {

        
            LevelFrame jFrame = new LevelFrame();//"Frame2
            jFrame.setVisible(true);

        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == about) {
            aboutDeveloper();
        }
        if (e.getSource() == instructions) {
            sudokuRules();
        }
        if (e.getSource() == btnclose) {
            exitProgram();
        }
        if (e.getSource() == exit) {
            exitProgram();

        }
        if (e.getSource() == btnplay) {
            openLevelFrame();
        }
        if (e.getSource() == newgame) {
            openLevelFrame();
        }

    }

}
