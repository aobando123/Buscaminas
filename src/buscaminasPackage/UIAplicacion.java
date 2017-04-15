/*
 * Nombre del programa: Buscaminas Rutinas
 * Descripción: Esta parte de la aplicacion se encarga de la interfaz grafica
 * Fecha: 9 de Abril del 2017
 * Autor: Adrián Obando Leitón y Jose Solano Montoya
 * Fecha de modificación: 12-04-17
 * Modificado por: Jose Solano
 */
package buscaminasPackage;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
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
        lblFondo1 = new javax.swing.JLabel();
        pnJuego5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblquatity = new javax.swing.JLabel();
        btnAllDashboard = new javax.swing.JButton();
        btnFace = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnPrincipal.setBackground(new java.awt.Color(51, 102, 255));
        pnPrincipal.setLayout(new java.awt.CardLayout());

        pnInicio.setBackground(new java.awt.Color(221, 255, 154));
        pnInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Impact", 1, 48)); // NOI18N
        lblTitulo.setText("BUSCAMINAS");
        pnInicio.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        btnNormal.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnNormal.setForeground(new java.awt.Color(0, 0, 0));
        btnNormal.setText("Normal");
        btnNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNormalActionPerformed(evt);
            }
        });
        pnInicio.add(btnNormal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 150, 70));

        btnDificil.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnDificil.setForeground(new java.awt.Color(0, 0, 0));
        btnDificil.setText("Dificil");
        btnDificil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDificilActionPerformed(evt);
            }
        });
        pnInicio.add(btnDificil, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 150, 70));

        lblSeleccionar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblSeleccionar.setText("Seleccione dificultad");
        pnInicio.add(lblSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        lblFondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buscaminasPackage/Fondo.png"))); // NOI18N
        pnInicio.add(lblFondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -14, 640, 420));

        pnPrincipal.add(pnInicio, "card2");

        pnJuego5.setBackground(new java.awt.Color(221, 255, 154));
        pnJuego5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buscaminasPackage/min.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        pnJuego5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 120, 120));

        lblquatity.setFont(new java.awt.Font("Impact", 1, 24)); // NOI18N
        lblquatity.setText("5");
        pnJuego5.add(lblquatity, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, -1, -1));

        btnAllDashboard.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        btnAllDashboard.setText("Mostrar Tablero");
        btnAllDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllDashboardActionPerformed(evt);
            }
        });
        pnJuego5.add(btnAllDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 282, 120, 40));

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
        JLabel lblFondo = new JLabel();
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
                btn.setIcon(getResizeImage("inicio.png", length, length));
                btn.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        try {
                            buttonClicked(evt);
                        } catch (IOException ex) {
                            Logger.getLogger(UIAplicacion.class.getName()).log(Level.SEVERE, null, ex);
                        }
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
        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buscaminasPackage/Fondo.png"))); // NOI18N
        pnJuego5.add(lblFondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -14, 640, 420));

    }


    private void btnNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNormalActionPerformed
        initializePnJuego(5);
        Rutinas.initDashboard(5);

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
        try {
            gameOverBySumition();
        } catch (IOException ex) {
            Logger.getLogger(UIAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAllDashboardActionPerformed

    private void btnFaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFaceActionPerformed

    private void buttonClicked(java.awt.event.MouseEvent click) throws IOException {
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
            if (SwingUtilities.isLeftMouseButton(click) && !isLastLetter(btnName, "f")) {
                int valueBehindButton = Rutinas.checkBackDashboard(btnName);
                if (valueBehindButton == 0) {
                    showNearZeroButton(btnName);
                } else if (valueBehindButton != 9) {
                    changeButton(btnName, valueBehindButton);
                } else {
                    showAllMines();
                    changeButton(btnName, 13);
                    changeButton("bst", 11);
                    showGameOver();
                }
                if (Rutinas.isWinner()) {
                    changeButton("bst", 12);
                    addToRecords();
                }

            } else if (SwingUtilities.isRightMouseButton(click)) {
                String lastLetter = btn.getName().substring(btn.getName().length() - 1);
                changeButton(btnName, 10);

            }
        }

    }

    private void showNearZeroButton(String pbtnName) {
        int row = 0, column = 0, valueBtn = 0;
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

    private void showAllMines() {
        int valueBtn;

        for (String element : Rutinas.getAllMines()) {
            valueBtn = Rutinas.checkBackDashboard(element);
            changeButton(element, valueBtn);
        }
    }

    private void changeButton(String pName, int pvalor) {
        JButton btn;
        String imgName, bName;
        bName = pName.substring(0, 3);
        btn = buttonMap.get(bName);
        if (btn.isEnabled() && (!isLastLetter(btn.getName(), "f") && pvalor != 10)) {
            btn = setImage(btn, pvalor);
            buttonMap.replace(bName, btn);

        } else if (pvalor == 10) {
            btn = setImage(btn, pvalor);
            buttonMap.replace(bName, btn);
        } else if (pvalor == 13) {
            btn = setImage(btn, pvalor);
            buttonMap.replace(bName, btn);
        } else if (pvalor == 9 && isLastLetter(btn.getName(), "f")) {
            btn = setImage(btn, pvalor);
            buttonMap.replace(bName, btn);
        } else if (pvalor == 14) {
            btn = setImage(btn, pvalor);
            buttonMap.replace(bName, btn);
        }

    }

    private JButton setImage(JButton btn, int pvalor) {
        int width, height;
        if (Rutinas.getDashboardSize() == 5) {
            width = 60;
            height = 60;
        } else {
            width = 40;
            height = 40;
        }
        switch (pvalor) {
            case 11:
                btn.setIcon(getResizeImage("face3.png", 60, 60));
                break;
            case 12:
                btn.setIcon(getResizeImage("face2.png", 60, 60));
                break;
            case 13:
                btn.setDisabledIcon(getResizeImage("bombaroja.png", width, height));
                break;
            case 14:
                btn.setIcon(getResizeImage("face1.png", 60, 60));
                break;
            default:
                btn.setDisabledIcon(getResizeImage(pvalor + ".png", width, height));
                btn.setBackground(new java.awt.Color(255, 255, 255));
                btn.setEnabled(false);
                Rutinas.substractSpacesToWin();
                break;
            case 10:

                if ("0".equals(lblquatity.getText()) && !isLastLetter(btn.getName(), "f")) {
                    JOptionPane.showMessageDialog(this, "Ya ha usado todas su banderas");
                } else if (isLastLetter(btn.getName(), "f")) {
                    btn.setName(btn.getName().substring(0, 3) + "?");
                    btn.setIcon(getResizeImage("question.png", width, height));
                    lblquatity.setText("" + Rutinas.addMines());
                } else if (isLastLetter(btn.getName(), "?")) {
                    btn.setName(btn.getName().substring(0, 3));
                    btn.setIcon(getResizeImage("inicio.png", width, height));

                } else {
                    lblquatity.setText("" + Rutinas.sustractMines());
                    btn.setIcon(getResizeImage("flag.png", width, height));
                    btn.setName(btn.getName() + "f");
                }
                break;
        }
        return btn;
    }

    private ImageIcon getResizeImage(String imageName, int pwidth, int pheight) {

        ImageIcon icoDefault = new ImageIcon(getClass().getResource("/buscaminasPackage/" + imageName));
        Image imageDefault = icoDefault.getImage();
        Image resizeImage = imageDefault.getScaledInstance(pwidth, pheight, Image.SCALE_SMOOTH);
        ImageIcon resizeIcon = new ImageIcon(resizeImage);

        return resizeIcon;
    }

    private void gameOverBySumition() throws IOException {
        changeButton("bst", 11);
        showGameOver();
    }

    private boolean isLastLetter(String buttonName, String lastLetter) {
        if (lastLetter.equals(buttonName.substring(buttonName.length() - 1))) {
            return true;
        }
        return false;
    }

    private void addToRecords() {
        String playerName;
        boolean isCompleted;
        Object[] options1 = {"Agregar Nombre", "Salir"};
        JPanel panel = new JPanel();
        panel.add(new JLabel("Digite el nombre del ganador \n"));
        JTextField textField = new JTextField(10);
        panel.add(textField);
        int result = JOptionPane.showOptionDialog(this, panel, "Felicidades Ha Ganado!!",
                JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                options1, null);
        if (result == JOptionPane.YES_OPTION) {
            playerName = textField.getText();
            try {
                isCompleted = Rutinas.serializeWinner(numberOfClicks, playerName);
                if (isCompleted) {
                    panel.setVisible(false);
                    showFinalMessage();
                }
            } catch (IOException ex) {
                Logger.getLogger(UIAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.exit(0);
        }
    }

    private void showFinalMessage() throws IOException {
        String playerName;
        List<String> topFive = new ArrayList();
        boolean isCompleted;
        Object[] options1 = {"Mostrar Records", "Volver A Jugar", "Salir"};
        JPanel panel = new JPanel();
        panel.add(new JLabel("Seleccione lo que desaea hacer"));
        int result = JOptionPane.showOptionDialog(this, panel, "Fin del Juego",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                options1, null);
        if (result == JOptionPane.YES_OPTION) {
            panel.setVisible(false);
            topFive = Rutinas.winners();
            showRecords(topFive);
        } else if (result == JOptionPane.PLAIN_MESSAGE) {
            System.exit(0);
        } else {
            restarGame();
        }
    }

    public void showRecords(List<String> ptopFive) throws IOException {
        Object[] options1 = {"Volver A Jugar", "Salir"};
        int count = 0;
        JPanel panel = new JPanel();
        for (String element : ptopFive) {
            panel.add(new JLabel(element));
        }
        int result = JOptionPane.showOptionDialog(this, panel, "Los mejores 5",
                JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                options1, null);
        if (result == JOptionPane.YES_OPTION) {
            restarGame();
        } else {
            System.exit(0);
        }
    }

    public void showGameOver() throws IOException {
        Object[] options1 = {"Volver A Jugar", "Salir"};
        int count = 0;
        JPanel panel = new JPanel();
        panel.add(new JLabel("Ha Perdido!"));
        int result = JOptionPane.showOptionDialog(this, panel, "Fin del Juego",
                JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                options1, null);
        if (result == JOptionPane.YES_OPTION) {
            restarGame();
        } else {
            System.exit(0);
        }
    }
    public static final String SUN_JAVA_COMMAND = "sun.java.command";

    /*
     * Reiniciar la apliccaion Java
     * @throws IOException
     */
 /* public static void restarGame() throws IOException {
        try {
            String java = System.getProperty("java.home") + "/bin/java";
            List<String> vmArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
            StringBuffer vmArgsOneLine = new StringBuffer();
            for (String arg : vmArguments) {
                if (!arg.contains("-agentlib")) {
                    vmArgsOneLine.append(arg);
                    vmArgsOneLine.append(" ");
                }
            }
            final StringBuffer cmd = new StringBuffer("\"" + java + "\" " + vmArgsOneLine);

            String[] mainCommand = System.getProperty(SUN_JAVA_COMMAND).split(" ");
            if (mainCommand[0].endsWith(".jar")) {
                cmd.append("-jar " + new File(mainCommand[0]).getPath());
            } else {
                cmd.append("-cp \"" + System.getProperty("java.class.path") + "\" " + mainCommand[0]);
            }
            for (int i = 1; i < mainCommand.length; i++) {
                cmd.append(" ");
                cmd.append(mainCommand[i]);
            }
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    try {
                        Runtime.getRuntime().exec(cmd.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            System.exit(0);
        } catch (Exception e) {
            throw new IOException("Error while trying to restart the application", e);
        }
    }*/
    private void restarGame() {
        Rutinas.cleanVariables();
        pnPrincipal.remove(pnJuego5);
        pnInicio.add(lblFondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -14, 640, 420));
        pnPrincipal.add(pnInicio);
        pnPrincipal.repaint();
        pnPrincipal.revalidate();
        cleanPnGame();

    }

    private void cleanPnGame() {
        JButton b;
        for (int i = 0; i < Rutinas.getDashboardSize(); i++) {
            for (int j = 0; j < Rutinas.getDashboardSize(); j++) {
                b = buttonMap.remove("b" + i + j);
                pnJuego5.remove(b);
            }
        }
        buttonMap.clear();
        buttonMap.put("bst", btnFace);
        changeButton("bst", 14);
        numberOfClicks = 0;
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
    private javax.swing.JLabel lblFondo1;
    private javax.swing.JLabel lblSeleccionar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblquatity;
    private javax.swing.JPanel pnInicio;
    private javax.swing.JPanel pnJuego5;
    private javax.swing.JPanel pnPrincipal;
    // End of variables declaration//GEN-END:variables
}
