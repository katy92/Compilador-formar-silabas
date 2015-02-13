/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Ejecutar {

    public static void main(String[] args) throws Exception {
        java.util.Scanner in = new Scanner(System.in);
        int valor;
        do {
            System.out.println("Elija una opcion: ");
            System.out.println("1) Generar");
            System.out.println("2) Ejecutar");
            System.out.println("3) Salir");
            System.out.print("Opcion: ");
            valor = in.nextInt();
            switch (valor) {
                case 1: {
                    System.out.println("\n*** Generando Archivo Sintactico***\n");
                    String opciones[] = new String[5];
                    opciones[0] = "-destdir"; //Es para decir donde quieres almacenar lo creado
                    opciones[1] = "src\\compilador";//Especifica el lugar 
                    opciones[2] = "-parser"; 
                    opciones[3] = "AnalizadorSintactico";//El nombre del archivo a crear
                    //Esta es la direccion donde esta el archivo .cup
                    opciones[4] = "C:\\Users\\user\\Documents\\NetBeansProjects\\Compilador\\src\\compilador\\cupMio.cup";
                    try {
                        java_cup.Main.main(opciones); //Ejecutar el archivo .cup
                    } catch (Exception e) {
                        System.out.print(e);
                    }
                    System.out.println(" ");
                    //Direccion de donde esta el archivo .flex
                    String path = "C:\\Users\\user\\Documents\\NetBeansProjects\\Compilador\\src\\compilador\\AalizadorLexico.flex";
                    //
                    File file = new File(path);
                    System.out.println("\n*** Generando Archivo Lexico***\n");
                    //Comando para ejecutar archivo .flex
                    JFlex.Main.generate(file);

                    System.out.println("Archivos Generados!");
                    break;
                }
                case 2: {
                    /*  Ejecutamos el analizador lexico y sintactico
                     sobre un archivo de pruebas. 
                     */
                    Scanner leer = new Scanner(System.in);
                    String entrada;
                    System.out.println("Ingrese los datos a evaluar");
                    entrada = leer.nextLine();
                    File ar = new File("C:\\Users\\user\\Documents\\NetBeansProjects\\Compilador\\src\\compilador\\dato.text");
                    BufferedWriter bw;
                    if (ar.exists()) {
                        ar.delete();
                        bw = new BufferedWriter(new FileWriter(ar));
                        bw.write(entrada);
                        bw.close();
                        System.out.println("__*__*_ Resultado _*__*__");
                         try {
                        AnalizadorSintactico asin = new AnalizadorSintactico(new Analizador(new FileInputStream(ar)));
                        asin.parse();

                        System.out.println("Archivo Compilado!");
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Ejecutar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        System.out.println("[*-*- Finalizo proceso -*-*]");
                    }
                    break;
                 
                }
                case 3: {
                    System.out.println("Gracias por usar el programa!");
                    break;
                }
                default: {
                    System.out.println("Opcion no valida!");
                    break;
                }
            }
        } while (valor != 3);

    }

}
