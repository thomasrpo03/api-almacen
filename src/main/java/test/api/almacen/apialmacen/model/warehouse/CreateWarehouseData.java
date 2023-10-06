package test.api.almacen.apialmacen.model.warehouse;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record CreateWarehouseData(

        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Prefix billing is required")
        String prefixBilling,

        @NotBlank(message = "Prefix consecutive is required")
        String prefixConsecutive,

        @NotBlank(message = "Cost center is required")
        String costCenter,

        @NotBlank(message = "Production warehouse is required")
        String productionWarehouse,

        @NotNull(message = "Max quantity is required")
        Integer maxQuantity

) {
}
