

/*
 * Copyright (C) 2016 Daniel Losada - Carlos P. Bermejo - Eduardo López 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package ProyectoJudoSem15;

import java.util.Scanner;

/**
 * 15/12/2016
 * Proyecto Semana 15
 * Asignatura Programción básica (BLOC 1)
 * 
 * El proyecto será para la federación catalana de Judo
 * por lo que la interfaz estará en catalán. 
 * El nombre de todas las variables,
 * instancias, referencias... etc estarán en catalán.
 * 
 * El código debe ajustarse a los contenidos impartidos hasta la semana 13
 * de la asignatura Programación Básica ( BLOC 1 )
 * DAW
 * @author grup1
 * @version 151220161644
 * prueba desde ubuntu.
 */
public class S15_prj4_e1_LopezB {

    // Constantes
    // Límites para el Id
    public static final int ID_MIN = 1;
    public static final int ID_MAX = 2000;
    //Posición que ocupará el ID en el array
    public static final int POS_ID = 0;
    
    // Límites para la edad
    public static final int EDAT_MIN = 5;
    public static final int EDAT_MAX = 17;
    //Posición que ocupará la edad en array
    public static final int POS_EDAT = 1;
    
    // Género niño o niña
    public static final int ID_NOIA = 1;
    public static final String NOIA = "noia";
    public static final int ID_NOI = 2;
    public static final String NOI = "noi";
    //Posición que ocupará el género en el array
    public static final int POS_GENERE = 2;    
    
    // Cinturones
    public static final String BLANC = "Blanc";
    public static final int I_BLANC = 1;
     
    public static final String GROC = "Groc";
    public static final int I_GROC = 2;
    
    public static final String TARONJA = "Taronja";
    public static final int I_TARONJA = 3;
    
    public static final String VERD = "Verd";
    public static final int I_VERD = 4;
    
    public static final String BLAU = "Blau";
    public static final int I_BLAU = 5;
    
    public static final String MARRO = "Marró";
    public static final int I_MARRO = 6;
    
    // Posición que ocupará el cinturón en el array
    public static final int POS_CINTURO = 3;  
    
    //Posición que ocupará el peso en el array
    public static final int POS_PES = 4;
    
    // Fecha
    public static final int MAX_ANY = 2100;
    public static final int MIN_ANY = 2016;
    public static final int MESOS = 12;
    public static final int DIES = 31;
    
    //Posición que ocupará la fecha en el array
    public static final int POS_DATA = 5;
    
    // Máximos intentos por cada entrada de datos
    // ... si se supera este valor el programa finalizará
    public static final int MAX_INTENTS = 3;
    
    // Número total de judokas que almacenamos en el array
    public static final int MAX_JUDOKAS = 10;
    
    // Tipos de errores
    public static final String STR_ID_ERROR = "Error en id. Valors vàlids (" + ID_MIN + " a " + ID_MAX + ").";   
    public static final String STR_EDAT_ERROR = "Error en edat Valors vàlids (" + EDAT_MIN + " a " + EDAT_MAX + ").";
    public static final String STR_GENERE_ERROR = "Error en genere. noia (1) o noi (2).";
    public static final String STR_CINTURO_ERROR ="Error en cinturò. Valors vàlids (" + I_BLANC + " a " + I_MARRO + ").";
    public static final String STR_PES_ERROR = "Error en pes.";
    public static final String STR_DIA_ERROR = "Error en dia.";
    public static final String STR_MES_ERROR = "Error en mes.";
    public static final String STR_ANY_ERROR = "Error en any. Valors vàlids (" + MIN_ANY + " a " + MAX_ANY + ").";
    public static final String STR_ERROR_IN = "\n--- Error a l'entrada. --\n";
    public static final String STR_ERROR = "\n --- Per ERROR en l'entrada de dades aquest judoka no sera introuit. ---\n ";
    
    
    // Fecha
    public static final String VERSION = "081220161644";
    
