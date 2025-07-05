package application.service;

import application.model.Tarefa;
import application.repository.TarefaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public void atualizarStatus(String descricao) {
    }
}
