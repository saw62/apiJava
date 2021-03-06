package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.Dao.ProductDao;
import com.ecommerce.microcommerce.exceptions.ProduitIntrouvableException;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Product afficherUnProduit(@PathVariable int id) throws ProduitIntrouvableException {
        Product produit = productDao.findById(id);

        if(produit == null) throw new ProduitIntrouvableException("le produit avec l'id " + id + " n'existe pas");

        return produit;
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

    @GetMapping(value="test/Produits/{PrixLimit}")
    public  List<Product> trouverProduit(@PathVariable int PrixLimit){
        return productDao.chercherUnProduitCher(PrixLimit);
    }

}
