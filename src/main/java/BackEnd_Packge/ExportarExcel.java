package BackEnd_Packge;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.util.ArrayList;

public class ExportarExcel {
    // XSSFWorkbook wb = new XSSFWorkbook();

    public static XSSFSheet createSheet(XSSFWorkbook wb, String tipo) {
        //Passo uma workbook e retorno uma sheet dessa workbook
        XSSFSheet Sheet = wb.createSheet("Lista de " + tipo);
        return Sheet;
    }

    static String[] SheetDadoPessoal = {//Tem 13 itens
            "ID", "Nome", "Data de Nascimento", "Genero", "Endereço-Rua", "Endereço- Numero",
            "Endereço - Bairro", "Endereço - Cidade", "Endereço - Estado", "Endereço - Cep",
            "Telefone", "Celular", "Email"
    };
    static String[] SheetPaciente = {//Tem 8 itens
            "Idade", "Data de Cadastro", "Observação Geral", "Histórico de consultas Médicas",
            "Responsável - Nome", "Responsável - Telefone", "Responsável - Celular ", "Responsável - Email"
    };
    static String[] SheetMedico = {
            "Número CRM", "Areas de especialidade", "Cirurgião?", "Carga Horária Semanal", "Setor"
    };
    static String[] SheetEnfermeiro = {
            "Operador de Raio X ?" , "Carga Horária Semanal" , "Setor"
    };
    static String[] SheetConsulta = {
            "Id", "Id Paciente"," Id Médico","Queixa" , "Diagnostico" , "Prescrição" , "Indicação Cirurgica"
    };

    public static void prepareSheetDadoPessoal(XSSFSheet sh) {
       /*Prepara a sheet de dados gerais
       1 Row pra cada registro na lista de pacientes
       1 coluna pra cada atributo de paciente
       */
        XSSFRow Row = sh.createRow(0);
        for (int i = 0; i < SheetDadoPessoal.length; i++) {
            XSSFCell Cell = Row.createCell(i);
            Cell.setCellValue(SheetDadoPessoal[i]);
        }

    }

    public static void prepareSheetPaciente(XSSFSheet sh) {
        //Escreve do index 14 pra frente

        XSSFRow Row = sh.getRow(0);
        for (int i = 13; i < SheetPaciente.length + 13; i++) {

            XSSFCell Cell = Row.createCell(i);
            Cell.setCellValue(SheetPaciente[i - 13]);
        }
    }

    public static void prepareSheetMedico(XSSFSheet sh) {

        XSSFRow Row = sh.getRow(0);
        for (int i = 13; i < SheetMedico.length + 13; i++) {
            XSSFCell Cell = Row.createCell(i);
            Cell.setCellValue(SheetMedico[i - 13]);
        }

    }

    public static void prepareSheetEnfermeiro(XSSFSheet sh) {
        XSSFRow Row = sh.getRow(0);
        for (int i = 13; i < SheetEnfermeiro.length + 13; i++) {

            XSSFCell Cell = Row.createCell(i);
            Cell.setCellValue(SheetEnfermeiro[i - 13]);
        }
    };

    public static void prepareSheetConsulta(XSSFSheet sh) {
        //A logica é diferente do resto
        XSSFRow Row = sh.createRow(0).getSheet().getRow(0);
        //Aparentemente consertou o problema de row nula se não houver registros no ConsultaArraylist
        for (int i = 0; i < SheetConsulta.length; i++) {

            XSSFCell Cell = Row.createCell(i);
            Cell.setCellValue(SheetConsulta[i]);
        }
    };

    public static void writeSheetPaciente(XSSFWorkbook wb, XSSFSheet sh, ArrayList<Paciente> ListadePacientes) {
        int contatorRow = 1;
        int qntColunasRow0 = contarCelulasPreenchidas(sh.getRow(0));
        CellStyle dataStyle = wb.createCellStyle();
        CellStyle numericStyle = wb.createCellStyle();
        CreationHelper CH = wb.getCreationHelper();
        dataStyle.setDataFormat(CH.createDataFormat().getFormat("dd/MM/yyyy"));
        for (Paciente p : ListadePacientes) {//Cuida das Linhas
            XSSFRow Row = sh.createRow(contatorRow);
            Row.createCell(0).setCellValue(p.getIdPaciente());
            //Row.getCell(0).setCellStyle(CellType.NUMERIC);
            Row.createCell(1).setCellValue(p.getNomeCompleto());
            Row.createCell(2).setCellValue(p.getDataNascimento());
            Row.getCell(2).setCellStyle(dataStyle);
            //Formatar coluna 2 para data
            Row.createCell(3).setCellValue(String.valueOf(p.getGenero()));//Problema
            Row.createCell(4).setCellValue(p.getEndereco().getRua());
            Row.createCell(5).setCellValue(p.getEndereco().getNumero());
            Row.createCell(6).setCellValue(p.getEndereco().getBairro());
            Row.createCell(7).setCellValue(p.getEndereco().getCidade());
            Row.createCell(8).setCellValue(p.getEndereco().getEstado());
            Row.createCell(9).setCellValue(p.getEndereco().getCep());
            Row.createCell(10).setCellValue(p.getContato().getTelefone());
            Row.createCell(11).setCellValue(p.getContato().getCelular());
            Row.createCell(12).setCellValue(p.getContato().getEmail());
            // Row.createCell(13).setCellValue(p.getContato().getTelefone());
            Row.createCell(13).setCellValue(p.getIdade());
            Row.createCell(14).setCellValue(p.getDataCadastro());
            Row.getCell(14).setCellStyle(dataStyle);
            //Formatar coluna 14 para data
            Row.createCell(15).setCellValue(p.getObsGeral());
            Row.createCell(16).setCellValue("Vazio por hora");
            Row.createCell(17).setCellValue(p.getContatoResponsavel().getNomeResponsavel());
            Row.createCell(18).setCellValue(p.getContatoResponsavel().getTelefone());
            Row.createCell(19).setCellValue(p.getContatoResponsavel().getCelular());
            Row.createCell(20).setCellValue(p.getContatoResponsavel().getEmail());
            contatorRow++;
        }
    }

