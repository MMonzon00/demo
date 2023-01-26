package lp3.backend.dao;

import lp3.backend.domain.Tax;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaxDao {
    int insertTax (UUID id, Tax Tax);

    default void insertTax(Tax Tax){
        UUID id = UUID.randomUUID();
        insertTax(id, Tax);
    }

    List<Tax> selectAllTax();

    Optional<Tax> selectTaxById(UUID id);

//    Optional<Tax> selectTaxByName(String name);

    void deleteTaxById(UUID id);

    void updateTaxById(UUID id, Tax Tax);
}

