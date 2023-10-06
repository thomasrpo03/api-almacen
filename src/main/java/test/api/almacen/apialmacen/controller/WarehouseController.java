package test.api.almacen.apialmacen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import test.api.almacen.apialmacen.model.warehouse.CreateWarehouseData;
import test.api.almacen.apialmacen.model.warehouse.ListWarehouseData;
import test.api.almacen.apialmacen.model.warehouse.UpdateWarehouseData;
import test.api.almacen.apialmacen.model.warehouse.WarehouseResponseData;
import test.api.almacen.apialmacen.service.WarehouseService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    private final WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @PostMapping
    public ResponseEntity<WarehouseResponseData> createWarehouse(@RequestBody @Valid CreateWarehouseData createWarehouseData, UriComponentsBuilder uriComponentsBuilder) {
        WarehouseResponseData warehouseResponseData = warehouseService.createWarehouse(createWarehouseData);
        URI url = uriComponentsBuilder.path("/api/warehouses/{id}").buildAndExpand(warehouseResponseData.id()).toUri();
        return ResponseEntity.created(url).body(warehouseResponseData);
    }


    @GetMapping
    public ResponseEntity<Page<ListWarehouseData>> getWarehouses(@PageableDefault(size = 10, sort = "name") Pageable pagination) {
        Page<ListWarehouseData> warehouses = warehouseService.getAllWarehouses(pagination);
        return ResponseEntity.ok().body(warehouses);
    }

    @GetMapping("{id}")
    public ResponseEntity<WarehouseResponseData> getWarehouseById(@PathVariable Long id) {
        WarehouseResponseData warehouseData = warehouseService.getWarehouseById(id);
        return ResponseEntity.ok().body(warehouseData);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<WarehouseResponseData> updateWarehouse(@PathVariable Long id, @RequestBody @Valid UpdateWarehouseData updateWarehouseData) {
        WarehouseResponseData warehouseResponseData = warehouseService.updateWarehouse(id, updateWarehouseData);
        return ResponseEntity.ok(warehouseResponseData);
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity deleteWarehouse(@PathVariable Long id) {
        warehouseService.deactivateWarehouse(id);
        return ResponseEntity.noContent().build();
    }


}
