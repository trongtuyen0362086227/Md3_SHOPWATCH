package ra.model.entity;

import java.util.Date;
import java.util.List;

public class Product {
    private int productId;
    private String productName;
    private float price;
    private int quantity;
    private String title;
    private Date created;
    private String image;
    private List<String> imageLink;
    private int producerid;
    private int catalogId;
    private String depcriptions;
    private boolean productstatus;

    public Product() {
    }

    public Product(int productId, String productName, float price, int quantity, String title, Date created, String image, List<String> imageLink, int producerid, int catalogId, String depcriptions, boolean productstatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.title = title;
        this.created = created;
        this.image = image;
        this.imageLink = imageLink;
        this.producerid = producerid;
        this.catalogId = catalogId;
        this.depcriptions = depcriptions;
        this.productstatus = productstatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getImageLink() {
        return imageLink;
    }

    public void setImageLink(List<String> imageLink) {
        this.imageLink = imageLink;
    }

    public int getProducerid() {
        return producerid;
    }

    public void setProducerid(int producerid) {
        this.producerid = producerid;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getDepcriptions() {
        return depcriptions;
    }

    public void setDepcriptions(String depcriptions) {
        this.depcriptions = depcriptions;
    }

    public boolean isProductstatus() {
        return productstatus;
    }

    public void setProductstatus(boolean productstatus) {
        this.productstatus = productstatus;
    }
}
