package lp3.backend.domain;

import java.util.UUID;

public class Storage {

    private UUID storageId;
    private Product product;

    private final int Stock =0;

    public UUID getStorageId() {
        return storageId;
    }

    public void setStorageId(UUID storageId) {
        this.storageId = storageId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
