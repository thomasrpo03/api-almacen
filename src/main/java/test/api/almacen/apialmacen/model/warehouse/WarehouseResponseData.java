package test.api.almacen.apialmacen.model.warehouse;

public record WarehouseResponseData(
        Long id,
        String name,
        String prefixBilling,
        String prefixConsecutive,
        String costCenter,
        String productionWarehouse,
        Integer maxQuantity
) {
}
