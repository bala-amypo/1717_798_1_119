@Service
public class StockService {
    private final StockRepository repo;

    public StockService(StockRepository repo) {
        this.repo = repo;
    }

    public Stock createStock(Stock stock) {
        if (repo.findByTicker(stock.getTicker()).isPresent())
            throw new RuntimeException("Duplicate ticker");
        return repo.save(stock);
    }
}
