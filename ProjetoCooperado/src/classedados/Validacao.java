package classedados;
public class Validacao {
    //Não permite numeros nem caracters especias, apenas letra e acentos
    //if(!validaCampoTexto(nome))
    public boolean validaCampoTexto(String text) {
    return text.matches("[À-úa-zA-Z\\s]+"); //Passa para o método matches a regex
    //Se tiver número na string irá retornar falso
    //Note o uso de duas \\, uma sendo obrigatória para servir de caracter de escape
    }
    public boolean validaCampoNumero(String text) {
    return text.matches("[.1234567890\\s]+");
    }
}
