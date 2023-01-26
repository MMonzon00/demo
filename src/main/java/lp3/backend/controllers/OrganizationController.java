package lp3.backend.controllers;

import lp3.backend.domain.Organization;
import lp3.backend.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static lp3.backend.constants.ApiPaths.ORGANIZATION;

@RequestMapping(path = ORGANIZATION)
@RestController
public class OrganizationController {
    private final OrganizationService OrganizationService;
    @Autowired
    public OrganizationController(OrganizationService OrganizationService) {
        this.OrganizationService = OrganizationService;
    }
    @PostMapping
    public void addUser(@RequestBody Organization organization){
        OrganizationService.addOrganization(organization);
    }

    @GetMapping
    public List<Organization> getAllPeople(){
        return
                OrganizationService.getAllOrganizations();
    }

    @GetMapping(path = "{id}")
    public Organization getOrganizationById(@PathVariable("id") UUID id){
        return OrganizationService.getOrganizationById(id)
            .orElse(null);
    }

//    @GetMapping(path = "{id}")
//    public Organization getOrganizationByType(@PathVariable("type") String type){
//        return OrganizationService.getOrganizationByType(type)
//                .orElse(null);
//    }

    @DeleteMapping(path = "{id}")
    public void deleteOrganizationById(@PathVariable("id") UUID id) {
        OrganizationService.deleteOrganization(id);
    }

    @PutMapping(path = "{id}")
    public void updateOrganization(@PathVariable("id") UUID id, @RequestBody Organization organizationToUpdate){
        OrganizationService.updateOrganization(id,organizationToUpdate);
    }
}