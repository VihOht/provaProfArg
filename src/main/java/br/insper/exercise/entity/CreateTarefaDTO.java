package br.insper.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateTarefaDTO {
    private String title;
    private String description;
    private TarefaPriority prioridade;
    private TarefaStatus status;
}
