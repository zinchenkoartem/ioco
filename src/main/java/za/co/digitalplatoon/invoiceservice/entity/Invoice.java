package za.co.digitalplatoon.invoiceservice.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String client;
    @NotNull
    private Long vatRate;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    @EqualsAndHashCode.Exclude
    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    private Set<LineItem> lineItems;

    public BigDecimal getSubTotal() {
        return lineItems
                .stream()
                .map(LineItem::getLineItemTotal)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getVat() {
        return getSubTotal().multiply(new BigDecimal(vatRate)).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotal() {
        return getVat().add(getSubTotal());
    }
}
