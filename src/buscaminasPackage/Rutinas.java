/**
 * Nombre del programa: Buscaminas Rutinas
 * Descripción: Esta parte de la paliccaion se encarga de la logica del juego
 * Fecha:9 de febrero del 2017
 * Autor: Adrián Obando Leitón y Jose Solano
 * Fecha de modificación: 09-02-17
 * Modificado por: Adrián Obando Leitón
 */
package buscaminasPackage;

//Librerias Utilizadas
import java.util.Random;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * *
 * Inicio de la clase que contiene el codigo necesario para el funcionamiento
 * del juego
 */
public class Rutinas {

    private static int[][] dashboard;
    static int cantMines;
    static int sizeMat;
    private static List<String> listSpacesWithCero = new ArrayList();
    private static List<String> listNumbersAround = new ArrayList();
    private static boolean isFirstCero = true;

    /**
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

    //Clase generada solo para ver la matriz
    public static void main(String[] args) throws IOException {
        initDashboard(5);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(" " + dashboard[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    /**
     * *
     * Procedimiento: Se encarga de generar la cantidad de bombas dependiendo el
     * nivel de dificultatd y generando posiciones aleatorias dentro de la
     * matriz
     */
    static void generateMines() {
        Random ran = new Random();
        int row, column, mines = cantMines;
        boolean isDuplicate;
        while (mines > 0) {
            row = ran.nextInt(sizeMat - 0);
            column = ran.nextInt(sizeMat - 0);
            isDuplicate = insertMine(row, column);

            if (!isDuplicate) 
                mines--;
        }
    }

    /**
     * *
     * Funcion:Se encarfa de insertar las minas en una posicion aletoria se
     * valida de que no exista ya una bomba en esa posicion
     *
     * @param prow Posicion en fila
     * @param pcolumn Posiscion en columna
     * @return Devuelve true si ya es una posicion duplicada
     */
    static boolean insertMine(int prow, int pcolumn) {
        if (dashboard[prow][pcolumn] != 9) {
            dashboard[prow][pcolumn] = 9;
            return false;
        }
        return true;
    }

    /**
     * *
     * Pocedimiento: Se encarga de rastrear una bomba por la matriz si se
     * encuentra se llama a la funcion addSpaceNear, para generar la cantidad de
     * minas alrededor de un boton
     */
    static void trackMine() {
        int row = sizeMat - 1;
        int column = sizeMat - 1;
        while (row >= 0) {//5>0
            //logica de la minas
            if (dashboard[row][column] == 9) 
                addSpaceNear(row, column);
            
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

    /**
     * *
     * Procedimiento: Se encarga de sumar los campos alrededor de la matriz con
     * sumando 1 esto genera el rastreo de las minas
     *
     * @param prow Paremetro recivido que representa la fila
     * @param pcolumn Paremetro recibido que representa la columna
     */
    static void addSpaceNear(int prow, int pcolumn) {
        int spacecolumn = pcolumn - 1;
        int spacerow = prow - 1;
        int cont = 0;
        int limit = sizeMat;
        while (spacerow <= prow + 1 && spacecolumn <= pcolumn + 1) {
            if ((spacerow >= 0 && spacecolumn >= 0)
                    && (spacerow < limit && spacecolumn < limit)
                    && dashboard[spacerow][spacecolumn] != 9) {
                dashboard[spacerow][spacecolumn] += 1;;
            }
            spacecolumn += 1;
            cont++;
            if (cont == 3) {
                spacerow += 1;
                spacecolumn -= 3;
            }
        }
    }
    /***
     * Procedimiento; Se encarga de rastrear todo los elementos cuando se hace click
     * a un espacio en cero, almacenando en listas globales los elementos a mostrar
     * tanto los botones con cero y los botones adyacentes a estos
     * @param prow Parametro de posicion en fila del elemento que tiene cero
     * @param pcolumn Parametro de posicion coulmna que tiene cero
     */
    static void spaceWithCero(int prow, int pcolumn) {
        int upRow = prow - 1, upColumn = pcolumn - 1, i, j;
        int limitRow = prow + 1, limitColumn = pcolumn + 1;
        if ((upRow >= 0 && upColumn >= 0) && (limitRow < sizeMat && limitColumn < sizeMat)) {
            for (i = 0; i < limitRow; i++) {
                for (j = 0; j < limitColumn; j++) {
                    if (dashboard[i][j] == 0) {
                        addElementCero(i, j);
                    } else
                    {
                        addElemenNumber(i, j);
                    }
                }
            }
            if (isFirstCero) 
            {
                isFirstCero = false;
                checkNeihgbor();
            }
        }
    }
    /***
     * Procedimiento que se encarga de agregar los elementos con cero dentro de la lista
     * @param prow Parametro de posicion en fila del elemento que tiene cero
     * @param pcolumn Parametro de posicion coulmna que tiene cero
     */
    static void addElementCero(int prow, int pcolum) {
        String butonToShow;
        butonToShow = "b" + prow + pcolum;
        boolean isAlreadyInserted = listSpacesWithCero.contains(butonToShow);
        if (!isAlreadyInserted) 
            listSpacesWithCero.add(butonToShow);     
    }
    /***
     * Procedimiento que inserta los numeros alrededor de los espacios en cero 
     * @param prow Parametro de posicion en fila del elemento que tiene cero
     * @param pcolumn Parametro de posicion coulmna que tiene cero
     */
    static void addElemenNumber(int prow, int pcolum) {
        String butonToShow;
        butonToShow = "b" + prow + pcolum;
        boolean isAlreadyInserted = listNumbersAround.contains(butonToShow);
        if (!isAlreadyInserted) 
            listNumbersAround.add(butonToShow);  
    }
    /***
     * Pocedimiento que genera vuelve a llamar a la funcion para seguir averiguando
     * si hay mas elementos con ceros
     */
    static void checkNeihgbor() {
        int row, column;
        for (String element : listSpacesWithCero) {
            row = Character.getNumericValue(element.charAt(1));
            column = Character.getNumericValue(element.charAt(2));
            spaceWithCero(row, column);
        }
        isFirstCero = false;
    }
}
