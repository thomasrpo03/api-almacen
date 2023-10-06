package test.api.almacen.apialmacen.model.warehouse;

public record UpdateWarehouseData(
        String name,
        String prefixBilling,
        String prefixConsecutive,
        String costCenter,
        String productionWarehouse,
        Integer maxQuantity
) {
}
