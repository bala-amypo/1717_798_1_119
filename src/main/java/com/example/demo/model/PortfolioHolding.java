import com.example.demo.model.Stock;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class PortfolioHolding {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private UserPortfolio portfolio;

    @ManyToOne
    private Stock stock;

    private Double quantity;
    private BigDecimal marketValue;
    private Timestamp lastUpdated;

    public Long getId() { return id; }
    public UserPortfolio getPortfolio() { return portfolio; }
    public void setPortfolio(UserPortfolio portfolio) { this.portfolio = portfolio; }
    public Stock getStock() { return stock; }
    public void setStock(Stock stock) { this.stock = stock; }
    public Double getQuantity() { return quantity; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }
    public BigDecimal getMarketValue() { return marketValue; }
    public void setMarketValue(BigDecimal marketValue) { this.marketValue = marketValue; }
}
