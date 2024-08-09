package app;

public class Disciplina {
    private String nomeDisciplina;
    private String codigoDisciplina;
    private String cargaHoraria;

    public Disciplina(String nomeDisciplina, String codigoDisciplina, String cargaHoraria) {
        this.nomeDisciplina = nomeDisciplina;
        this.codigoDisciplina = codigoDisciplina;
        this.cargaHoraria = cargaHoraria;
    }

    public final String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public final String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public final String getCargaHoraria() {
        return cargaHoraria;
    }

    public int turmaDisciplina(int codigoTurma) {
        return codigoTurma;
    }
    
    protected void finalize() throws Throwable {
		System.out.println("Destruindo objeto: " + this);
	}
    
    public String toString() {
    	String resposta= "Disciplina: " +nomeDisciplina+ '\n';
    	resposta += "Código: " +codigoDisciplina+ '\n';
    	resposta += "Carga Horária: " +cargaHoraria+ '\n';
    	return resposta;
    }
}
