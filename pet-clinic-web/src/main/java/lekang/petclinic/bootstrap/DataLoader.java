package lekang.petclinic.bootstrap;

import lekang.petclinic.model.Owner;
import lekang.petclinic.model.Vet;
import lekang.petclinic.services.OwnerService;
import lekang.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Alice");
        owner1.setSecondName("Swan");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setSecondName("Swift");
        ownerService.save(owner2);

        System.out.println("Loaded Owners.");

        Vet vet1 = new Vet();
        vet1.setFirstName("Bone");
        vet1.setSecondName("Well");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Fury");
        vet2.setSecondName("Smoothy");
        vetService.save(vet2);

        System.out.println("Loaded Vets.");

    }
}
