
/* Seccion de codigo de Usuario */
package compilador; // Paquete en el que se encuentra el archivo .flex
import java_cup.runtime.*;//

%% // Separacion de secciones
/*- Sección de opciones y declaraciones -*/

/*-OPCIONES --*/
%class Analizador // Nombre de la clase .java que se creara al ejecutar este archivo
%line //Permite llevar el conteo de la linea en la que esta analizando
%column //Permite llevar el conteo de la columna en la que esta analizando
%cup // Habilita la compatibilidad con la libreria CUP para el generador sintactico

/*-DECLARACIONES --*/
%{
  private Symbol symbol(int type){ //Crear un nuevo objeto Symbol con información del token actual sin valor
    return new Symbol(type,yyline,yycolumn);
  }
  private Symbol symbol(int type,Object value){//Crear un nuevo objeto Symbol con información del token actual con valor
    return new Symbol(type,yyline,yycolumn,value);
  }
%}
Consonante = [B-DF-HJ-NP-TV-Z] //Se declara el conjunto de consonates a utilizar de acuerdo a ese rango
OperadorS= [+] // Se declara el signo + para concadenar
OperadorP= [.] // Se declara el signo . para concadenar
FinSentencia= [=] // Se declara el signo = para fin de sentencia
Espacio= [" "]// // Se declara los espacios es blanco para ignorarlos

/*- Sección de Reglas Lexicas -*/
%% // Separacion de secciones

{Espacio} {}
//Si encuentra alguna letra que este dentro del rango de las declaras en consonante, devolvera el 
//el token Consonate con el valor que contiene
{Consonante} {return new Symbol(sym.Consonante,yytext());} 
//Si ingresas cualquiera de las vocales me retorna el token vocal
"a" {return  new Symbol(sym.Vocal,yytext());}
"e" {return  new Symbol(sym.Vocal, yytext());}
"i" {return  new Symbol(sym.Vocal, yytext());}
"o" {return  new Symbol(sym.Vocal, yytext());}
"u" {return  new Symbol(sym.Vocal, yytext());}
//Si ingresa el signo + retorna OperedorS
{OperadorS}  {return  new Symbol(sym.OperadorS, yytext()); }
//Si ingresa el . retorna OperedorP
{OperadorP}  {return  new Symbol(sym.OperadorP, yytext()); }
//Si ingresa el signo = retorna FinSentencia
{FinSentencia} {return  new Symbol(sym.FinSentencia, yytext());}
//Y en caso de ingresar un elemento diferenete a los que estandeclarados retornaria error
. { return  new Symbol(sym.error, yytext());}



