package ra.model.entity;

public class Image {
    private int imageId;
    private String imageName;
    private String link;
    private int productId;
    private boolean imageStatus;

    public Image() {
    }

    public Image(int imageId, String imageName, String link, int productId, boolean imageStatus) {
        this.imageId = imageId;
        this.imageName = imageName;
        this.link = link;
        this.productId = productId;
        this.imageStatus = imageStatus;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public boolean isImageStatus() {
        return imageStatus;
    }

    public void setImageStatus(boolean imageStatus) {
        this.imageStatus = imageStatus;
    }
}
