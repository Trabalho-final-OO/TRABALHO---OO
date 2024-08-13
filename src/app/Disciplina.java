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


    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String toString() {
        return "Disciplina: " + nomeDisciplina +
                ", Código: " + codigoDisciplina +
                ", Carga Horária: " + cargaHoraria;
    }

}