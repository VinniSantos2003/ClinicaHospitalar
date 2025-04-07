/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd_Packge.ArrayListClass;

import BackEnd_Packge.Enfermeiro;
import java.util.ArrayList;

/**
 *
 * @author -
 */
public class EnfermeiroArrayList {
            public static ArrayList<Enfermeiro> ListaDeEnfermeiro = new ArrayList<Enfermeiro>();
    
    
    public static void addPacientes(Enfermeiro e){
        ListaDeEnfermeiro.add(e);
    }
    public static ArrayList<Enfermeiro> getArrayList(){
        return ListaDeEnfermeiro;
    }
}
