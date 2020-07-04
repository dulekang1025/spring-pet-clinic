package lekang.petclinic.services.springdatajpa;

import lekang.petclinic.model.Vet;
import lekang.petclinic.repositories.VetRepository;
import lekang.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("SpringDataJpa")
public class VetServiceJpa implements VetService {

    private final VetRepository vetRepository;

    public VetServiceJpa(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> set = new HashSet<>();
        vetRepository.findAll().forEach(set::add);
        return null;
    }

    @Override
    public Vet findById(Long aLong) {
        Optional<Vet> optionalVet = vetRepository.findById(aLong);
        if(optionalVet.isPresent()){
            return optionalVet.get();
        }else {
            return null;
        }
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
