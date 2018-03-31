package Controle;

/**
 *
 * @author Anderson S Barros
 */
public class CadastroFalhaException extends Exception {
    
    private String mensagem;
    
    public CadastroFalhaException(String nome) {
        this.mensagem = "Erro ao Cadastrar o cliente " + nome + ", Favor tentar novamente!";
    }
    
    public String getMessage() {
        return mensagem;
    }
}
