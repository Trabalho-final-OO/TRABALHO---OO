package app;

public class PessoaFisica {

    private String nome;
    private String cpf;
    private String email;

    public PessoaFisica(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public final String getNome() {
        return nome;
    }

    public final String getCpf() {
        return cpf;
    }

    public final String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String toString() {
        String resposta = super.toString() + '\n';
        resposta += "NOME: " + nome + '\n';
        resposta += "CPF: " + cpf + '\n';
        resposta += "EMAIL: " + email + '\n';
        return resposta;
    }
}
