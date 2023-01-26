package lp3.backend.service;

import lp3.backend.dao.TaxDao;
import lp3.backend.domain.Tax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaxService {

    private final TaxDao TaxDao;
    @Autowired
    public TaxService(@Qualifier("TaxDao") TaxDao TaxDao) {
        this.TaxDao = TaxDao;
    }

    public void addTax(Tax Tax){
        TaxDao.insertTax(Tax);
    }

    public List<Tax> getAllTax(){
        return TaxDao.selectAllTax();
    }

    public Optional<Tax> getTaxById(UUID id){
        return TaxDao.selectTaxById(id);
    }

    public void deleteTax(UUID id){
        TaxDao.deleteTaxById(id);
    }

    public void updateTax(UUID id, Tax newTax) {
        TaxDao.updateTaxById(id, newTax);
    }
}

