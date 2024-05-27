import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
            List<ShipmentCharge> str = new ArrayList<>();
        ShipmentCharge s =new ShipmentCharge();
        s.setShipmentId("abc");

        ShipmentCharge s1 =new ShipmentCharge();
        s1.setShipmentId("def");

        str.add(s);
        str.add(s1);

            Optional<ShipmentCharge> shipmentChargesOptional =
                    str.stream()
                            .filter(shipmentCharge -> shipmentCharge.getShipmentId()
                                    .equals("123")).findFirst();
            if (shipmentChargesOptional.isPresent()) {
                System.out.println("Output"+shipmentChargesOptional.get());
            }
    }
}