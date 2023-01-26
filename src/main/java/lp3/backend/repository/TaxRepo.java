package lp3.backend.repository;

import lp3.backend.dao.TaxDao;
import lp3.backend.domain.Tax;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("TaxDao")
public class TaxRepo implements TaxDao {

    private final static List<Tax> taxDB = new ArrayList<>();

    @Override
    public int insertTax(UUID id, Tax Tax){
        taxDB.add(new Tax(id, Tax.getType(),Tax.getPercentage()));
        return 0;
    }

    @Override
    public List<Tax> selectAllTax() {
        return taxDB;
    }

    @Override
    public Optional<Tax> selectTaxById(UUID id) {
        return taxDB.stream()
                .filter(Tax -> Tax.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deleteTaxById(UUID id) {
        Optional<Tax> TaxMaybe = selectTaxById(id);
        if (TaxMaybe.isEmpty()) {
            return;
        }
        taxDB.remove(TaxMaybe.get());
    }


    @Override
    public void updateTaxById(UUID id, Tax update) {
        selectTaxById(id)
                .map(Tax -> {
                    int indexOfTaxToUpdate = taxDB.indexOf(Tax);
                    if (indexOfTaxToUpdate >= 0) {
                        taxDB.set(indexOfTaxToUpdate, new Tax(id, update.getType(), update.getPercentage()));
                        return 1;
                    }
                    return 0;
                });
    }
}
