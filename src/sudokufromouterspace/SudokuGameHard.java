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
import static java.awt.Color.black;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public final class SudokuGameHard extends JFrame implements ActionListener, KeyListener, MouseListener, FocusListener {

    image window = new image();
    JMenuBar menu;
    JMenu game, help;
    JMenuItem about, instructions;// Menu items variables for help
    JMenuItem pauseGame, loadGame, exit;// Menu items variables for game
    JLabel title;
    JButton btnPlay, btnClose, btnLoad, btnSave, btnResolve, btnCheck, btnreturn;
    JPanel jpSudokuPanel = new JPanel();
    JPanel[][] sudokuMatrix = new JPanel[9][9];
    JLabel labelPanel;
    int[][] matrix
            = {{4, 8, 3, 9, 2, 1, 6, 5, 7},
            {9, 6, 7, 3, 4, 5, 8, 2, 1},
            {2, 5, 1, 8, 7, 6, 4, 9, 3},
            {5, 4, 8, 1, 3, 2, 9, 7, 6},
            {7, 2, 9, 5, 6, 4, 1, 3, 8},
            {1, 3, 6, 7, 9, 8, 2, 4, 5},
            {3, 7, 2, 6, 8, 9, 5, 1, 4},
            {8, 1, 4, 2, 5, 3, 7, 6, 9},
            {6, 9, 5, 4, 1, 7, 3, 8, 2}};
    Color red = new Color(159, 0, 0);
    String nm = null;
    int rows = 9;
    int columns = 9;

    public SudokuGameHard() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(200, 100, 750, 650);
        window.setBorder(new EmptyBorder(5, 5, 5, 5));
        window.setLayout(new BorderLayout(0, 0));
        window.setLayout(null);
        setContentPane(window);
        setResizable(false);
        window.add(menuGUI());
        window.add(buttonPlay());
        window.add(buttonLoad());
        window.add(buttonResolve());
        window.add(buttonSave());
        window.add(buttonReturn());
        window.add(buttonClose());
        window.add(buttonCheck());
        window.add(createPanelMatrix(sudokuPanel()));
        fillMatrixWithBasicSudoku();
        //resultOfGame(checkSudokuStatus(matrix));

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
        exit = new JMenuItem("Salir");
        exit.setFont(new Font("Roboto", Font.PLAIN, 16));
        exit.addActionListener(this);
        game.add(exit);

        return menu;

    }

    public JButton buttonPlay() {
        btnPlay = new JButton("JUGAR");
        btnPlay.setFont(new Font("THE AMAZING SPIDER-MAN", Font.CENTER_BASELINE, 20));
        btnPlay.setBounds(20, 50, 120, 45);
        btnPlay.setForeground(Color.getColor(nm, red));
        btnPlay.addActionListener(this);

        return btnPlay;
    }

    public JButton buttonLoad() {
        btnLoad = new JButton("CARGAR");
        btnLoad.setFont(new Font("THE AMAZING SPIDER-MAN", Font.CENTER_BASELINE, 20));
        btnLoad.setBounds(20, 183, 120, 45);
        btnLoad.setForeground(Color.getColor(nm, red));
        btnLoad.addActionListener(this);

        return btnLoad;
    }

    public JButton buttonSave() {
        btnSave = new JButton("µGUARDAR");
        btnSave.setFont(new Font("THE AMAZING SPIDER-MAN", Font.CENTER_BASELINE, 20));
        btnSave.setBounds(20, 316, 120, 45);
        btnSave.setForeground(Color.getColor(nm, red));
        btnSave.addActionListener(this);

        return btnSave;
    }

    public JButton buttonResolve() {
        btnResolve = new JButton("RESOLVER");
        btnResolve.setFont(new Font("THE AMAZING SPIDER-MAN", Font.CENTER_BASELINE, 20));
        btnResolve.setBounds(20, 449, 120, 45);
        btnResolve.setForeground(Color.getColor(nm, red));
        btnResolve.addActionListener(this);

        return btnResolve;
    }

    public JButton buttonReturn() {
        btnreturn = new JButton("REGRESAR");
        btnreturn.setFont(new Font("THE AMAZING SPIDER-MAN", Font.CENTER_BASELINE, 20));
        btnreturn.setBounds(350, 550, 120, 45);
        btnreturn.setForeground(Color.getColor(nm, red));
        btnreturn.addActionListener(this);

        return btnreturn;
    }

    public JButton buttonClose() {
        btnClose = new JButton("CERRAR@");
        btnClose.setFont(new Font("THE AMAZING SPIDER-MAN", Font.CENTER_BASELINE, 20));
        btnClose.setBounds(500, 550, 120, 45);
        btnClose.setForeground(Color.getColor(nm, red));
        btnClose.addActionListener(this);

        return btnClose;
    }

    public JButton buttonCheck() {
        btnCheck = new JButton("REVISAR@");
        btnCheck.setFont(new Font("THE AMAZING SPIDER-MAN", Font.CENTER_BASELINE, 20));
        btnCheck.setBounds(200, 550, 120, 45);
        btnCheck.setForeground(Color.getColor(nm, red));
        btnCheck.addActionListener(this);

        return btnCheck;
    }

    public JPanel sudokuPanel() {
        jpSudokuPanel.setBounds(200, 50, 500, 450);
        jpSudokuPanel.setLayout(new GridLayout(9, 9, 5, 5));
        jpSudokuPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jpSudokuPanel.setBackground(black);
        jpSudokuPanel.setVisible(true);

        return jpSudokuPanel;
    }

    public JPanel createPanelMatrix(JPanel sudokuPanel) {
        for (int r = 0; r < sudokuMatrix.length; r++) {

            for (int c = 0; c < sudokuMatrix[0].length; c++) {

                sudokuMatrix[r][c] = new JPanel();//se un nuevo panel por posicion

                sudokuMatrix[r][c].setBorder(BorderFactory.createLineBorder(Color.black));//borde del panel  
                labelPanel = new JLabel("");
                labelPanel.setFont(new Font("Roboto", Font.BOLD, 22));
                sudokuMatrix[r][c].add(labelPanel);
                sudokuMatrix[r][c].addMouseListener(this);
                sudokuMatrix[r][c].addKeyListener(this);
                sudokuPanel.add(sudokuMatrix[r][c]);
                if ((r / 3 + c / 3) % 2 == 0) {

                    sudokuMatrix[r][c].setBackground(Color.getColor(nm, red));

                } else {

                    sudokuMatrix[r][c].setBackground(Color.white);
                }

            }
        }
        return sudokuPanel;
    }

    public void fillMatrixWithBasicSudoku() {

        labelPanel = (JLabel) sudokuMatrix[1][1].getComponent(0);
        labelPanel.setText("" + matrix[1][1]);
        sudokuMatrix[1][1].add(labelPanel);
        sudokuMatrix[1][1].setEnabled(false);

        labelPanel = (JLabel) sudokuMatrix[2][2].getComponent(0);
        labelPanel.setText("" + matrix[2][2]);
        sudokuMatrix[2][2].add(labelPanel);
        sudokuMatrix[2][2].setEnabled(false);

        labelPanel = (JLabel) sudokuMatrix[2][3].getComponent(0);
        labelPanel.setText("" + matrix[2][3]);
        sudokuMatrix[2][3].add(labelPanel);
        sudokuMatrix[2][3].setEnabled(false);

        labelPanel = (JLabel) sudokuMatrix[0][5].getComponent(0);
        labelPanel.setText("" + matrix[0][5]);
        sudokuMatrix[0][5].add(labelPanel);
        sudokuMatrix[0][5].setEnabled(false);

        labelPanel = (JLabel) sudokuMatrix[0][8].getComponent(0);
        labelPanel.setText("" + matrix[0][8]);
        sudokuMatrix[0][8].add(labelPanel);
        sudokuMatrix[0][8].setEnabled(false);

        labelPanel = (JLabel) sudokuMatrix[2][7].getComponent(0);
        labelPanel.setText("" + matrix[2][7]);
        sudokuMatrix[2][7].add(labelPanel);
        sudokuMatrix[2][7].setEnabled(false);

        labelPanel = (JLabel) sudokuMatrix[3][1].getComponent(0);
        labelPanel.setText("" + matrix[3][1]);
        sudokuMatrix[3][1].add(labelPanel);
        sudokuMatrix[3][1].setEnabled(false);

        labelPanel = (JLabel) sudokuMatrix[4][0].getComponent(0);
        labelPanel.setText("" + matrix[4][0]);
        sudokuMatrix[4][0].add(labelPanel);
        sudokuMatrix[4][0].setEnabled(false);

        labelPanel = (JLabel) sudokuMatrix[3][3].getComponent(0);
        labelPanel.setText("" + matrix[3][3]);
        sudokuMatrix[3][3].add(labelPanel);
        sudokuMatrix[3][3].setEnabled(false);

        labelPanel = (JLabel) sudokuMatrix[5][5].getComponent(0);
        labelPanel.setText("" + matrix[5][5]);
        sudokuMatrix[5][5].add(labelPanel);
        sudokuMatrix[5][5].setEnabled(false);

        labelPanel = (JLabel) sudokuMatrix[4][8].getComponent(0);
        labelPanel.setText("" + matrix[4][8]);
        sudokuMatrix[4][8].add(labelPanel);
        sudokuMatrix[4][8].setEnabled(false);

        labelPanel = (JLabel) sudokuMatrix[4][6].getComponent(0);
        labelPanel.setText("" + matrix[4][6]);
        sudokuMatrix[4][6].add(labelPanel);
        sudokuMatrix[4][6].setEnabled(false);

        labelPanel = (JLabel) sudokuMatrix[8][0].getComponent(0);
        labelPanel.setText("" + matrix[8][0]);
        sudokuMatrix[8][0].add(labelPanel);
        sudokuMatrix[8][0].setEnabled(false);

        labelPanel = (JLabel) sudokuMatrix[6][1].getComponent(0);
        labelPanel.setText("" + matrix[6][1]);
        sudokuMatrix[6][1].add(labelPanel);
        sudokuMatrix[6][1].setEnabled(false);

        labelPanel = (JLabel) sudokuMatrix[6][4].getComponent(0);
        labelPanel.setText("" + matrix[6][4]);
        sudokuMatrix[6][4].add(labelPanel);
        sudokuMatrix[6][4].setEnabled(false);

        labelPanel = (JLabel) sudokuMatrix[7][3].getComponent(0);
        labelPanel.setText("" + matrix[7][3]);
        sudokuMatrix[7][3].add(labelPanel);
        sudokuMatrix[7][3].setEnabled(false);

        labelPanel = (JLabel) sudokuMatrix[8][8].getComponent(0);
        labelPanel.setText("" + matrix[8][8]);
        sudokuMatrix[8][8].add(labelPanel);
        sudokuMatrix[8][8].setEnabled(false);

        labelPanel = (JLabel) sudokuMatrix[6][6].getComponent(0);
        labelPanel.setText("" + matrix[6][6]);
        sudokuMatrix[6][6].add(labelPanel);
        sudokuMatrix[6][6].setEnabled(false);
        /* for (int i = 0; i < sudokuMatrix.length; i++) {

            for (int j = 0; j < sudokuMatrix[0].length; j++) {

                if (matrix[i][j] == 2) {
                    labelPanel = (JLabel) sudokuMatrix[i][j].getComponent(0);
                    labelPanel.setText("" + matrix[i][j]);
                    sudokuMatrix[i][j].add(labelPanel);
                    sudokuMatrix[i][j].setEnabled(false);

                }

            }

        }*/
    }

    public boolean checkSudokuStatus(int[][] grid) {
        for (int i = 0; i < 9; i++) {

            int[] row = new int[9];
            int[] square = new int[9];
            int[] column = grid[i].clone();

            for (int j = 0; j < 9; j++) {
                row[j] = grid[j][i];
                square[j] = grid[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
            }
            if (!(validate(column) && validate(row) && validate(square))) {
                return false;
            }
        }
        return true;
    }

    public boolean validate(int[] check) {
        int i = 0;
        Arrays.sort(check);
        for (int number : check) {
            if (number != ++i) {
                return false;
            }
        }
        return true;
    }

    private void resultOfGame(boolean result) {
        if (result == true) {
            JOptionPane.showMessageDialog(null, "Has Ganado", "Felicidades: ", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/image/spideydance.gif")));

        } else {
            JOptionPane.showMessageDialog(null, "", "Perdiste: ", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/image/gameover.gif")));

        }

    }

    public void validateSudoku() {

        for (int r = 0; r < sudokuMatrix.length; r++) {
            for (int c = 0; c < sudokuMatrix.length; c++) {
                JLabel textInput = (JLabel) sudokuMatrix[r][c].getComponent(0);

                if (!textInput.getText().equals("")) {

                    int validate = Integer.parseInt(textInput.getText());
                    if (validate == matrix[r][c]) {

                        sudokuMatrix[r][c].setEnabled(false);
                    } else if (validate != matrix[r][c]) {

                        sudokuMatrix[r][c].setBackground(Color.YELLOW);
                        sudokuMatrix[r][c].setEnabled(true);

                    }
                }
            }
        }
    }

    public void resolveSudoku() {
        int confirmDialogResolve = JOptionPane.showConfirmDialog(null, "¿Esta Seguro que desea resolver el juego? \nEl juego terminara.", "Resolver", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/image/info1.png")));
        if (confirmDialogResolve == JOptionPane.YES_OPTION) {
            for (int r = 0; r < sudokuMatrix.length; r++) {
                for (int c = 0; c < sudokuMatrix.length; c++) {
                    labelPanel = (JLabel) sudokuMatrix[r][c].getComponent(0);
                    labelPanel.setText("" + matrix[r][c]);
                    sudokuMatrix[r][c].add(labelPanel);
                    sudokuMatrix[r][c].setEnabled(false);
                    if ((r / 3 + c / 3) % 2 == 0) {

                        sudokuMatrix[r][c].setBackground(Color.getColor(nm, red));

                    } else {

                        sudokuMatrix[r][c].setBackground(Color.white);
                    }

                }
            }

        }

    }

    public int[][] MatrixToSave() {
        int validate;
        int[][] savedmatrix = new int[9][9];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                JLabel textInput = (JLabel) sudokuMatrix[r][c].getComponent(0);

                if (!textInput.getText().equals("")) {
                    validate = Integer.parseInt(textInput.getText());

                    savedmatrix[r][c] = validate;

                }

            }
        }

        return savedmatrix;
    }

    public void startNewGame() {
        int confirmDialogBtnPlay = JOptionPane.showConfirmDialog(null, "¿Esta Seguro que desea comenzar una nueva partida? \nEl juego terminara y se perderan los cambios no guardados.", "Juego Nuevo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/image/info1.png")));
        if (confirmDialogBtnPlay == JOptionPane.YES_OPTION) {
            for (int r = 0; r < sudokuMatrix.length; r++) {

                for (int c = 0; c < sudokuMatrix[0].length; c++) {
                    labelPanel = (JLabel) sudokuMatrix[r][c].getComponent(0);
                    labelPanel.setText("");
                    sudokuMatrix[r][c].setEnabled(true);
                    if ((r / 3 + c / 3) % 2 == 0) {

                        sudokuMatrix[r][c].setBackground(Color.getColor(nm, red));

                    } else {

                        sudokuMatrix[r][c].setBackground(Color.white);
                    }
                }

            }
            fillMatrixWithBasicSudoku();
        }
    }

    public void loadGame(File fileName) {
        for (int r = 0; r < sudokuMatrix.length; r++) {

            for (int c = 0; c < sudokuMatrix[0].length; c++) {
                labelPanel = (JLabel) sudokuMatrix[r][c].getComponent(0);
                labelPanel.setText("");
                sudokuMatrix[r][c].setEnabled(true);
                if ((r / 3 + c / 3) % 2 == 0) {

                    sudokuMatrix[r][c].setBackground(Color.getColor(nm, red));

                } else {

                    sudokuMatrix[r][c].setBackground(Color.white);
                }
            }

        }
        fillMatrixWithBasicSudoku();
        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader
                    = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);

            for (int r = 0; r < sudokuMatrix.length; r++) {

                for (int c = 0; c < sudokuMatrix[0].length; c++) {

                    if ((line = bufferedReader.readLine()) != null) {

                        if (!line.equals("0")) {

                            labelPanel = (JLabel) sudokuMatrix[r][c].getComponent(0);
                            labelPanel.setText(line);
                            sudokuMatrix[r][c].remove(0);
                            sudokuMatrix[r][c].add(labelPanel);
                            int validate = Integer.parseInt(labelPanel.getText());
                            if (validate == matrix[r][c]) {

                                sudokuMatrix[r][c].setEnabled(false);
                            } else if (validate != matrix[r][c]) {

                                sudokuMatrix[r][c].setBackground(Color.YELLOW);
                                sudokuMatrix[r][c].setEnabled(true);

                            }

                        }

                    }

                }

            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == about) {
            new SudokuFromOuterSpace().aboutDeveloper();
        }
        if (e.getSource() == instructions) {
            new SudokuFromOuterSpace().sudokuRules();
        }
        if (e.getSource() == btnClose) {
            new SudokuFromOuterSpace().exitProgram();
        }
        if (e.getSource() == exit) {
            new SudokuFromOuterSpace().exitProgram();
        }
        if (e.getSource() == btnPlay) {
            startNewGame();
        }
        if (e.getSource() == btnLoad) {
            int loadObject = JOptionPane.showConfirmDialog(null, "¿Esta Seguro que desea cargar una partida? \nEl juego terminara y se perderan los cambios no guardados.", "Cargar Partida", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/image/info1.png")));
            if (loadObject == JOptionPane.YES_OPTION) {
                Object loadSlot = JOptionPane.showInputDialog(null, "Elija la partida que desea cargar:",
                        "Cargar Partida.", JOptionPane.QUESTION_MESSAGE, null,
                        new Object[]{"Seleccione", "Partida 1", "Partida 2", "Partida 3", "Partida 4"}, "Seleccione");
                if (loadSlot.equals("Partida 1")) {

                    Saves ClassSave = new Saves();
                    loadGame(ClassSave.hardSave1);

                }
                if (loadSlot.equals("Partida 2")) {
                    Saves ClassSave = new Saves();
                    loadGame(ClassSave.hardSave2);
                }
                if (loadSlot.equals("Partida 3")) {
                    Saves ClassSave = new Saves();
                    loadGame(ClassSave.hardSave2);
                }
                if (loadSlot.equals("Partida 4")) {
                    Saves ClassSave = new Saves();
                    loadGame(ClassSave.hardSave3);
                }
            }

        }
        if (e.getSource() == btnResolve) {
            resolveSudoku();
        }
        if (e.getSource() == btnCheck) {
            resultOfGame(checkSudokuStatus(MatrixToSave()));
        }
        if (e.getSource() == btnreturn) {
            int returnLevel = JOptionPane.showConfirmDialog(null, "¿Desea Regresar? \nSe perderan los cambios no guardados.", "Regresar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/image/info1.png")));
            if (returnLevel == JOptionPane.YES_OPTION) {
                SudokuFromOuterSpace ClassMain = new SudokuFromOuterSpace();
                ClassMain.returnLevelMenu();
                dispose();
            }
        }
        if (e.getSource() == btnSave) {
            Object saveSlotEasy = JOptionPane.showInputDialog(null, "Guarde su Partida:",
                    "Guardar Partida.", JOptionPane.QUESTION_MESSAGE, null,
                    new Object[]{"Seleccione", "Partida 1", "Partida 2", "Partida 3", "Partida 4"}, "Seleccione");
            if (saveSlotEasy.equals("Partida 1")) {
                Saves ClassSave = new Saves();
                ClassSave.Save(ClassSave.hardSave1, MatrixToSave());
            }
            if (saveSlotEasy.equals("Partida 2")) {
                Saves ClassSave = new Saves();
                ClassSave.Save(ClassSave.hardSave2, MatrixToSave());
            }
            if (saveSlotEasy.equals("Partida 3")) {
                Saves ClassSave = new Saves();
                ClassSave.Save(ClassSave.hardSave3, MatrixToSave());
            }
            if (saveSlotEasy.equals("Partida 4")) {
                Saves ClassSave = new Saves();
                ClassSave.Save(ClassSave.hardSave4, MatrixToSave());
            }

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char letterChar = e.getKeyChar();
        if (letterChar >= '1' && letterChar <= '9' && letterChar != KeyEvent.VK_BACK_SPACE) {
            e.consume();
            String characterToString = Character.toString(letterChar);
            JLabel labelLetter = (JLabel) jpSudokuPanel.getComponent(0);
            labelLetter.setText(characterToString);
            jpSudokuPanel.add(labelLetter);
            labelLetter.setFont(new Font("Roboto", Font.BOLD, 22));
            jpSudokuPanel.setBackground(Color.lightGray);
            validateSudoku();
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        jpSudokuPanel = (JPanel) e.getSource();
        jpSudokuPanel.requestFocus();

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

}
