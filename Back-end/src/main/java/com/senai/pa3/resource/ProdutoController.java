package com.senai.pa3.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private static final Logger LOGGER = Logger.getLogger(ProdutoController.class.getName());

    @GetMapping
    public void findAll() {
        LOGGER.info("Iniciado a busca de todos os produtos");
    }

    @PostMapping
    public void insert() {
        LOGGER.info("Iniciado a inserção de um novo produto");
    }
}
