package ra.model.entity;

public class Catalog extends CatalogCombobox {
  private String depcriptions;
  private int parentId;
  private boolean catalogStatus;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, String depcriptions) {
        super(catalogId, catalogName);
        this.depcriptions = depcriptions;
    }

    public String getDepcriptions() {
        return depcriptions;
    }

    public void setDepcriptions(String depcriptions) {
        this.depcriptions = depcriptions;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
}
