package test.api.almacen.apialmacen.model.warehouse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "Warehouse")
@Table(name = "warehouses")
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "prefixBilling")
    private String prefixBilling;

    @Column(name = "prefixConsecutive")
    private String prefixConsecutive;

    @Column(name = "costCenter")
    private String costCenter;

    @Column(name = "productionWarehouse")
    private String productionWarehouse;

    @Column(name = "maxQuantity")
    private Integer maxQuantity;

    @Column(name = "creationDate")
    private Date creationDate;

    @Column(name = "updateDate")
    private Date updateDate;

    @Column(name = "active")
    private Boolean active;

    public Warehouse(CreateWarehouseData createWarehouseData) {
        this.name = createWarehouseData.name();
        this.prefixBilling = createWarehouseData.prefixBilling();
        this.prefixConsecutive = createWarehouseData.prefixConsecutive();
        this.costCenter = createWarehouseData.costCenter();
        this.productionWarehouse = createWarehouseData.productionWarehouse();
        this.maxQuantity = createWarehouseData.maxQuantity();
        this.creationDate = new Date();
        this.active = true;
    }

    public void updateData(UpdateWarehouseData updateWarehouseData) {
        if (updateWarehouseData.name() != null) {
            this.name = updateWarehouseData.name();
        }
        if (updateWarehouseData.prefixBilling() != null) {
            this.prefixBilling = updateWarehouseData.prefixBilling();
        }
        if (updateWarehouseData.prefixConsecutive() != null) {
            this.prefixConsecutive = updateWarehouseData.prefixConsecutive();
        }
        if (updateWarehouseData.costCenter() != null) {
            this.costCenter = updateWarehouseData.costCenter();
        }
        if (updateWarehouseData.productionWarehouse() != null) {
            this.productionWarehouse = updateWarehouseData.productionWarehouse();
        }
        if (updateWarehouseData.maxQuantity() != null) {
            this.maxQuantity = updateWarehouseData.maxQuantity();
        }
        this.updateDate = new Date();
    }

    public void deactivateWarehouse() {
        this.active = false;
    }
}