    public static void main(String[] args)  {   
        // Nuestras variables:
        // id del judoka, ha de estar entre 1 y 2000
        int id = 0;
        // la edad, comprendida entre 5 y 17 años
        int edat = 0;
        // nen = 2 o nena = 1
        int genere = 0;
        // cinturón del 1 blanco al 6 marrón
        int cinturo = 0;
        // el peso
        double pes = 0.0;
        // fecha repartido en día/mes/año
        int dia = 0, mes = 0, any = 0;
        // Boolean para el control de datos, 
        boolean correct = false;
           
        String msg_error = "";  
        // Intentos por cada entrada de dato
        int intents = 0;
        // Número de judokas
        int num_judokas = 0;
        // Repetir la entrada para otro judoka
        boolean rep = false;
        // Auxiliar pare recoger opción de usuario
        int aux = 0;
        // Auxiliar para imprimir el mensaje del
        // ...número de judokas introducidos
        String s_aux = "";

        // Array para guardar los datos de nuestro judoka
        // Por cada juduka guarda, ID - EDAT - GENERO - CINTURON - PESO - DIA/MES/AÑO
        String [][] judokas = new String [MAX_JUDOKAS][6];
              
        // scanner para la entrada de datos
        Scanner in = new Scanner ( System.in ); 
        
        // Mostramos un menú inicial
        System.out.println ("\t\t -- Federaciò de Judo -- \n");
        System.out.println ("Entrada de dades del Judoka -------");
        
        // do / while externo, bucle principal del programa, se repetirá
        // ...mientras se produzcan nuevas entradas para otro judoka.
        do {
            intents = 0;
            // Entrada de datos para el id
            do {        
                // Solicitamos id del judoka
                System.out.print ("id?: ");
                // Para id se espera un entero
                correct = in.hasNextInt(); 	        
                if ( correct ) {
                    // Se ha teclado un entero para id
                    // ... almacenamos el valor en su variable
                    id = in.nextInt();
                    // Si la ID no es correcta,                        
                    // ...asignamos correcto a false para repetir la entrada
                    // ...del dato.
                    if ( id < ID_MIN || id > ID_MAX ) correct = false;	            
                }	        
                in.nextLine();

                // No vale else, ya que no evaluaría la condición
                // ... de correct = false, para id fuera de rango
                // Si correct = false, imprimimos el tipo de error
                // ... e incrementamos el número de intentos.
                if ( !correct ) {	        
                        System.out.println (STR_ERROR_IN);
                        msg_error = STR_ID_ERROR;
                        System.out.println (msg_error); 
                        intents++;
                }  
            } while ( !correct && intents < MAX_INTENTS );

            // El flujo del programa continúa si
            // ... el dato anterior tecleado es correcto Y el número de
            // intentos no ha superado el límite establecido
            // Esta misma estructura se repetirá para cada entrada de datos.
            if ( correct  && intents < MAX_INTENTS) {
                    intents = 0;
                    do {
                        System.out.print ("edad?: ");
                        correct = in.hasNextInt();        		
                        if ( correct ) {	        	
                            edat = in.nextInt();
                            // Igual que antes, si la edad no es correcta,                        
                            // ...asignamos correcto a false para repetir la entrada
                            // ...del dato.
                            if ( edat < EDAT_MIN || edat > EDAT_MAX ) correct = false;		            		          
                        }        		
                        in.nextLine();	        
                        if ( !correct ) {
                            System.out.println (STR_ERROR_IN);
                            msg_error = STR_EDAT_ERROR;
                            System.out.println (msg_error); 
                            intents++;
                        } 
                    } while ( !correct && intents < MAX_INTENTS);			 
            }

            // Se repite la estructura anterior...
            // Se comprueba si es noia o noi
            if ( correct && intents < MAX_INTENTS ) {
                    intents = 0;
                    do {
                        System.out.print ("Es noia (1) o noi (2)?: ");
                        correct =  in.hasNextInt();
                        if ( correct ) {
                            genere = in.nextInt();
                            if ( genere != ID_NOIA && genere != ID_NOI )  correct = false;		            		           
                        }		        
                        in.nextLine();		        
                        if ( !correct ) {
                            System.out.println (STR_ERROR_IN);
                            msg_error = STR_GENERE_ERROR;
                            System.out.println (msg_error); 
                            intents++;
                        }
                    }while ( !correct && intents < MAX_INTENTS);
            }
            // Para el cinturón
            if ( correct && intents < MAX_INTENTS ) {
                    intents = 0;
                    do {
                        System.out.println ("Quin color de cinturó té?: ");
                        System.out.print("\tBlanc(1)\n\tGroc(2)\n\tTaronja(3)\n\tVerd(4)\n\tBlau(5)\n\tMarró(6)\n: ");
                         correct =  in.hasNextInt();		        
                        if ( correct ) {
                            cinturo = in.nextInt();
                            if ( cinturo < I_BLANC || cinturo > I_MARRO ) correct = false;		            
                        }		        
                        in.nextLine();		        
                        if ( !correct ) {
                            System.out.println (STR_ERROR_IN);
                            msg_error = STR_CINTURO_ERROR;
                            System.out.println (msg_error); 
                            intents++;
                        }
                    } while (!correct && intents < MAX_INTENTS);
            }
            // El peso
            if ( correct && intents < MAX_INTENTS ) {
                    intents = 0;
                    do {      
                        System.out.print ("pes?: "); 
                        correct =  in.hasNextDouble ();
                        if ( correct ) {
                            pes = in.nextDouble();
                            if ( pes <= 0 ) correct = false;		            		           
                        }		        
                        in.nextLine();		        
                        if ( !correct ) {
                            System.out.println (STR_ERROR_IN);
                            msg_error = STR_PES_ERROR;
                            System.out.println (msg_error);
                            intents++;		        	
                        }  		        
                    } while ( !correct && intents < MAX_INTENTS );
            }
            // Fecha - día
            if ( correct && intents < MAX_INTENTS ) {
                    intents = 0;
                    do { 
                        System.out.print("\nData de pes?:\n día?: ");
                        correct =  in.hasNextInt();
                        if ( correct ) {
                            dia = in.nextInt();
                            if ( dia <= 0 || dia > DIES )  correct = false;		          
                        }
                        in.nextLine();
                        if ( !correct ) {
                            intents++;
                            System.out.println (STR_ERROR_IN);
                            msg_error = STR_DIA_ERROR;
                            System.out.println (msg_error); 
                        }		        
                    } while ( !correct && intents < MAX_INTENTS );
            }
            // Mes
            if ( correct && intents < MAX_INTENTS ) {
                    intents = 0;
                    do { 	    
                        System.out.print (" mes?: ");
                        correct =  in.hasNextInt();
                        if ( correct ) {
                            mes = in.nextInt();
                            if ( mes <= 0 || mes > MESOS ) correct = false;
                        }		        
                        in.nextLine();
                        if ( !correct ) {
                            System.out.println (STR_ERROR_IN);
                            msg_error = STR_MES_ERROR;
                            System.out.println (msg_error); 
                            intents++;		        	
                        }		        
                    } while ( !correct && intents < MAX_INTENTS );
            }
            // Año
            if ( correct && intents < MAX_INTENTS ) {
                    intents = 0;
                    do {    
                        System.out.print (" any?: ");
                        correct =  in.hasNextInt();
                        if ( correct ) {
                            any = in.nextInt();
                            if ( any < MIN_ANY || any > MAX_ANY ) correct = false;		                         
                        }
                        in.nextLine();
                        if ( !correct ) {
                            System.out.println (STR_ERROR_IN);
                            msg_error = STR_ANY_ERROR;
                            System.out.println (msg_error); 
                            intents++;
                        }		        
                    } while ( !correct && intents < MAX_INTENTS );
            }		        

            // Si el programa ha llegado aquí con correct a true, mostramos resultados
            if ( correct ) {
                // Si todo ha sido correcto mostramos los resultados por pantalla
                String str_genere, str_cinturo ="", str_data;

                // Creamos la cadena de texto según sea noi o noia
                if ( genere == 1 ) str_genere = NOIA;
                else str_genere = NOI;

                // Creamos la cadena de texto para el cinturón
                switch ( cinturo ) {
                    case I_BLANC: str_cinturo = BLANC;
                            break;
                    case I_GROC: str_cinturo = GROC;
                            break;
                    case I_TARONJA: str_cinturo = TARONJA;
                            break;
                    case I_VERD: str_cinturo = VERD;
                            break;
                    case I_BLAU: str_cinturo = BLAU;
                            break;
                    case I_MARRO: str_cinturo = MARRO;
                            break;
                }

                // Creamos la cadena de texto para la fecha
                str_data = dia +"/" + mes + "/" + any;

                // Guardamos los judokas en el array
                // El array judokas es de tipo String, 
                // ...por lo que para guardar en el array de String
                // ...los valores id (int), edat(int), pes(float)
                // ...debemos transformas esos valores en cadenas 
                // ...de texto tipo String.
                // Usamos el método valueOf de la clase String.
                // ...este método transforma en tipo String un valor numérico.
                // ...Es decir si tenemos int valor = 1;
                // ...String valorNumerico = String.valueOf(valor);
                // ...valorNumerico contendrá la cadena de texto "1"
                // ...PERO COMO TIPO STRING.
                // http://docs.oracle.com/javase/7/docs/api/java/lang/String.html#valueOf%28int%29
                judokas[num_judokas][POS_ID] = String.valueOf(id);
                judokas[num_judokas][POS_EDAT] = "\t" + String.valueOf(edat);
                judokas[num_judokas][POS_GENERE] = "\t" + str_genere;
                judokas[num_judokas][POS_CINTURO] = "\t\t" + str_cinturo;
                judokas[num_judokas][POS_PES] = "\t\t" + String.valueOf(pes);
                judokas[num_judokas][POS_DATA] = "\t" + str_data;

                // Sumamos un judoka más al total 
                num_judokas++;
            } 
            else  {
                // Si la entrada de datos del judoka es incorrecta imprimos el error producido.
                System.out.println (STR_ERROR); 	                
            }

            // Preguntamos si queremos introducir otro judoka simpre y cuando no 
            // ...hayamos llegado al límite
            if ( num_judokas < MAX_JUDOKAS ) {
                do {
                    System.out.print ("Desitja introduir dades per a un altra judoka? SÍ(1) / NO(0): ");
                    correct =  in.hasNextInt();
                    if ( correct ) {
                        aux = in.nextInt();
                        if ( aux == 0 ) rep = false;
                        else if ( aux == 1 ) rep = true;
                        else correct = false;
                    }		        
                    in.nextLine();		        
                    if ( !correct ) {
                            System.out.println ("Si us plau, escriviu 1 per a una altre entrada de dades, 0 en cas contrari.");
                    }
                }while ( !correct );
            }
            else {
                System.out.println ("Dades completes.");
            }
                
        }while ( rep && num_judokas < MAX_JUDOKAS );
        
        // Mostramos todos los judokas introducidos.
        System.out.print ("\nid\tedat\tgenere\t\tcinturó\t\tpes\tdata pes");
        for ( int i = 0; i < num_judokas; i++ ) {
            System.out.print ("\n");
            for ( int j = 0; j < 6; j++)
                System.out.print (judokas[i][j]);
        }
        
        // Mostramos el número o números de judokas introducidos
        if ( num_judokas > 1 ) s_aux = "S'han introduït " + num_judokas + " judokas.";
        else if (num_judokas == 1 ) s_aux = "S'ha introduït " + num_judokas + " judoka.";
        else s_aux = "No s'ha introduït cap judoka.";
        
        System.out.println ("\n\n" + s_aux);
        
        // Preguntamos si queremos ordenar el listado de judokas
        // ...Sólo se preguntará si hay más de un judoka.
        correct = false;
        while (!correct && num_judokas > 1) {
            System.out.print ("Vols ordenar? SÍ(1) / NO(0): ");
            correct = in.hasNextInt(); 
            if ( correct ) {
                aux = in.nextInt();
                if ( aux == 1 ) {
                    // Ordenamos mediante el método de la burbuja 
                    // ... en función de la edad.
                    //Bucle extern.
                    //S'anirà posant a cada posició tractada, començant per la 0,
                    //el valor més baix que es trobi.
                    for (int i = 0; i < num_judokas - 1; i++) {
                    //Bucle intern.
                    //Se cerca entre la resta de posicions quin és el valor més baix.
                        for(int j = i + 1; j < num_judokas; j++) {
                            //La posició tractada té un valor més alt que el de la cerca. Els intercanviem.
                            // Los valores guardados en el array judokas son de tipo String
                            // ... por lo que para compararlos como enteros debemos usar 
                            // ... el método Integer.parseInt de la clase Integer.
                            // El método parseInt transfora a su valor en entero una cadena de texto.
                            // ... Es decir, si tenemos String valor = "1";
                            // ... El método Integer.parseInt ( valor ) retornará el contenido
                            // ... del String valor en su valor como tipo int.
                            // ... https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html#parseInt%28java.lang.String%29
                            // Debemos usar también el método trim() de la clase String para eliminar 
                            // ... espacios en blanco. 
                            // ... Es decir, en el caso que tengamos String valor = "   2    ";
                            // ... El método trim() retornará el String sin los espacios.
                            // ... valor = valor.trim() -> valor pasa a tener "2"; 
                            // ... https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#trim%28%29
                            if ( Integer.parseInt( judokas[i][POS_EDAT].trim() ) > Integer.parseInt(judokas[j][POS_EDAT].trim() ) ) {
                                //Per intercanviar valors cal una variable auxiliar.
                                String [] canvi = judokas[i];
                                judokas[i] = judokas[j];
                                judokas[j] = canvi;
                            }
                        }
                    }
                    
                    // Volvemos a presentar los resultados pero ordenados
                    System.out.print ("\nid\tedat\tgenere\t\tcinturó\t\tpes\tdata pes");
                    for ( int i = 0; i < num_judokas; i++ ) {
                        System.out.print ("\n");
                        for ( int j = 0; j < 6; j++)
                            System.out.print (judokas[i][j]);
                    }
                    System.out.print ("\n");
                }              
            }		        
            else {
                System.out.println ("Si us plau, escriviu 1 per ordenar les dades, 0 en cas contrari.");
            }
            in.nextLine();            
        } // Fin while ordenar Judokas
    }
 } 
  