package cadastros;

public abstract class Cadastros {

    public abstract int cadastrar(Object o) throws Exception;

    public abstract Object pesquisar(String s);

    public abstract boolean remover(Object o);

    public abstract boolean atualizar(String codigo);
}
