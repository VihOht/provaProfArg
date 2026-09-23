package br.insper.exercise.service;

import br.insper.exercise.entity.Tarefa;
import br.insper.exercise.entity.TarefaPriority;
import br.insper.exercise.entity.TarefaStatus;
import br.insper.exercise.repository.TarefaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TarefaServiceTest {

    @InjectMocks
    private TarefaService tarefaService;

    @Mock
    private TarefaRepository tarefaRepository;

    @Test
    public void testListarTarefaComSucesso() {
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setStatus(TarefaStatus.DONE);
        tarefa1.setPrioridade(TarefaPriority.BAIXA);
        tarefa1.setTitle("Test1");
        tarefa1.setDescription("Test1 Descricao");

        Tarefa tarefa2 = new Tarefa();
        tarefa2.setStatus(TarefaStatus.DONE);
        tarefa2.setPrioridade(TarefaPriority.BAIXA);
        tarefa2.setTitle("Test2");
        tarefa2.setDescription("Test2 Descricao");


        List<Tarefa> tarefas = new ArrayList<Tarefa>();
        tarefas.add(tarefa1);
        tarefas.add(tarefa2);

        when(tarefaRepository.findAllByDeletedFalse()).thenReturn(tarefas);

        List<Tarefa> resultado = tarefaService.listTarefas();

        assertNotNull(resultado);
        assertEquals(tarefas, resultado);
    }
}
