package lp3.backend.api;

import lp3.backend.domain.Tax;
import lp3.backend.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/lp3/tax")
@RestController
public class TaxController {
    private final TaxService TaxService;
    @Autowired
    public TaxController(TaxService TaxService) {
        this.TaxService = TaxService;
    }
    @PostMapping
    public void addUser(@RequestBody Tax Tax){
        TaxService.addTax(Tax);
    }

    @GetMapping
    public List<Tax> getAllTax(){
        return
                TaxService.getAllTax();
    }

    @GetMapping(path = "{id}")
    public Tax getTaxById(@PathVariable("id") UUID id){
        return TaxService.getTaxById(id)
                .orElse(null);
    }

//    @GetMapping(path = "{id}")
//    public Tax getTaxByName(@PathVariable("name") String name){
//        return TaxService.getTaxByName(name)
//                .orElse(null);
//    }

    @DeleteMapping(path = "{id}")
    public void deleteTaxById(@PathVariable("id") UUID id) {
        TaxService.deleteTax(id);
    }

    @PutMapping(path = "{id}")
    public void updateTax(@PathVariable("id") UUID id, @RequestBody Tax TaxToUpdate){
        TaxService.updateTax(id,TaxToUpdate);
    }
}