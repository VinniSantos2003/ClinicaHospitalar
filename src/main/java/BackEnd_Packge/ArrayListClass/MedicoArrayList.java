/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd_Packge.ArrayListClass;

import BackEnd_Packge.Medico;
import java.util.ArrayList;

/**
 *
 * @author -
 */
public class MedicoArrayList {
    public static ArrayList<Medico> ListaDeMedicos = new ArrayList<Medico>();
    
    
    public static void addPacientes(Medico m){
        ListaDeMedicos.add(m);
    }
    public static ArrayList<Medico> getArrayList(){
        return ListaDeMedicos;
    }
}
