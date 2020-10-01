package org.sid.catalogservice;

import org.sid.catalogservice.dao.CategoryRepository;
import org.sid.catalogservice.dao.ProductRepository;
import org.sid.catalogservice.entities.Category;
import org.sid.catalogservice.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CatalogServiceApplication implements CommandLineRunner {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(CatalogServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Product.class,Category.class);
        System.out.println("Ajouter deux catégories");
        categoryRepository.save(new Category(null,"Computers",null));
        categoryRepository.save(new Category(null,"Printers",null));
        System.out.println("Ajout de produits");
        Category c1=categoryRepository.findById(1L).get();
        productRepository.save(new Product(null,"HP 5432",9400,c1));
        productRepository.save(new Product(null,"MacBook 123",10000,c1));
        productRepository.save(new Product(null,"DELL 563",8400,c1));
        Category c2=categoryRepository.findById(2L).get();
        productRepository.save(new Product(null,"Printer HP",5000,c2));
        productRepository.save(new Product(null,"Printer Epson",4000,c2));
        System.out.println("--------------------------------------------");
        productRepository.findAll().forEach(product -> {
            System.out.println(product.getName());
        });
    }
}
