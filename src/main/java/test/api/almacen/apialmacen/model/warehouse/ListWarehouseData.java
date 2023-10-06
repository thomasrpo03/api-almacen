package test.api.almacen.apialmacen.model.warehouse;

public record ListWarehouseData(
        Long id,
        String name,
        String prefixBilling,
        String prefixConsecutive,
        String costCenter,
        String productionWarehouse,
        Integer maxQuantity
) {
    public ListWarehouseData(Warehouse warehouse) {
        this(warehouse.getId(), warehouse.getName(), warehouse.getPrefixBilling(), warehouse.getPrefixConsecutive(), warehouse.getCostCenter(), warehouse.getProductionWarehouse(), warehouse.getMaxQuantity());
    }
}
