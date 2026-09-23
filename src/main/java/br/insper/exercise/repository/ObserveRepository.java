package br.insper.exercise.repository;

import br.insper.exercise.entity.Observe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObserveRepository extends JpaRepository<Observe, Long> {
}
