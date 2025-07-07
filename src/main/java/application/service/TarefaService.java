package application.service;

import application.model.Tarefa;
import application.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa criaTarefa(String descricao) {
        Boolean concluida = false;
        Tarefa tarefa = new Tarefa(descricao, concluida);
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTodas(){
        return tarefaRepository.findAll();
    }

    public Tarefa atualizarStatus(String descricao) {
        Optional<Tarefa> tarefaOptional = tarefaRepository.findByDescricao(descricao);
        if (tarefaOptional.isPresent()){
            Tarefa tarefa = tarefaOptional.get();
            tarefa.setConcluida(!tarefa.getConcluida());
            return tarefaRepository.save(tarefa);
       } else {
            throw new NoSuchElementException("Tarefa não encontrada!");
        }
    }

    public void deletarTarefaPorId(Long id){
        tarefaRepository.deleteById(id);
    }
}
