package lp3.backend.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;


public class Invoice {


    private UUID invoiceId;
    private Long price;

    public void setInvoiceId(UUID invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPrice() {
        return price;
    }

    public UUID getInvoiceId() {
        return invoiceId;
    }
}
