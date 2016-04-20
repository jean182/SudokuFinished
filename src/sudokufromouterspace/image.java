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
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
public class image extends javax.swing.JPanel  {
public image(){
this.setSize(400,280);
}
@Override
public void paintComponent (Graphics g){
Dimension tamanio = getSize();
ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/image/spiderman.png"));
g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
setOpaque(false);
super.paintComponent(g);
}

   
}
