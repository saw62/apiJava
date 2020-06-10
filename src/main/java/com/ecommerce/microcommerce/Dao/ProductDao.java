package com.ecommerce.microcommerce.Dao;

import com.ecommerce.microcommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//repository indique les methode qui manipule les données dans la bdd
@Repository
//premier param entity deuxiéme type de l'id
public interface ProductDao extends JpaRepository<Product, Integer> {
    Product findById(int id);

    List<Product> findByPrixGreaterThan (int PrixLimit);

    //creer une requête manuelement

    @Query(value = "SELECT p FROM Product p WHERE p.prix > :prixLimit")
    List<Product> chercherUnProduitCher(@Param("prixLimit") int prix);

}
