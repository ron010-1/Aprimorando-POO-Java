package entities;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class UsedProduct extends Product{
    
    private LocalDate manufactureDate;

    public UsedProduct(String name, Double price, LocalDate manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

@Override
public String priceTag(){
    return getName() + " (used)" + " $ " + getPrice() + "(Manufacture date: " + manufactureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " )"; 
}
    
}
