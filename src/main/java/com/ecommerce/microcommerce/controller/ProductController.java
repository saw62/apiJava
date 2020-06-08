package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.Dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ProductController {

    //creer une instance de ProductDao
    @Autowired
    private ProductDao productDao;

    //Produits
    @GetMapping(value="Produits")
    public List<Product> listeProduits(){
        return productDao.findAll();
    }

    //Produits/{id}
    @GetMapping(value="Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id){

        return productDao.findById(id);
    }

    @PostMapping(value="/Produits")
    //annotation fait un objet de type product a partir du json
    public ResponseEntity<Void> ajouterProduit(@RequestBody Product product){

        Product product1 = productDao.save(product);
        if(product == null){
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product1.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
