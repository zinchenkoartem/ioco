package za.co.digitalplatoon.invoiceservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@Entity
public class LineItem {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private Long quantity;
    @NotBlank
    private String description;
    @NotNull
    private BigDecimal unitPrice;

    public BigDecimal getLineItemTotal() {
        return unitPrice.multiply(new BigDecimal(quantity)).setScale(2, RoundingMode.HALF_UP);
    }

}
