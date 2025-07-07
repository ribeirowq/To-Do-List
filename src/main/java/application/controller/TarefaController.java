package application.controller;

import application.model.Tarefa;
import application.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody String descricao, UriComponentsBuilder uriBuilder){
        Tarefa tarefa = tarefaService.criaTarefa(descricao);
        URI location =uriBuilder.path("/tarefas/criar/{id}").buildAndExpand(tarefa.getId()).toUri();
        return ResponseEntity.created(location).body(tarefa);
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas(){
        List<Tarefa> listar = tarefaService.listarTodas();
        return ResponseEntity.ok(listar);
    }

    @PutMapping("/{descricao}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable @Valid String descricao){
        Tarefa tarefa = tarefaService.atualizarStatus(descricao);
         return ResponseEntity.ok(tarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tarefa> deletarTarefaPorId(@PathVariable Long id){
        tarefaService.deletarTarefaPorId(id);
        return ResponseEntity.noContent().build();
    }
}
