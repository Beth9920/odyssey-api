package com.elisabet.odyssey_api.service;

import com.elisabet.odyssey_api.entity.Character;
import com.elisabet.odyssey_api.entity.Rhapsody;
import com.elisabet.odyssey_api.repository.RhapsodyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RhapsodyService {

    private final RhapsodyRepository rhapsodyRepository;

    public RhapsodyService(RhapsodyRepository rhapsodyRepository) {
        this.rhapsodyRepository = rhapsodyRepository;
    }

    public List<Rhapsody> getAllRhapsodies() {
        return rhapsodyRepository.findAll();
    }

    public Rhapsody createRhapsody(Rhapsody rhapsody) {
        return rhapsodyRepository.save(rhapsody);
    }

    public Rhapsody getRhapsodyById(Long id) {
        return rhapsodyRepository.findById(id).orElse(null);
    }

    public Rhapsody updateRhapsody(Long id, Rhapsody updatedRhapsody) {

        Rhapsody rhapsody = rhapsodyRepository.findById(id).orElse(null);

        if (rhapsody == null) {
            return null;
        }

        rhapsody.setNumber(updatedRhapsody.getNumber());
        rhapsody.setTitle(updatedRhapsody.getTitle());
        rhapsody.setSummary(updatedRhapsody.getSummary());

        return rhapsodyRepository.save(rhapsody);
    }

    public void deleteRhapsody(Long id) {
        rhapsodyRepository.deleteById(id);
    }

    public Rhapsody getRhapsodyByNumber(Integer number) {
        return rhapsodyRepository.findByNumber(number).orElse(null);
    }

}