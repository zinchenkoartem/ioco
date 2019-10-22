package za.co.digitalplatoon.invoiceservice.service.impl;

import org.springframework.stereotype.Service;
import za.co.digitalplatoon.invoiceservice.entity.Invoice;
import za.co.digitalplatoon.invoiceservice.repository.InvoiceRepository;
import za.co.digitalplatoon.invoiceservice.service.InvoiceService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice add(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice get(Long id) {
        return invoiceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("EntityNotFoundException (ID:" + id + ")"));
    }

}
