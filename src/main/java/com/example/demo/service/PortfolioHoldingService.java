@Service
public class PortfolioHoldingService {
    public PortfolioHoldingService(
        PortfolioHoldingRepository h,
        UserPortfolioRepository p,
        StockRepository s
    ) {}

    public PortfolioHolding createHolding(PortfolioHolding h) {
        if (h.getQuantity() <= 0)
            throw new RuntimeException("Quantity must be > 0");
        return h;
    }
}
