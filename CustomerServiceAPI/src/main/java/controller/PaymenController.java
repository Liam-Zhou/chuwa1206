@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}/payments")
    public ResponseEntity<List<Payment>> getCustomerPayments(@PathVariable Long customerId) {
        List<Payment> payments = customerService.getPayments(customerId);
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{customerId}/orders")
    public ResponseEntity<List<Order>> getCustomerOrders(
            @PathVariable Long customerId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        List<Order> orders = orderService.getOrdersBetweenDates(customerId, start, end);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{customerId}/delivery-addresses")
    public ResponseEntity<List<Address>> getCustomerDeliveryAddresses(@PathVariable Long customerId) {
        List<Address> addresses = customerService.getDeliveryAddresses(customerId);
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/{customerId}/defaults")
    public ResponseEntity<CustomerDefaultsDTO> getCustomerDefaults(@PathVariable Long customerId) {
        CustomerDefaultsDTO defaults = customerService.getCustomerDefaults(customerId);
        return ResponseEntity.ok(defaults);
    }


}