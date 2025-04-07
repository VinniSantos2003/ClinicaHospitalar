package BackEnd_Packge;

import java.util.Date;

public abstract class Validacao {//Classe destinada a teste de informações

    public boolean verifyEmail(String email){
        /*
        * Email possui duas partes
        * username = antes do @, é aceito letras de A-Z, numeros de 0-9 e -,_, .
        * dominio = depois do @, é aceito letras de A-Z, numeros de 0-9 e -
        *
        * */
        if(email.indexOf('@') == -1){
            //Se o @ não for encontrado, não é um email valido
            return false;
        } else if (email.indexOf(email.length()-1) == '.' || email.indexOf(0) == '.' ) {
            //Se houver um '.' no inicio ou no final do email, não é valido
            return false;
        }
        //Adicionar condição para @ repetido
        return true;
    }
    public boolean verifyCep(String cep){

        /*CEP nãoa pode ter mais ou menos que 8 digitos
        * CEP não pode ter letras
        * Existem outras condições para validações para representação de uma area existente
        * */
        if(cep.length() != 8){
            return false;
        } else if (cep.matches("^(?i:[a-z]+ [a-z ]+)$")) {
            return false;
        }
        return true;
    }
    public boolean verifyBirthDay(Date data){
        //Nem sei se vai precisar verificar algo
        return true;
    }
    public boolean verifyPhoneNumber(String number){
        //O numero de telefone levará em conta o DDD + os 9 digitos
        /*
        * Um numero deve contar somente valores numericos
        *
        * */
        return true;
    }
}
