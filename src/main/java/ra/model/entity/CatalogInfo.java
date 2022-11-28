package ra.model.entity;

public class CatalogInfo extends Catalog{
    private String parentName;

    public CatalogInfo() {
    }

    public CatalogInfo(int catalogId, String catalogName, String depcriptions, String parentName) {
        super(catalogId, catalogName, depcriptions);
        this.parentName = parentName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
