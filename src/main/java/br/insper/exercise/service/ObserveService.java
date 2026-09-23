package br.insper.exercise.service;

import br.insper.exercise.entity.CreateObserveDTO;
import br.insper.exercise.entity.Observe;
import br.insper.exercise.exceptions.ObserveNotFound;
import br.insper.exercise.repository.ObserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObserveService {

    @Autowired
    ObserveRepository observeRepository;

    public List<Observe> listObserve() {
        return  observeRepository.findAll();
    }

    public Observe getObserveById(Long id) {
        return  observeRepository.findById(id).orElseThrow(() -> new ObserveNotFound());
    }

    public Observe createObserve(CreateObserveDTO request) {
        Observe observe = new Observe();
        observe.setAcao(request.getAcao());
        observe.setDescricao(request.getDescricao());
        observeRepository.save(observe);
        return observe;
    }
}
