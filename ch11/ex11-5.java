// 도메인 객체

public class Order {
    private final long id;
    private final List<OrderItem> items = new ArrayList<>();
    private DeliverySchedule schedule;

    public Order(long id) {
	this.id = id;
    }

    public DeliverySchedule getSchedule() {
	return schedule;
    }

    public void setSchedule(DeliverySchedule schedule) {
	this.schedule = schedule;
    }

    public List<OrderItem> getItems() {
	return items;
    }

    public long getId() {
	return id;
    }
}

public class OrderItem {
    private final long id;
    private final String description;
    private final double price;

    public OrderItem(long id, String description, double price) {
	this.id = id;
	this.description = description;
	this.price = price;
    }

    @Override
    public String toString() {
	return "OrderItem{" + "id=" + id + ", description=" +
	    description + ", price=" + price + '}';
    }
}

public final class DeliverySchedule {
    private final LocalDate deliveryDate;
    private final String address;
    private final double deliveryCost;

    private DeliverySchedule(LocalDate deliveryDate, String address, double deliveryCost) {
	this.deliveryDate = deliveryDate;
	this.address = address;
	this.deliveryCost = deliveryCost;
    }

    public static DeliverySchedule of(LocalDate deliveryDate, String address, double deliveryCost) {
	return new DeliverySchedule(deliveryDate, address, deliveryCost);
    }

    @Override
    public String toString() {
	return "DeliverySchedule{" + "deliveryDate=" + deliveryDate +
	    ", address=" + address + ", deliveryCost=" + deliveryCost + '}';
    }
}
