package id.ac.binus.cestwo_skin.model;

public class Orders {
    private int orderId;
    private String skinName, skinPrice, skinPoster, skinSoB;

    public Orders(String skinName, String skinPrice, String skinSoB, String skinPoster) {
//        this.orderId = orderId;
        this.skinName = skinName;
        this.skinPrice = skinPrice;
        this.skinPoster = skinPoster;
        this.skinSoB = skinSoB;
//        this.image = image;
    }

    public int getOrderId() {
        return orderId;
    }
    public String getSkinName() {
        return skinName;
    }

    public String getSkinPrice() {
        return skinPrice;
    }

    public String getSkinPoster() {
        return skinPoster;
    }

    public String getSkinSoB() {
        return skinSoB;
    }

//    public int getImage() {
//        return image;
//    }
}
