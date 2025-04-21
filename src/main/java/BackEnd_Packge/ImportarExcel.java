package BackEnd_Packge;

import BackEnd_Packge.ArrayListClass.ConsultaArrayList;
import BackEnd_Packge.ArrayListClass.EnfermeiroArrayList;
import BackEnd_Packge.ArrayListClass.MedicoArrayList;
import BackEnd_Packge.ArrayListClass.PacienteArrayList;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class ImportarExcel {

    public static void  mergeDataFromWorkbook(InputStream wbInput) throws IOException {
        //InputStream wbInput = caminho do arquivo xlsx a ser aberto
        Workbook wb = WorkbookFactory.create(wbInput);
        mergeDataFromSheetToPaciente(wb.getSheetAt(0));
        mergeDataFromSheetToMedico(wb.getSheetAt(1));
        mergeDataFromSheetToEnfermeiro(wb.getSheetAt(2));
        mergeDataFromSheetToConsulta(wb.getSheetAt(3));

    }
    public static void mergeDataFromSheetToPaciente(Sheet shPaciente){
        //Para cada row na sheet, eu crio um objeto e populo ele e adiciono ao Arraylist no final
        int linha = 0;
        for(Row row: shPaciente){
            if(linha == 0){
                linha++;
            }else{
                Endereco e = new Endereco(
                        row.getCell(4).toString(),//Rua
                        Integer.parseInt(treatNumber(row,5)),//Numero
                        row.getCell(6).toString(),//Bairro
                        row.getCell(7).toString(),//Endereço
                        row.getCell(8).toString(),//Cidade
                        Integer.parseInt(treatNumber(row,9))//Cep
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
                        getLocalDate(row.getCell(2)),//Problema ao puxar data, esta vindo null, isso da problema ao montar tabela
                        e,
                        c,
                        getGeneroFromCell(row,3),
                        Integer.parseInt(treatNumber(row,13)),
                        getLocalDate(row.getCell(14)),//Problema ao puxar data
                        row.getCell(15).toString(),
                        r
                );
                p.setIdPaciente(Long.parseLong(row.getCell(0).toString()));
                PacienteArrayList.ListaDePacientes.add(p);
            }


        }
    }
    public static void mergeDataFromSheetToMedico(Sheet shMedico){
        int linha = 0;
        for(Row row : shMedico){
            if(linha == 0){
                linha++;
            }else {
                Endereco e = new Endereco(
                        row.getCell(4).toString(),//Rua
                        Integer.parseInt(treatNumber(row, 5)),//Numero
                        row.getCell(6).toString(),//Bairro
                        row.getCell(7).toString(),//Endereço
                        row.getCell(8).toString(),//Cidade
                        Integer.parseInt(treatNumber(row, 9))//Cep
                );
                ContatoTelEmail c = new ContatoTelEmail(
                        row.getCell(10).toString(),
                        row.getCell(11).toString(),
                        row.getCell(12).toString()
                );
                Medico m = new Medico(
                        row.getCell(1).toString(),
                        getLocalDate(row.getCell(2)),
                        e,
                        c,
                        getGeneroFromCell(row, 3),
                        Integer.parseInt(treatNumber(row, 13)),
                        getEspecialidades(row, 14),
                        Boolean.parseBoolean(row.getCell(15).toString()),
                        Integer.parseInt(treatNumber(row, 16)),
                        row.getCell(17).toString()
                );
                m.setIdMedico(Long.parseLong(row.getCell(0).toString()));
                MedicoArrayList.addPacientes(m);
            }
            }

    }
    public static void mergeDataFromSheetToEnfermeiro(Sheet shEnfermeiro){
        int linha = 0;
        for(Row row: shEnfermeiro){
            if(linha == 0){
                linha++;
            }else{
                Endereco e = new Endereco(
                        row.getCell(4).toString(),//Rua
                        Integer.parseInt(treatNumber(row,5)),//Numero
                        row.getCell(6).toString(),//Bairro
                        row.getCell(7).toString(),//Endereço
                        row.getCell(8).toString(),//Cidade
                        Integer.parseInt(treatNumber(row,9))//Cep
                );
                ContatoTelEmail c = new ContatoTelEmail(
                        row.getCell(10).toString(),
                        row.getCell(11).toString(),
                        row.getCell(12).toString()
                );
                Enfermeiro enf = new Enfermeiro(
                        row.getCell(1).toString(),
                        getLocalDate(row.getCell(2)),
                        e,
                        c,
                        getGeneroFromCell(row,3),
                        row.getCell(15).toString(),
                        Integer.parseInt(treatNumber(row,14)),
                        Boolean.parseBoolean(row.getCell(13).toString())
                );
                enf.setIdEnfermeiro(Long.parseLong(row.getCell(0).toString()));
                EnfermeiroArrayList.addPacientes(enf);
            }

        }
    }
    public static void mergeDataFromSheetToConsulta(Sheet shConsulta){
        int linha = 0;
        for(Row row: shConsulta){
            if(linha == 0){
                linha++;
            }else{
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
    private static LocalDate getLocalDate(Cell cell) {
        if (cell == null) return null;

        try {
            if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
                // Célula é um número e está formatada como data
                return cell.getLocalDateTimeCellValue().toLocalDate();
            } else if (cell.getCellType() == CellType.STRING) {
                // Célula é uma string — tentar parsear manualmente
                String rawValue = cell.getStringCellValue().trim().replace(".", ""); // remove ponto se houver

                List<DateTimeFormatter> formatosPossiveis = Arrays.asList(
                        DateTimeFormatter.ofPattern("dd/MM/yyyy"),
                        DateTimeFormatter.ofPattern("dd-MMM-yyyy", new Locale("pt", "BR"))
                );

                for (DateTimeFormatter formatter : formatosPossiveis) {
                    try {
                        return LocalDate.parse(rawValue, formatter);
                    } catch (DateTimeParseException ignored) {
                        // Tenta o próximo formato
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao converter célula para LocalDate: " + e.getMessage());
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

        return  r.getCell(indexEspecialidades).toString().split(";");
    }
    private static String treatNumber(Row r, int indexRow){
        if(Objects.equals(r.getCell(indexRow).toString().trim(), "")){
            return "0";
        }else{
            if(r.getCell(indexRow).toString().endsWith(".0")){
                return r.getCell(indexRow).toString().substring(0,r.getCell(indexRow).toString().length() -2);
            }else{
                return r.getCell(indexRow).toString();
            }

        }
    }
}
