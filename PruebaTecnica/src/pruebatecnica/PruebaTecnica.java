package pruebatecnica;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * @author Shirley Muelle
 */
public class PruebaTecnica {

    void Ejercicio1() {
        //se pide la cadena
        String VectorCadena = JOptionPane.showInputDialog("Favor Digite el vector, separados por coma los elementos \n ejemplo (15,7,2,1)");
        int permutacion = Integer.parseInt(JOptionPane.showInputDialog("Favor Digite el numero de permutaciones"));
        //se separa por coma
        String[] vectorCompleto = VectorCadena.split(",");

        int anterior = 0, i = 0;

        do {

        } while (vectorCompleto.length == i);

    }

    void Ejercicio2() {
        int numA = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero entero A"));
        int numB = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero entero B"));
        int numC = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero entero C"));
        if (((numA > numB) && (numA > numC))) {
            JOptionPane.showMessageDialog(null, "El numero mayor es A con un valor de " + numA, "Respuesta Funcion 2", JOptionPane.WARNING_MESSAGE);
        } else if ((numB > numA) && (numB > numC)) {
            JOptionPane.showMessageDialog(null, "El numero mayor es B con un valor de " + numB, "Respuesta Funcion 2", JOptionPane.WARNING_MESSAGE);
        } else if ((numC > numB) && (numC > numA)) {
            JOptionPane.showMessageDialog(null, "El numero mayor es C con un valor de " + numC, "Respuesta Funcion 2", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Hay numero reptidos, que igualan el numero mayor", "Respuesta Funcion 2", JOptionPane.WARNING_MESSAGE);
        }
    }

    void Ejercicio3() {

        //se pide la cadena
        String VectorCadena = JOptionPane.showInputDialog("Favor Digite el vector, separados por coma los elementos \n ejemplo (15,7,2,1)");
        //se separa por coma
        String[] vectorCompleto = VectorCadena.split(",");
        String CadenaPar = "", CadenaImpar = "";
        //se divide el vector por par e impar
        for (String vectorCompleto1 : vectorCompleto) {
            int tempo = Integer.parseInt(vectorCompleto1);
            System.out.print(tempo);
            if ((tempo % 2) == 0) {
                CadenaPar += tempo + ",";
            } else {
                CadenaImpar += tempo + ",";
            }
        }
        //se separa por coma las cadenas de par e impar
        String[] VectorCadenaPar = CadenaPar.split(",");
        String[] VectorCadenaInpar = CadenaImpar.split(",");
        int vectorPar[] = new int[VectorCadenaPar.length];
        int vectorInPar[] = new int[VectorCadenaInpar.length];

        //se convierte a entera los vectores de las cadenas de par e impar
        for (int i = 0; i < VectorCadenaPar.length; i++) {
            vectorPar[i] = Integer.parseInt(VectorCadenaPar[i]);
        }
        for (int i = 0; i < VectorCadenaInpar.length; i++) {
            vectorInPar[i] = Integer.parseInt(VectorCadenaInpar[i]);
        }
        //Se ordenan por la funcion
        vectorPar = funcionBurbuja(vectorPar);
        vectorInPar = funcionBurbuja(vectorInPar);
        //se muestra el resultado
        String cadenaFinal = "";
        for (int i = 0; i < vectorPar.length; i++) {
            cadenaFinal += vectorPar[i] + ",";
        }
        for (int i = 0; i < vectorInPar.length; i++) {
            cadenaFinal += vectorInPar[i] + ",";
        }
        cadenaFinal = cadenaFinal.substring(0, cadenaFinal.length() - 1);
        JOptionPane.showMessageDialog(null, "Cadena Resultante es \n" + cadenaFinal, "Respuesta Funcion 3", JOptionPane.WARNING_MESSAGE);

    }

    void Ejercicio4() {
        String cadena = JOptionPane.showInputDialog("Digite el nombre de la empresa");
        char[] caracteres = cadena.toCharArray();
        int encontrado=0;
        for (int i = 0; i < caracteres.length; i++) {
            char caracter = caracteres[i];
            if (((caracter == 's') || (caracter == 'S')) && (i < (caracteres.length - 2))) {
                if (((caracteres[i + 1] == 'o') || (caracteres[i + 1] == 'o')) && ((caracteres[i + 2] == 'h') || (caracteres[i + 2] == 'H'))) {
                encontrado=1;
                }
            }
        }
        if(encontrado==1){
            JOptionPane.showMessageDialog(null, "Exitoso \n Las letras *soh* aparecen en el nombre de la empresa", "Respuesta Funcion 4", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Fracaso \n Las letras *soh* NO aparecen en el nombre de la empresa", "Respuesta Funcion 4", JOptionPane.WARNING_MESSAGE);
        }

    }

    public static void main(String[] args) {

        PruebaTecnica Procedimientos = new PruebaTecnica();
        int menu;
        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog("Opciones del menu " + "\n"
                    + "1. Ejercicio 1 (40 Puntos)" + "\n"
                    + "2. Ejercicio 2 (25 Puntos)" + "\n"
                    + "3. Ejercicio 3 (25 Puntos)" + "\n"
                    + "4. Ejercicio 4 (40 Puntos)" + "\n"
                    + "5. Cerrar Sesion" + "\n"));
            switch (menu) {
                case (1):
                    Procedimientos.Ejercicio1();
                    break;
                case (2):
                    Procedimientos.Ejercicio2();
                    break;
                case (3):
                    Procedimientos.Ejercicio3();
                    break;
                case (4):
                    Procedimientos.Ejercicio4();
                    break;
                case (5):
                    int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Cerrar Sesion?", "Alerta!", JOptionPane.YES_NO_OPTION);
                    //si respuesta es igual a no, cambiar la variable menu para que siga corriendo el programa
                    if (resp == 1) {
                        menu = 6;
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Digite una opcion del listado, Favor intente Nuevamente", "Opcion Invalida", JOptionPane.WARNING_MESSAGE);
                    break;
            }
        } while (menu != 5);
    }

    //Funciones
    public int[] funcionBurbuja(int[] arreglo) {
        for (int x = 0; x < arreglo.length; x++) {
            for (int y = 0; y < arreglo.length - 1; y++) {
                int elementoActual = arreglo[y],
                        elementoSiguiente = arreglo[y + 1];
                if (elementoActual > elementoSiguiente) {
                    arreglo[y] = elementoSiguiente;
                    arreglo[y + 1] = elementoActual;
                }
            }
        }

        return arreglo;
    }
}
