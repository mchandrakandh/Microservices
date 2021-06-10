package com.edureka.cataloguems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edureka.cataloguems.model.Catalogue;

public interface CatalogueRepository extends JpaRepository<Catalogue, Long>{

}
