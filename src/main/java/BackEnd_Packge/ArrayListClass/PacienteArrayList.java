/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd_Packge.ArrayListClass;

import BackEnd_Packge.Paciente;
import java.util.ArrayList;

/**
 *
 * @author -
 */
public class PacienteArrayList {

    public static ArrayList<Paciente> ListaDePacientes = new ArrayList<>();
    
    
    public static void addPacientes(Paciente p){
        ListaDePacientes.add(p);
    }
    public static ArrayList<Paciente> getArrayList(){
        return ListaDePacientes;
    }

}

