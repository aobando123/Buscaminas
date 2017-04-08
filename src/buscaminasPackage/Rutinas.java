/**
 * Nombre del programa
 * Descripción:
 * Fecha:9 de febrero del 2017
 * Autor:Adrián Obando Leitón
 * Fecha de modificación: 09-02-17
 * Modificado por: Adrián Obando Leitón
 */
package buscaminasPackage;

//Librerias
import java.util.Random;
import java.io.*;

public class Rutinas {

    private static int[][] dashboard;
    static int cantMines;
    static int sizeMat;

    /**
     * *
     * Procedimiento:Inicializar matriz Parametros:size Funcion: inicializa la
     * matriz de acuerdo con la dificultad
     */
    static void initDashboard(int size) {

        dashboard = new int[size][size];
        cantMines = size;
        sizeMat = size;

        generateMines();
        trackMine();

    }

    public static void main(String[] args) throws IOException {
        initDashboard(5);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(" " + dashboard[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    static void generateMines() {
        Random ran = new Random();
        int row, column, mines = cantMines;
        boolean isDuplicate;

        while (mines > 0) {
            row = ran.nextInt(sizeMat - 0);
            column = ran.nextInt(sizeMat - 0);
            isDuplicate = insertMine(row, column);
            if (!isDuplicate) {
                mines -= 1;
            }
        }

    }

    static boolean insertMine(int row, int column) {
        if (dashboard[row][column] != 9) {
            dashboard[row][column] = 9;
            return false;
        }
        return true;
    }

    static void trackMine() {

        int row = sizeMat - 1;//5
        int column = sizeMat - 1;//5
        while (row >= 0) {//5>0

            //logica de la minas
            if (dashboard[row][column] == 9) {
                addSpaceNear(row, column);
            }
            //define posicion fila, columna
            if (column != 0)//5!=0
            {
                column--;
            } else {
                column = 4;
                row--;
            }

        }
    }

    static void addSpaceNear(int prow, int pcolumn) {
        int spacecolumn = pcolumn - 1;
        int spacerow = prow - 1;
        int cont = 0;

        while (spacerow <= prow + 1 && spacecolumn <= pcolumn + 1) {
            if ((spacerow >= 0 && spacecolumn >= 0) && (spacerow <= 4 && spacecolumn <= 4)
                    && dashboard[spacerow][spacecolumn] != 9) {
                dashboard[spacerow][spacecolumn] += 1;;
            }
            spacecolumn += 1;
            cont += 1;
            if (cont == 3) {
                spacerow += 1;
                spacecolumn -= 3;
            }
        }
    }
    

}
