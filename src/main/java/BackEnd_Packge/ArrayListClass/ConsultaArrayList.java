/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd_Packge.ArrayListClass;

import BackEnd_Packge.ConsultaMedica;
import java.util.ArrayList;

/**
 *
 * @author -
 */
public class ConsultaArrayList {
       public static ArrayList<ConsultaMedica> ListaDeConsulta = new ArrayList<ConsultaMedica>();
  
    
    public static void addPacientes(ConsultaMedica c){
        ListaDeConsulta.add(c);
    }
    public static ArrayList<ConsultaMedica> getArrayList(){
        return ListaDeConsulta;
    }
}
