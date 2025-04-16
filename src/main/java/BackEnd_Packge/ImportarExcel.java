package BackEnd_Packge;

import BackEnd_Packge.ArrayListClass.ConsultaArrayList;
import BackEnd_Packge.ArrayListClass.EnfermeiroArrayList;
import BackEnd_Packge.ArrayListClass.MedicoArrayList;
import BackEnd_Packge.ArrayListClass.PacienteArrayList;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class ImportarExcel {

    public static void mergeDataFromWorkbook(InputStream wbInput) throws IOException {
        Workbook wb = WorkbookFactory.create(wbInput);
        mergeDataFromSheetToPaciente(wb.getSheetAt(0));
        mergeDataFromSheetToMedico(wb.getSheetAt(1));
        mergeDataFromSheetToEnfermeiro(wb.getSheetAt(2));
        mergeDataFromSheetToConsulta(wb.getSheetAt(3));
    }
    public static void mergeDataFromSheetToPaciente(Sheet shPaciente){
        //Para cada row na sheet, eu crio um objeto e populo ele e adiciono ao Arraylist no final
        for(Row row: shPaciente){
            Endereco e = new Endereco(
                    row.getCell(4).toString(),//Rua
                    Integer.parseInt(row.getCell(5).toString()),//Numero
                    row.getCell(6).toString(),//Bairro
                    row.getCell(7).toString(),//Endereço
                    row.getCell(8).toString(),//Cidade
                    Integer.parseInt(row.getCell(9).toString())//Cep
            );
            ContatoTelEmail c = new ContatoTelEmail(
                    row.getCell(10).toString(),
                    row.getCell(11).toString(),
                    row.getCell(12).toString()
            );
            Responsavel r = new Responsavel(
                    row.getCell(17).toString(),
                    row.getCell(18).toString(),
                    row.getCell(19).toString(),
                    row.getCell(20).toString()
            );
            Paciente p = new Paciente(
                    row.getCell(1).toString(),
                    getLocalDate(row.getCell(2).toString()),
                    e,
                    c,
                    getGeneroFromCell(row,3),
                    Integer.parseInt(row.getCell(13).toString()),
                    getDate(row.getCell(14).toString()),
                    row.getCell(15).toString(),
                    r
            );
            p.setIdPaciente(Long.parseLong(row.getCell(0).toString()));
            PacienteArrayList.addPacientes(p);
        }
    }
    public static void mergeDataFromSheetToMedico(Sheet shMedico){
        for(Row row : shMedico){
            Endereco e = new Endereco(
                    row.getCell(4).toString(),//Rua
                    Integer.parseInt(row.getCell(5).toString()),//Numero
                    row.getCell(6).toString(),//Bairro
                    row.getCell(7).toString(),//Endereço
                    row.getCell(8).toString(),//Cidade
                    Integer.parseInt(row.getCell(9).toString())//Cep
            );
            ContatoTelEmail c = new ContatoTelEmail(
                    row.getCell(10).toString(),
                    row.getCell(11).toString(),
                    row.getCell(12).toString()
            );
            Medico m = new Medico(
                  row.getCell(1).toString(),
                    getLocalDate(row.getCell(2).toString()),
                    e,
                    c,
                    getGeneroFromCell(row,3),
                    Integer.parseInt(row.getCell(12).toString()),
                    getEspecialidades(row,14),
                    Boolean.parseBoolean(row.getCell(15).toString()),
                    Integer.parseInt(row.getCell(16).toString()),
                    row.getCell(17).toString()
            );
            m.setIdMedico(Long.parseLong(row.getCell(0).toString()));
            MedicoArrayList.addPacientes(m);
        }
    }
    public static void mergeDataFromSheetToEnfermeiro(Sheet shEnfermeiro){
        for(Row row: shEnfermeiro){
            Endereco e = new Endereco(
                    row.getCell(4).toString(),//Rua
                    Integer.parseInt(row.getCell(5).toString()),//Numero
                    row.getCell(6).toString(),//Bairro
                    row.getCell(7).toString(),//Endereço
                    row.getCell(8).toString(),//Cidade
                    Integer.parseInt(row.getCell(9).toString())//Cep
            );
            ContatoTelEmail c = new ContatoTelEmail(
                    row.getCell(10).toString(),
                    row.getCell(11).toString(),
                    row.getCell(12).toString()
            );
            Enfermeiro enf = new Enfermeiro(
                    row.getCell(1).toString(),
                    getLocalDate(row.getCell(2).toString()),
                    e,
                    c,
                    getGeneroFromCell(row,3),
                    row.getCell(15).toString(),
                    Integer.parseInt(row.getCell(14).toString()),
                    Boolean.parseBoolean(row.getCell(13).toString())
            );
            enf.setIdEnfermeiro(Long.parseLong(row.getCell(0).toString()));
            EnfermeiroArrayList.addPacientes(enf);
        }
    }
    public static void mergeDataFromSheetToConsulta(Sheet shConsulta){
        for(Row row: shConsulta){
            ConsultaMedica cm = new ConsultaMedica(
                 Long.parseLong(row.getCell(0).toString()),
                    Long.parseLong(row.getCell(1).toString()),
                    Long.parseLong(row.getCell(2).toString()),
                    row.getCell(3).toString(),
                    row.getCell(4).toString(),
                    row.getCell(5).toString(),
                    Boolean.parseBoolean(row.getCell(6).toString())

            );
            ConsultaArrayList.ListaDeConsulta.add(cm);
        }
    }
    private static Date getDate(String dataParaConverter) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false); // Garante que datas inválidas como 32/01/2023 gerem exceção
            return sdf.parse(dataParaConverter.trim());
        } catch (ParseException e) {
            System.out.println("Erro ao converter a data: " + e.getMessage());
        }
        return null;
    }
    private static LocalDate getLocalDate(String DataParaConverter){
        try{
            LocalDate dataN = LocalDate.parse(
                    DataParaConverter.trim(),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy")
            );

            return dataN;
        }catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private static Genero getGeneroFromCell(Row r, int indexGenero){
        if(Objects.equals(r.getCell(indexGenero).toString(), "MASCULINO")){
            return Genero.MASCULINO;
        }else{
            return Genero.FEMININO;
        }
    }
    private static String[] getEspecialidades(Row r, int indexEspecialidades){

        return new String[];
    }
}