    public static void writeSheetMedico(XSSFWorkbook wb, XSSFSheet sh, ArrayList<Medico> ListadeMedicos) {
        int contatorRow = 1;
        int qntColunasRow0 = contarCelulasPreenchidas(sh.getRow(0));
        CellStyle dataStyle = wb.createCellStyle();
        CellStyle numericStyle = wb.createCellStyle();
        CreationHelper CH = wb.getCreationHelper();
        dataStyle.setDataFormat(CH.createDataFormat().getFormat("dd/MM/yyyy"));
        for (Medico m : ListadeMedicos) {
            XSSFRow Row = sh.createRow(contatorRow);
            Row.createCell(0).setCellValue(m.getIdMedico());
            Row.createCell(1).setCellValue(m.getNomeCompleto());
            Row.createCell(2).setCellValue(m.getDataNascimento());
            Row.getCell(2).setCellStyle(dataStyle);
            Row.createCell(3).setCellValue(String.valueOf(m.getGenero()));//Problema
            Row.createCell(4).setCellValue(m.getEndereco().getRua());
            Row.createCell(5).setCellValue(m.getEndereco().getNumero());
            Row.createCell(6).setCellValue(m.getEndereco().getBairro());
            Row.createCell(7).setCellValue(m.getEndereco().getCidade());
            Row.createCell(8).setCellValue(m.getEndereco().getEstado());
            Row.createCell(9).setCellValue(m.getEndereco().getCep());
            Row.createCell(10).setCellValue(m.getContato().getTelefone());
            Row.createCell(11).setCellValue(m.getContato().getCelular());
            Row.createCell(12).setCellValue(m.getContato().getEmail());
            //Fazer celular especificas do médico
            Row.createCell(13).setCellValue(m.getNumeroCRM());
            Row.createCell(14).setCellValue(m.getAreasEspecialidade().toString());
            Row.createCell(15).setCellValue(m.getCirugiao());
            Row.createCell(16).setCellValue(m.getChSemanal());
            Row.createCell(17).setCellValue(m.getSetor());
            contatorRow++;
        }
    }

    public static void writeSheetEnfermeiro(XSSFWorkbook wb, XSSFSheet sh, ArrayList<Enfermeiro> ListadeEnfermeiros) {
        int contatorRow = 1;
        int qntColunasRow0 = contarCelulasPreenchidas(sh.getRow(0));
        CellStyle dataStyle = wb.createCellStyle();
        CellStyle numericStyle = wb.createCellStyle();
        CreationHelper CH = wb.getCreationHelper();
        dataStyle.setDataFormat(CH.createDataFormat().getFormat("dd/MM/yyyy"));
        for (Enfermeiro e : ListadeEnfermeiros) {//Cuida das Linhas
            XSSFRow Row = sh.createRow(contatorRow);
            Row.createCell(0).setCellValue(e.getIdEnfermeiro());//Formatar a celula para numérico para aparecer o número ID por completo
            Row.createCell(1).setCellValue(e.getNomeCompleto());
            Row.createCell(2).setCellValue(e.getDataNascimento());
            Row.getCell(2).setCellStyle(dataStyle);//Formatar coluna 2 para data
            Row.createCell(3).setCellValue(String.valueOf(e.getGenero()));//Problema
            Row.createCell(4).setCellValue(e.getEndereco().getRua());
            Row.createCell(5).setCellValue(e.getEndereco().getNumero());
            Row.createCell(6).setCellValue(e.getEndereco().getBairro());
            Row.createCell(7).setCellValue(e.getEndereco().getCidade());
            Row.createCell(8).setCellValue(e.getEndereco().getEstado());
            Row.createCell(9).setCellValue(e.getEndereco().getCep());
            Row.createCell(10).setCellValue(e.getContato().getTelefone());
            Row.createCell(11).setCellValue(e.getContato().getCelular());
            Row.createCell(12).setCellValue(e.getContato().getEmail());
            //Adicionar dados do enfermeiro
            Row.createCell(13).setCellValue(e.getTreinadoOpRx());
            Row.createCell(13).setCellValue(e.getChSemanal());
            Row.createCell(13).setCellValue(e.getSetor());

        }
    }

    public static void writeSheetConsulta(XSSFWorkbook wb, XSSFSheet sh, ArrayList<ConsultaMedica> ListadeConsultas) {
        int contatorRow = 1;
        for(ConsultaMedica cm: ListadeConsultas){
            XSSFRow Row = sh.createRow(contatorRow);
            Row.createCell(0).setCellValue(cm.getIdConsulta());
            Row.createCell(1).setCellValue(cm.getIdPaciente());
            Row.createCell(2).setCellValue(cm.getIdMedico());
            Row.createCell(3).setCellValue(cm.getExameQueixa());
            Row.createCell(4).setCellValue(cm.getDiagnostico());
            Row.createCell(5).setCellValue(cm.getPrescricao());
            Row.createCell(6).setCellValue(cm.getIndicacaoCirurgica());
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




