package test.api.almacen.apialmacen.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import test.api.almacen.apialmacen.model.warehouse.CreateWarehouseData;
import test.api.almacen.apialmacen.model.warehouse.ListWarehouseData;
import test.api.almacen.apialmacen.model.warehouse.UpdateWarehouseData;
import test.api.almacen.apialmacen.model.warehouse.WarehouseResponseData;

import javax.transaction.Transactional;

public interface WarehouseService {
    WarehouseResponseData createWarehouse(CreateWarehouseData createWarehouseData);

    Page<ListWarehouseData> getAllWarehouses(Pageable pagination);

    WarehouseResponseData getWarehouseById(Long id);

    WarehouseResponseData updateWarehouse(Long id, UpdateWarehouseData updateWarehouseData);

    @Transactional
    void deactivateWarehouse(Long id);
}
