package lekang.petclinic.services.springdatajpa;

import lekang.petclinic.model.Speciality;
import lekang.petclinic.repositories.SpecialityRepository;
import lekang.petclinic.services.SpecialityService;

import java.util.HashSet;
import java.util.Set;

public class SpecialityServiceJpa implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialityServiceJpa(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> set = new HashSet<>();
        specialityRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepository.deleteById(aLong);
    }
}
