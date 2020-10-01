package org.sid.catalogservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p2",types = {Product.class})
public interface ProductProjection2 {
    String getPrice();
}
