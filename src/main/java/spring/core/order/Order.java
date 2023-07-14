package spring.core.order;

public class Order {

    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discretePrice;




    public int calculatePrice() {
        return itemPrice - discretePrice;
    }


    public Order(Long memberId, String itemName, int itemPrice, int discretePrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discretePrice = discretePrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscretePrice() {
        return discretePrice;
    }

    public void setDiscretePrice(int discretePrice) {
        this.discretePrice = discretePrice;
    }


    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discretePrice=" + discretePrice +
                '}';
    }
}
