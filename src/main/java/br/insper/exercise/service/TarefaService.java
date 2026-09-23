package br.insper.exercise.service;


import br.insper.exercise.entity.*;
import br.insper.exercise.exceptions.TarefaNotFound;
import br.insper.exercise.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    @Autowired
    TarefaRepository tarefaRepository;

    @Autowired
    ObserveService observeService;

    public List<Tarefa> listTarefas() {
        return tarefaRepository.findAllByDeletedFalse();
    }

    public Tarefa getTarefabyId(Long id) {
        return tarefaRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new TarefaNotFound());
    }

    public Tarefa createTarefa(CreateTarefaDTO request) {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitle(request.getTitle());
        tarefa.setDescription(request.getDescription());
        tarefa.setPrioridade(request.getPrioridade());
        tarefa.setStatus(request.getStatus());

        tarefaRepository.save(tarefa);

        // Se tarefa tiver prioridade ALTA printa no console
        System.out.println("Tarefa de Alta prioridade criada: " + tarefa.getTitle());

        CreateObserveDTO createObserveDTO = new CreateObserveDTO();

        createObserveDTO.setAcao(ObserveAction.CREATE);
        createObserveDTO.setDescricao("Tarefa criada: " + tarefa.getTitle());
        observeService.createObserve(createObserveDTO);

        return tarefa;
    }

    public void deleteTarefa(Long id) {
        Tarefa tarefa = tarefaRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new TarefaNotFound());
        tarefa.setDeleted(true);
        tarefaRepository.save(tarefa);

        CreateObserveDTO createObserveDTO = new CreateObserveDTO();

        createObserveDTO.setAcao(ObserveAction.DELETE);
        createObserveDTO.setDescricao("Tarefa deletada: " + tarefa.getTitle());
        observeService.createObserve(createObserveDTO);
    }

}
