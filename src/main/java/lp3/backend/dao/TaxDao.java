package lp3.backend.dao;

import lp3.backend.domain.Tax;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaxDao {
    int insertTax (UUID id, Tax Tax);

    default int insertTax(Tax Tax){
        UUID id = UUID.randomUUID();
        return insertTax(id, Tax);
    }

    List<Tax> selectAllTax();

    Optional<Tax> selectTaxById(UUID id);

//    Optional<Tax> selectTaxByName(String name);

    int deleteTaxById(UUID id);

    int updateTaxById(UUID id, Tax Tax);
}

