@Service
public class StockService {
    private final StockRepository repo;

    public StockService(StockRepository repo) {
        this.repo = repo;
    }

    public Stock createStock(Stock s) {
        if (repo.findByTicker(s.getTicker()) != null)
            throw new RuntimeException("Duplicate ticker");
        return repo.save(s);
    }
}
