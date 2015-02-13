/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.io.*;
import java_cup.parser;
import java_cup.runtime.Symbol;

/**
 *
 * @author katica
 */
class Main {

    /**
     * @param args the command line arguments
     */
    static boolean do_debug_parse = false;

    public static void main(String[] args)throws java.io.IOException{
        String opciones[] = new String[5];
        opciones[0]="-destdir";
        opciones[1]="src\\compilador";
        opciones[2]="-parser"; 
        opciones[3]="AnalizadorSintactico";
        opciones[4]="C:\\Users\\user\\Documents\\NetBeansProjects\\Compilador\\src\\compilador\\cupMio.cup";
        try {
            java_cup.Main.main(opciones);
            }
        catch (Exception e) {
            System.out.print(e);
            }
        String path="C:\\Users\\user\\Documents\\NetBeansProjects\\Compilador\\src\\compilador\\AalizadorLexico.flex";
        File file= new File(path);
//        JFlex.Main.generate(file);
        
          

//        parser parser_obj = new parser(new Analizador(new FileReader(archsin)));
//        System.out.println("l");
//        Symbol parse_tree = null;
//        try {
//            if (do_debug_parse) {
//                System.out.println("if");
//                parse_tree = parser_obj.debug_parse();
//            } else {
//                parse_tree = parser_obj.parse();
//            }
//            System.out.println("Entrada correcta");
//        } catch (Exception e) {
//            System.out.println("Horror");
//        }
//        } catch (Exception ex) {
//            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

}
