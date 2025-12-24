@RestController
@RequestMapping("/api/stocks")
@Tag(name = "Stocks")
public class StockController {
    private final StockService service;

    public StockController(StockService service) {
        this.service = service;
    }

    @PostMapping
    public Stock create(@RequestBody Stock s) {
        return service.createStock(s);
    }
}
