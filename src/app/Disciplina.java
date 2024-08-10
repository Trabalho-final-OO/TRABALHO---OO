package app;

public class Disciplina {
    private String nomeDisciplina;
    private String codigoDisciplina;
    private String cargaHoraria;
    private int turmaDisciplina;


    public Disciplina(String nomeDisciplina, String codigoDisciplina, String cargaHoraria, int turmaDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.codigoDisciplina = codigoDisciplina;
        this.cargaHoraria = cargaHoraria;
        this.turmaDisciplina = turmaDisciplina;
    }


    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public int getTurmaDisciplina() {
        return turmaDisciplina;
    }



    public String toString() {
        return "Disciplina: " + nomeDisciplina +
                ", Código: " + codigoDisciplina +
                ", Carga Horária: " + cargaHoraria +
                ", Turma: " + turmaDisciplina;
    }



    protected void finalize() throws Throwable {
        try {
            // Código para limpar recursos, se necessário
        } finally {
            super.finalize();
        }
    }
}

