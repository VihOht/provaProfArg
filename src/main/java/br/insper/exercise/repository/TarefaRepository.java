package br.insper.exercise.repository;

import br.insper.exercise.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findAllByDeletedFalse();
    Optional<Tarefa> findByIdAndDeletedFalse(Long id);
}
