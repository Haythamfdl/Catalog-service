package org.sid.catalogservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = {Product.class})
public interface ProductProjection {
    Long getId();
    String getPrice();
}
