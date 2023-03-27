package ra.model.entity;

public class Producer {
    private int producerId;
    private String producerName;
    private String image;
    private boolean producerStatus;

    public Producer() {
    }

    public Producer(int producerId, String producerName, String image, boolean producerStatus) {
        this.producerId = producerId;
        this.producerName = producerName;
        this.image = image;
        this.producerStatus = producerStatus;
    }

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isProducerStatus() {
        return producerStatus;
    }

    public void setProducerStatus(boolean producerStatus) {
        this.producerStatus = producerStatus;
    }
}
