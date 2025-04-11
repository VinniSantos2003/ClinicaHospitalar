package BackEnd_Packge;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.dhatim.fastexcel.Workbook;
import org.dhatim.fastexcel.Worksheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.util.ArrayList;

public abstract class ExportarExcel  {
    // XSSFWorkbook wb = new XSSFWorkbook();

    public XSSFSheet createSheetPaciente(XSSFWorkbook wb, String tipo){
        //Passo uma workbook e retorno uma sheet dessa workbook
        XSSFSheet Sheet  = wb.createSheet("Lista de " + tipo );
        return Sheet;
    }
    String[] SheetDadoPessoal ={
            "ID","Nome","Data de Nascimento","Genero","Endereço-Rua","Endereço- Numero",
            "Endereço - Bairro", "Endereço - Cidade", "Endereço Estado" , "Endereço - Cep",
            "Telefone" , "Celular" , "Email"
    };
    String [] SheetPaciente = {
            "Idade", "Data de Cadastro" , "Observação Geral" , "Histórico de consultas Médicas",
            "Responsável - Nome" , "Responsável - Telefone", "Responsável - Celular " , "Responsável - Email"
    };
    public void prepareSheetDadoPessoal(XSSFSheet sh){
       /*Prepara a sheet de dados gerais
       1 Row pra cada registro na lista de pacientes
       1 coluna pra cada atributo de paciente
       */
        XSSFRow Row = sh.createRow(0);
        for(int i = 0; i< SheetDadoPessoal.length; i++){
            XSSFCell Cell = Row.createCell(i);
            Cell.setCellValue(SheetDadoPessoal[i]);
        }

    }
    public void prepareSheetPaciente(XSSFSheet sh){
        //Escreve do index 14 pra frente
        XSSFRow Row = sh.getRow(0);
        for(int i = 14;i < SheetPaciente.length+14;i++){
            XSSFCell Cell = Row.createCell(i);
            Cell.setCellValue(SheetPaciente[i-14]);
        }
    }
    public void writeSheetPaciente(XSSFSheet sh,ArrayList<Paciente> ListadePacientes){
        int contatorRow = 1;
        int qntColunasRow0 = contarCelulasPreenchidas(sh.getRow(0));


        for(Paciente p: ListadePacientes){//Cuida das Linhas
            XSSFRow Row = sh.createRow(contatorRow);
            Row.createCell(0).setCellValue(p.getIdPaciente());
            Row.createCell(1).setCellValue(p.getNomeCompleto());
            Row.createCell(2).setCellValue(String.valueOf(p.getGenero()));
            Row.createCell(3).setCellValue(p.getEndereco().getRua());
            Row.createCell(4).setCellValue(p.getEndereco().getNumero());
            Row.createCell(5).setCellValue(p.getEndereco().getBairro());
            Row.createCell(6).setCellValue(p.getEndereco().getCidade());
            Row.createCell(7).setCellValue(p.getEndereco().getEstado());
            Row.createCell(8).setCellValue(p.getEndereco().getCep());
            Row.createCell(9).setCellValue(p.getIdade());
            Row.createCell(10).setCellValue(p.getDataNascimento());
            Row.createCell(11).setCellValue(p.getObsGeral());
            //Row.createCell(12).setCellValue(p.getHistoricoConsultasMedicas());
            Row.createCell(13).setCellValue(p.getContatoResponsavel().getNomeResponsavel());
            Row.createCell(14).setCellValue(p.getContatoResponsavel().getTelefone());
            Row.createCell(15).setCellValue(p.getContatoResponsavel().getCelular());
            Row.createCell(9).setCellValue(p.getContatoResponsavel().getEmail());
            contatorRow++;
        }
    }

    public static int contarCelulasPreenchidas(XSSFRow row) {
        int count = 0;
        for (Cell cell : row) {
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                count++;
            }
        }
        return count;
    }
}



