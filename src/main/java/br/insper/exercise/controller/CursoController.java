package br.insper.exercise.controller;

import br.insper.exercise.entity.CreateTarefaDTO;
import br.insper.exercise.entity.Tarefa;
import br.insper.exercise.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class CursoController {
    @Autowired
    private TarefaService tarefaService;
    
    @GetMapping("")
    public List<Tarefa> listTarefas() {
        return tarefaService.listTarefas();
    }

    @PostMapping("")
    public void createTarefa(@RequestBody CreateTarefaDTO request) {
        tarefaService.createTarefa(request);
    }

    @DeleteMapping("/{id}")
    public void deleteTarefa(@PathVariable Long id) {
        tarefaService.deleteTarefa(id);
    }
            
}
