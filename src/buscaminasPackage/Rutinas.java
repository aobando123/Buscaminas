/*
 * Nombre del programa: Buscaminas Rutinas
 * Descripción: Esta parte de la paliccaion se encarga de la logica del juego
 * Fecha: 9 de abril del 2017
 * Autor: Adrián Obando Leitón y Jose Solano Montoya
 * Fecha de modificación: 12-04-17
 * Modificado por: Jose Solano
 */
package buscaminasPackage;

//Librerias Utilizadas
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
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
    static int spacesToWin;
    private static String[] arrayMines;
    private static List<String> listSpacesWithCero = new ArrayList();
    private static List<String> listNumbersAround = new ArrayList();
    private static List<String> listAllElements = new ArrayList();
    private static List<String> listMines = new ArrayList();
    private static boolean isFirstCero = true;
    private static String pathfile = null;

    /**
     * Procedimiento:Inicializar matriz Parametros:size Funcion: inicializa la
     * matriz de acuerdo con la dificultad
     */
    static void initDashboard(int size) {
        dashboard = new int[size][size];
        cantMines = size;
        sizeMat = size;
        spacesToWin = (sizeMat * sizeMat) - cantMines;
        generateMines();
        trackMine();
        arrayMines= new String[listMines.size()];
        arrayMines = listMines.toArray(arrayMines);
    }

    //Clase generada solo para ver la matriz
    public static int mostrarAyuda(int i, int j) {
        return dashboard[i][j];
    }

    /**
     * *
     * Procedimiento: Se encarga de generar la cantidad de bombas dependiendo el
     * nivel de dificultatd y generando posiciones aleatorias dentro de la
     * matriz
     */
    private static void generateMines() {
        Random ran = new Random();
        int row, column, mines = cantMines;
        boolean isDuplicate;
        while (mines > 0) {
            row = ran.nextInt(sizeMat - 0);
            column = ran.nextInt(sizeMat - 0);
            isDuplicate = insertMine(row, column);

            if (!isDuplicate) {
                mines--;
            }
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
    private static boolean insertMine(int prow, int pcolumn) {
        if (dashboard[prow][pcolumn] != 9) {
            dashboard[prow][pcolumn] = 9;
            listMines.add("b" + prow + pcolumn);
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
    private static void trackMine() {
        int row = sizeMat - 1;
        int column = sizeMat - 1;
        while (row >= 0) {
            if (column >= 0) {
                if (dashboard[row][column] == 9) {
                    addSpaceNear(row, column);
                }

                column--;
            } else {
                column = sizeMat - 1;
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
    private static void addSpaceNear(int prow, int pcolumn) {
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
            spacecolumn++;
            cont++;
            if (cont == 3) {
                cont = 0;
                spacerow += 1;
                spacecolumn -= 3;
            }
        }
    }

    /**
     * *
     * Procedimiento; Se encarga de rastrear todo los elementos cuando se hace
     * click a un espacio en cero, almacenando en listas globales los elementos
     * a mostrar tanto los botones con cero y los botones adyacentes a estos
     *
     * @param prow Parametro de posicion en fila del elemento que tiene cero
     * @param pcolumn Parametro de posicion coulmna que tiene cero
     */
    public static void spaceWithCero(int prow, int pcolumn) {
        int upRow = prow - 1, upColumn = pcolumn - 1, i, j;
        int limitRow = prow + 1, limitColumn = pcolumn + 1;

        if (limitRow >= sizeMat) {
            limitRow = prow;
        }

        if (limitColumn >= sizeMat) {
            limitColumn = pcolumn;
        }

        for (i = upRow; i <= limitRow; i++) {
            for (j = upColumn; j <= limitColumn; j++) {
                if ((i >= 0 && j >= 0)) {
                    if (dashboard[i][j] == 0) {
                        addElementCero(i, j);
                    } else {
                        addElemenNumber(i, j);
                    }
                }
            }
        }
        if (isFirstCero) {
            isFirstCero = false;
            checkNeihgbor();
        }
    }

    /**
     * *
     * Procedimiento que se encarga de agregar los elementos con cero dentro de
     * la lista
     *
     * @param prow Parametro de posicion en fila del elemento que tiene cero
     * @param pcolumn Parametro de posicion coulmna que tiene cero
     */
    private static void addElementCero(int prow, int pcolum) {
        String butonToShow;
        butonToShow = "b" + prow + pcolum;
        boolean isAlreadyInserted = listSpacesWithCero.contains(butonToShow);
        if (!isAlreadyInserted) {
            listSpacesWithCero.add(butonToShow);
        }
    }

    /**
     * *
     * Procedimiento que inserta los numeros alrededor de los espacios en cero
     *
     * @param prow Parametro de posicion en fila del elemento que tiene cero
     * @param pcolumn Parametro de posicion coulmna que tiene cero
     */
    private static void addElemenNumber(int prow, int pcolum) {
        String butonToShow;
        butonToShow = "b" + prow + pcolum;
        boolean isAlreadyInserted = listNumbersAround.contains(butonToShow);
        if (!isAlreadyInserted) {
            listNumbersAround.add(butonToShow);
        }
    }

    /**
     * *
     * Pocedimiento que genera vuelve a llamar a la funcion para seguir
     * averiguando si hay mas elementos con ceros
     */
    private static void checkNeihgbor() {
        int row, column, i, limit = listSpacesWithCero.size();
        for (i = 0; i < limit; i++) {
            row = Character.getNumericValue(listSpacesWithCero.get(i).charAt(1));
            column = Character.getNumericValue(listSpacesWithCero.get(i).charAt(2));
            spaceWithCero(row, column);
            limit = listSpacesWithCero.size();
        }
        isFirstCero = true;
    }

    /**
     * *
     * Funcion que retora si el jugador logra ganar la partida
     *
     * @return
     */
    static boolean isWinner() {
        return spacesToWin == 0;
    }

    /**
     * *
     * Procedimiento: Que LLena toda las lista con todos los elelementos del
     * tablero, lo cual significa que el jugador se rinde
     */
    static List<String> giveUpPlay() {
        int row = sizeMat - 1;
        int column = sizeMat - 1;
        String buttonToShow;
        while (row >= 0) {
            if (column >= 0) {
                buttonToShow = "b" + row + column;
                listAllElements.add(buttonToShow);
                column--;
            } else {
                column = sizeMat - 1;
                row--;
            }
        }
        return listAllElements;
    }

    /**
     * *
     * Funcion: Retorna el valor debajo de la matriz, equivalente
     *
     * @param btnName Nombre del boton a analizar
     * @return
     */
    static int checkBackDashboard(String btnName) {
        int row = Character.getNumericValue(btnName.charAt(1));
        int column = Character.getNumericValue(btnName.charAt(2));
        int valueDashboard = dashboard[row][column];
        return valueDashboard;
    }

    /**
     * *
     * Funcion: Retorna la lista de elementos a mostrar
     *
     * @return
     */
    static List<String> getListToShowCero() {
        return listSpacesWithCero;
    }

    /**
     * *
     * Funcion: Retorna la lista de elementos a mostrar
     *
     * @return
     */
    static List<String> getListToShowNumbers() {
        return listNumbersAround;
    }

    /**
     * *
     * Funcion: Rertona la lista con todas las minas
     *
     * @return
     */
    static String[] getAllMines() {
        return arrayMines;
    }

    /**
     * *
     * Limpia las listas
     */
    static void cleanAllLists() {
        listSpacesWithCero.clear();
        listNumbersAround.clear();
    }

    /**
     * *
     * Funcion: Retorna el tamaño de la matriz
     *
     * @return
     */
    static int getDashboardSize() {
        return sizeMat;
    }

    /**
     * *
     * Funcion: resta minas y retorna la cantodad
     *
     * @return
     */
    static int sustractMines() {
        cantMines--;
        return cantMines;
    }

    /**
     * *
     * Funcion que suma las minas y reorna la cantidad
     *
     * @return
     */
    static int addMines() {
        cantMines++;
        return cantMines;
    }

    /**
     * *
     * Funcion que resta los espcios para ganaer cuando el numero 0
     *
     * @return
     */
    static int substractSpacesToWin() {
        spacesToWin--;
        return spacesToWin;
    }

    /**
     * *
     * Funcion: Se enecarga de crear un archovo txt con los nombres de los
     * Ganadores.
     *
     * @param pnumClicks Numero de clicks
     * @param pplayerName Nombre del jugador
     * @return True si se ejecuta de forma satisfactoria
     * @throws IOException
     */
    static boolean serializeWinner(int pnumClicks, String pplayerName) throws IOException {
        File file = new File("Records.txt");
        //Create the file
        if (!file.exists()) {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(pplayerName + " " + pnumClicks);
            writer.close();
        } else {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.newLine();
            writer.write(pplayerName + " " + pnumClicks);
            writer.close();
        }
        pathfile = file.getAbsolutePath();
        return true;
    }

    /**
     * Funcion que retona la lista de los mejores 5 ganadores
     * La lista se muestra en el UI
     */
    public static List<String> winners() throws FileNotFoundException, IOException {
        List<String> elemntsOnFile = new ArrayList();
        List<String> topFive = new ArrayList();
        BufferedReader reader = new BufferedReader(new FileReader(pathfile));
        String line;
        while ((line = reader.readLine()) != null) {
            elemntsOnFile.add(line);
        }
        reader.close();

        String nameWinners[] = new String[elemntsOnFile.size()];
        int scores[] = new int[elemntsOnFile.size()];

        String topNames;
        String spliter[] = new String[2];
        int index = 0, i = 0, aux, j, limit;

        for (String elementsFile : elemntsOnFile) {
            spliter = elementsFile.split("\\s+");
            nameWinners[index] = spliter[0];
            scores[index] = Integer.parseInt(spliter[1]);
            index++;
        }
        for (i = 1; i < scores.length; i++) {
            aux = scores[i];
            topNames = nameWinners[i];
            j = i - 1;
            while ((j >= 0) && (aux < scores[j])) {
                scores[j + 1] = scores[j];
                nameWinners[j + 1] = nameWinners[j];
                j--;
            }
            scores[j + 1] = aux;
            nameWinners[j + 1] = topNames;
        }
        limit = elemntsOnFile.size();
        if (limit > 5) {
            limit = 5;
        }
        for (i = 0; i < limit; i++) {
            topFive.add((i + 1) + ". " + nameWinners[i] + " " + scores[i] + ".pts ");
        }
        return topFive;
    }
    
    static void cleanVariables() {
        listSpacesWithCero.clear();
        listNumbersAround.clear();
        listAllElements.clear();
        listMines.clear();
    }
}
