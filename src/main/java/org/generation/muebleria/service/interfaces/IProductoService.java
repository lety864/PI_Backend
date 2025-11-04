package org.generation.muebleria.service.interfaces;

import org.generation.muebleria.model.Productos;

import java.util.List;

public interface IProductoService {

    public List<Productos> getAllProductsActive();
    Productos getProductsById(Integer id);
    Productos getProductsByCategory(Productos categoria);
    Productos updateProductsById(Integer id, Productos updateProduct);
    Productos deleteProductsById(Integer id);
}
