package za.co.digitalplatoon.invoiceservice.service;

import za.co.digitalplatoon.invoiceservice.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    Invoice add(Invoice invoice);

    List<Invoice> getAll();

    Invoice get(Long id);

}
