package Cliente;

import Telas.TelaLogin;

/**
 *
 * 
 */
public class Principal {

    /** 
     * Classe principal que faz a conexão com o banco de dados, também
     * instância e exibe a tela de login.
     * @param args 
     */
    public static void main(String[] args) {
        TelaLogin login = new TelaLogin();        
        login.setVisible(true);
    }
    
}
