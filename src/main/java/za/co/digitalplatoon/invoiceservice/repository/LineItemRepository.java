package za.co.digitalplatoon.invoiceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.digitalplatoon.invoiceservice.entity.LineItem;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, Long> {
}
