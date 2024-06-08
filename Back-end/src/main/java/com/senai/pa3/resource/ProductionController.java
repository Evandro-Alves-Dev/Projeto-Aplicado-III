package com.senai.pa3.resource;

import com.senai.pa3.dto.ProductionDTO;
import com.senai.pa3.services.ProductionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/production")
public class ProductionController {

    private static final Logger LOGGER = Logger.getLogger(ProductionController.class.getName());
    private ProductionService productionService;

    public ProductionController(ProductionService productionService) {
        this.productionService = productionService;
    }

    @GetMapping
    public ResponseEntity<List<ProductionDTO>> findAll() {
        LOGGER.info("Iniciado a busca de todos os apontamentos de produção");
        var response = productionService.findAll();
        LOGGER.info("Finalizado a busca de todos os apontamentos de produção");
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductionDTO> findById(@PathVariable Long id) {
        LOGGER.info("Iniciado a busca do apontamento de produção por ID");
        var response = productionService.findById(id);
        LOGGER.info("Finalizado a busca do apontamento de produção por ID");
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<ProductionDTO> insert(@Valid @RequestBody ProductionDTO productionDTO) {
        LOGGER.info("Iniciado a inserção de um novo apontamentos de produção");
        var response = productionService.insert(productionDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(response.getIdProduction()).toUri();
        LOGGER.info("Finalizado a inserção de um novo apontamentos de produção");
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductionDTO> update(@PathVariable Long id, @Valid @RequestBody ProductionDTO productionDTO) {
        LOGGER.info("Iniciado a atualização de um apontamentos de produção");
        var response = productionService.update(id, productionDTO);
        LOGGER.info("Finalizado a atualização de um apontamentos de produção");
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        LOGGER.info("Iniciado a exclusão de apontamentos de produção");
        productionService.delete(id);
        LOGGER.info("Finalizado a exclusão de um apontamentos de produção");
        return ResponseEntity.noContent().build();
    }
}
