package application.repository;

import application.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    Optional<Tarefa> findByDescricao(String descricao);

}
