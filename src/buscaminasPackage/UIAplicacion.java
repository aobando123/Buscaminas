/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminasPackage;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class UIAplicacion extends javax.swing.JFrame {

    private static List<String> elementsToShow = new ArrayList();
    private static List<String> elementsToShowNumbers = new ArrayList();
    private static int numberOfClicks = 0;
    public UIAplicacion() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPrincipal = new javax.swing.JPanel();
        pnInicio = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnNormal = new javax.swing.JButton();
        btnDificil = new javax.swing.JButton();
        lblSeleccionar = new javax.swing.JLabel();
        pnJuego5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblquatity = new javax.swing.JLabel();
        btnAllDashboard = new javax.swing.JButton();
        btnFace = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnPrincipal.setBackground(new java.awt.Color(51, 102, 255));
        pnPrincipal.setLayout(new java.awt.CardLayout());

        pnInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblTitulo.setText("Buscaminas");
        pnInicio.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        btnNormal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnNormal.setText("Normal");
        btnNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNormalActionPerformed(evt);
            }
        });
        pnInicio.add(btnNormal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 150, 70));

        btnDificil.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnDificil.setText("Difìcil");
        btnDificil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDificilActionPerformed(evt);
            }
        });
        pnInicio.add(btnDificil, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 150, 70));

        lblSeleccionar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblSeleccionar.setText("Seleccione dificultad");
        pnInicio.add(lblSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, -1, -1));

        pnPrincipal.add(pnInicio, "card2");

        pnJuego5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buscaminasPackage/min.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        pnJuego5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 120, 120));

        lblquatity.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblquatity.setText("5");
        pnJuego5.add(lblquatity, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, -1, -1));

        btnAllDashboard.setText("Mostrar Tablero");
        btnAllDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllDashboardActionPerformed(evt);
            }
        });
        pnJuego5.add(btnAllDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, -1, -1));

        btnFace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buscaminasPackage/face1.png"))); // NOI18N
        btnFace.setName("bst"); // NOI18N
        btnFace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFaceActionPerformed(evt);
            }
        });
        pnJuego5.add(btnFace, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 50, 50));
        buttonMap.put(btnFace.getName(), btnFace);

        pnPrincipal.add(pnJuego5, "card3");

        getContentPane().add(pnPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents
private Map<String, JButton> buttonMap = new HashMap<String, JButton>();

    private void initializePnJuego(int psize) {
        //comment
        int posx = 10;
        int posy = 10;
        int length;
        String name;
        if (psize == 5) {
            length = 60;
        } else {
            length = 40;
        }
        for (int i = 0; i < psize; i++) {
            for (int j = 0; j < psize; j++) {
                JButton btn = new JButton();
                name = "b" + i + j;
                btn.setName(name);
                btn.setBackground(new java.awt.Color(255, 153, 51));
                btn.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        buttonClicked(evt);
                    }
                });
                pnJuego5.add(btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(posx, posy, length, length));
                buttonMap.put(name, btn);
                posx += length;
            }
            posx = 10;
            posy += length;
        }
        lblquatity.setText("" + psize);

    }


    private void btnNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNormalActionPerformed
        
        Rutinas.initDashboard(5);
        initializePnJuego(5);
        pnPrincipal.remove(pnInicio);
        pnPrincipal.add(pnJuego5);
        pnPrincipal.repaint();
        pnPrincipal.revalidate();
        int valueDas = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                valueDas = Rutinas.mostrarAyuda(i, j);
                System.out.print(" " + valueDas + " ");
            }
            System.out.println(" ");
        }
    }//GEN-LAST:event_btnNormalActionPerformed

    private void btnDificilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDificilActionPerformed
        
        Rutinas.initDashboard(8);
        initializePnJuego(8);
        pnPrincipal.remove(pnInicio);
        pnPrincipal.add(pnJuego5);
        pnPrincipal.repaint();
        pnPrincipal.revalidate();
        int valueDas = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                valueDas = Rutinas.mostrarAyuda(i, j);
                System.out.print(" " + valueDas + " ");
            }
            System.out.println(" ");
        }
    }//GEN-LAST:event_btnDificilActionPerformed

    private void btnAllDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllDashboardActionPerformed
        int valueBtn;
        elementsToShow = Rutinas.giveUpPlay();
        for (String element : elementsToShow) {
            valueBtn = Rutinas.checkBackDashboard(element);
            changeButton(element, valueBtn);
        }
        gameOverBySumition();
    }//GEN-LAST:event_btnAllDashboardActionPerformed

    private void btnFaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFaceActionPerformed
  
    private void buttonClicked(java.awt.event.MouseEvent click) {
        String btnName = "";
        elementsToShowNumbers.clear();
        elementsToShow.clear();
        JButton btn = null;
        //Obteniendo el Buton clickeado
        Object o = click.getSource();
        if (o instanceof JButton) {
            btn = (JButton) o;
            numberOfClicks++;
        }

        if (btn != null) {
            btnName = btn.getName();
        }
        //left click or right click
        if (btn.isEnabled()) {
            if (SwingUtilities.isLeftMouseButton(click)) {
                int valueBehindButton = Rutinas.checkBackDashboard(btnName);
                if (valueBehindButton == 0) {
                    showNearZeroButton(btnName);
                }
                else if(valueBehindButton != 9){
                    changeButton(btnName, valueBehindButton);
                }
                else
                {
                    Rutinas.findAllMines();
                    showAllMines();
                    changeButton("bst", 11);
                    JOptionPane.showMessageDialog(this, "Lo siento, has perdido");
                    System.exit(0);
                    //todo: quitar el exit y cambiarlo por un reinicio o
                    //por un mensaje que le de opcion de reiniciar o salir
                }
                if(Rutinas.isWinner()){
                    changeButton("bst", 12);
                    addToRecords();
                }

            } else if (SwingUtilities.isRightMouseButton(click)) {
                String lastLetter = btn.getName().substring(btn.getName().length()-1);
                 changeButton(btnName, 10);
              
            }
        }

    }

    private void showNearZeroButton(String pbtnName) {
        int row = 0, column = 0, valueBtn =0;
        row = Character.getNumericValue(pbtnName.charAt(1));
        column = Character.getNumericValue(pbtnName.charAt(2));
        Rutinas.spaceWithCero(row, column);
        elementsToShow = Rutinas.getListToShowCero();
        elementsToShowNumbers = Rutinas.getListToShowNumbers();
        for (String element : elementsToShow) {
            changeButton(element, 0);
            
        }
        for (String element : elementsToShowNumbers) {
            valueBtn = Rutinas.checkBackDashboard(element);
            changeButton(element, valueBtn);
            
        }
        Rutinas.cleanAllLists();
    }
    
    private void showAllMines(){
        int valueBtn;
        elementsToShowNumbers = Rutinas.getAllMines();
        for (String element : elementsToShowNumbers) {
            valueBtn = Rutinas.checkBackDashboard(element);
            changeButton(element, valueBtn);
        }
    }

    private void changeButton(String pName, int pvalor) {
        JButton btn;
        String imgName,bName;
        bName = pName.substring(0, 3);
        btn = buttonMap.get(bName);
        if(btn.isEnabled()){
        btn = setImage(btn, pvalor);
        buttonMap.replace(bName, btn);
       
        }

    }
    
  
     private JButton setImage(JButton btn, int pvalor) {
        String nameImage;
        switch(pvalor){
            case 11:
                btn.setIcon(getResizeImage("face3.png"));
            break;
            case 12:
                btn.setIcon(getResizeImage("face2.png"));
            break;
            default:
                btn.setDisabledIcon(getResizeImage(pvalor + ".png"));
                btn.setBackground(new java.awt.Color(255, 255, 255));
                btn.setEnabled(false);
                Rutinas.substractSpacesToWin();
             break;
            case 10:
                String lastLetter = btn.getName().substring(btn.getName().length()-1);
                   if ("0".equals(lblquatity.getText()) && !"f".equals(lastLetter)) 
                   {
                        JOptionPane.showMessageDialog(this, "Ya ha usado todas su banderas");
                   } 
                   else if("f".equals(lastLetter))
                   {
                        btn.setName(btn.getName().substring(0,3));
                        btn.setIcon(null);
                        lblquatity.setText("" + Rutinas.addMines());
                   }
                    else
                   {
                        lblquatity.setText("" + Rutinas.sustractMines());
                        btn.setIcon(getResizeImage("flag.png"));
                        btn.setName(btn.getName()+"f");
                   }
            break;
        }
        return btn;
    }

    private ImageIcon getResizeImage(String imageName){
        int width, height;
        if(Rutinas.getDashboardSize()==5){
        width=45;
        height = 45;
        }
        else {
        width=30;
        height = 30;
        }
        ImageIcon icoDefault = new ImageIcon(getClass().getResource("/buscaminasPackage/" + imageName));
        Image imageDefault = icoDefault.getImage();
        Image resizeImage = imageDefault.getScaledInstance(width,height, Image.SCALE_SMOOTH);
        ImageIcon resizeIcon = new ImageIcon(resizeImage);

        return resizeIcon;
    }
    
    private void gameOverBySumition(){
        changeButton("bst", 11);
        JOptionPane.showMessageDialog(this, "Se ha rendido");
    }
    
    private void addToRecords(){
        String playerName;
        boolean isCompleted;
        Object[] options1 = { "Agregar Nombre", "Salir" };
        JPanel panel = new JPanel();
        panel.add(new JLabel("Digite el nombre del ganador \n"));
        JTextField textField = new JTextField(10);
        panel.add(textField);
        int result = JOptionPane.showOptionDialog(this, panel, "Felicidades Ha Ganado!!",
        JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null,
        options1, null);
            if (result == JOptionPane.YES_OPTION) 
            {
                playerName = textField.getText();
            try 
            {
                isCompleted = Rutinas.serializeWinner(numberOfClicks, playerName);
                if(isCompleted){
                    panel.setVisible(false);
                    showFinalMessage();
                }
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(UIAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            else{
                  System.exit(0);
            }
    }

    private void showFinalMessage(){
     String playerName;
        boolean isCompleted;
        Object[] options1 = { "Mostrar Records", "Volver A Jugar", "Salir" };
        JPanel panel = new JPanel();
        panel.add(new JLabel("Digite el nombre del ganador \n"));
        JTextField textField = new JTextField(10);
        panel.add(textField);
        int result = JOptionPane.showOptionDialog(this, panel, "Felicidades!!",
        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
        options1, null);
            if (result == JOptionPane.YES_OPTION) 
            {
                //MOstrar Recors
            }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UIAplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIAplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIAplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIAplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIAplicacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllDashboard;
    private javax.swing.JButton btnDificil;
    private javax.swing.JButton btnFace;
    private javax.swing.JButton btnNormal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblSeleccionar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblquatity;
    private javax.swing.JPanel pnInicio;
    private javax.swing.JPanel pnJuego5;
    private javax.swing.JPanel pnPrincipal;
    // End of variables declaration//GEN-END:variables
}
