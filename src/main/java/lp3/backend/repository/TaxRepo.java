package lp3.backend.repository;

import lp3.backend.dao.TaxDao;
import lp3.backend.model.Tax;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("TaxDao")
public class TaxRepo implements TaxDao {

    private static List<Tax> DB = new ArrayList<>();

    @Override
    public int insertTax(UUID id, Tax Tax){
        DB.add(new Tax(id, Tax.getType(),Tax.getPercentage()));
        return 0;
    }

    @Override
    public List<Tax> selectAllTax() {
        return DB;
    }

    @Override
    public Optional<Tax> selectTaxById(UUID id) {
        return DB.stream()
                .filter(Tax -> Tax.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteTaxById(UUID id) {
        Optional<Tax> TaxMaybe = selectTaxById(id);
        if (TaxMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(TaxMaybe.get());
        return 1;
    }


    @Override
    public int updateTaxById(UUID id, Tax update) {
        return selectTaxById(id)
                .map(Tax -> {
                    int indexOfTaxToUpdate = DB.indexOf(Tax);
                    if (indexOfTaxToUpdate >= 0){
                        DB.set(indexOfTaxToUpdate, new Tax(id, update.getType(), update.getPercentage()));
                        return 1;
                    }
                    return 0;
                } )
                .orElse(0);
    }
}
