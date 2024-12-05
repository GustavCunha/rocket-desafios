import java.time.LocalDate;

public class Livro {
    private int id;
    private String titulo;
    private Autor autor;
    private boolean disponivel;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;

    public Livro(int id, String titulo, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
        this.dataCadastro = LocalDate.now();
        this.dataAtualizacao = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
        this.dataAtualizacao = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Livro {id=" + id + ", titulo=" + titulo + ", autor=" + autor.getNome() +
               ", disponivel=" + disponivel + ", dataCadastro=" + dataCadastro +
               ", dataAtualizacao=" + dataAtualizacao + "}";
    }
}


