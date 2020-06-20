package lekang.petclinic.bootstrap;

import lekang.petclinic.model.Owner;
import lekang.petclinic.model.Vet;
import lekang.petclinic.services.OwnerService;
import lekang.petclinic.services.VetService;
import lekang.petclinic.services.map.OwnerServiceMap;
import lekang.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;

    private VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Alice");
        owner1.setSecondName("Swan");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Bob");
        owner2.setSecondName("Swift");
        ownerService.save(owner2);

        System.out.println("Loaded Owners.");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Bone");
        vet1.setSecondName("Well");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Fury");
        vet2.setSecondName("Smoothy");
        vetService.save(vet2);

        System.out.println("Loaded Vets.");

    }
}
