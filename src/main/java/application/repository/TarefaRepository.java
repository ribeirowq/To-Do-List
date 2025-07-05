package application.repository;

import application.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    Boolean findByConcluida();

    Optional<Tarefa> findByDescricao(String descricao);

}
