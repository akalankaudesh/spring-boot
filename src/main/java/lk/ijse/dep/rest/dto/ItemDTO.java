package lk.ijse.dep.rest.dto;

public class ItemDTO extends SuperDTO {
    private String item_code;
    private String description;
    private double unit_price;
    private int qty;

    public ItemDTO(String item_code, String description, double unit_price, int qty) {
        this.item_code = item_code;
        this.description = description;
        this.unit_price = unit_price;
        this.qty = qty;
    }

    public ItemDTO() {
    }

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "item_code='" + item_code + '\'' +
                ", description='" + description + '\'' +
                ", unit_price=" + unit_price +
                ", qty=" + qty +
                '}';
    }
}
