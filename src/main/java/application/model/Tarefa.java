package application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Descrição não pode ser vazia")
    private String descricao;

    private Boolean concluida;

    public Tarefa(String descricao, Boolean concluida) {
        this.descricao = descricao;
        this.concluida = concluida;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }
}
