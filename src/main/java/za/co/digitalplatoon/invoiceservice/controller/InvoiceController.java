package za.co.digitalplatoon.invoiceservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.digitalplatoon.invoiceservice.entity.Invoice;
import za.co.digitalplatoon.invoiceservice.service.InvoiceService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/invoices")
@Slf4j
public class InvoiceController {

    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity addInvoice(@RequestBody @Valid Invoice invoice) {
        try {
            Invoice result = invoiceService.add(invoice);
            log.info("Adding invoice: " + result.toString());
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity viewAllInvoices() {
        try {
            List<Invoice> result = invoiceService.getAll();
            log.info("Getting all invoices");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @GetMapping(value = "/{invoiceId}")
    public ResponseEntity viewInvoice(@PathVariable long invoiceId) {
        try {
            Invoice result = invoiceService.get(invoiceId);
            log.info("Getting invoice: " + result.toString());
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}
