package org.generation.muebleria.service;

import lombok.AllArgsConstructor;
import org.generation.muebleria.model.Productos;
import org.generation.muebleria.repository.ProductoRepository;
import org.generation.muebleria.service.interfaces.IProductoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoService implements IProductoService {

    //inyeccion de dependencia
    public ProductoRepository productoRepository;


    @Override
    public List<Productos> getAllProductsActive() {
        return productoRepository.findByActivoTrue();
    }

    @Override
    public List<Productos> getAllProducts() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Productos> getProductsById(Long id) {
        return Optional.ofNullable(productoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("El porducto con el id: " + id + " no existe")
        ));
    }

    @Override
    public Productos addProduct(Productos producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Productos updateProductsById(Long id, Productos updateProduct) {
        Optional<Productos> optionalProduct = productoRepository.findById(id);
        if(optionalProduct.isEmpty()) throw new IllegalArgumentException("El producto no existe");
        //obteniendo el producto de la bd
        Productos productDB = optionalProduct.get();
        if(updateProduct.getProducto() != null) productDB.setProducto(updateProduct.getProducto());
        if(updateProduct.getSku() != null) productDB.setSku(updateProduct.getSku());
        if(updateProduct.getDescripcion() != null) productDB.setDescripcion(updateProduct.getDescripcion());
        if(updateProduct.getPrecioActual() != null) productDB.setPrecioActual(updateProduct.getPrecioActual());
        if(updateProduct.getAlto() != null) productDB.setAlto(updateProduct.getAlto());
        if(updateProduct.getAncho() != null) productDB.setAncho(updateProduct.getAncho());
        if(updateProduct.getProfundidad() != null) productDB.setProfundidad(updateProduct.getProfundidad());
        if(updateProduct.getPeso() != null) productDB.setPeso(updateProduct.getPeso());
        if(updateProduct.getActivo() != null) productDB.setActivo(updateProduct.getActivo());
        if(updateProduct.getStockDisponible() != null) productDB.setStockDisponible(updateProduct.getStockDisponible());
        //fecha creacion no se actualiza
        //fecha actualizacion se actualiza al momento de guardado
        productDB.setFechaActualizacion(LocalDateTime.now());
        return productoRepository.save(productDB);
    }

    @Override
    public void desactivarProductsById(Long id) {
        Productos producto = productoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("El porducto con el id: " + id + " no existe")
        );

        //desactivar el producto con Activo
        if(producto.getActivo()){
            producto.setActivo(false);
            producto.setFechaActualizacion(LocalDateTime.now());
            productoRepository.save(producto);
        }else {
            throw new IllegalArgumentException("El producto con ID " + id + " ya está inactivo.");
        }
    }

    public void activarProductsById(Long id){
        Productos producto = productoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("El porducto con el id: " + id + " no existe")
        );

        //activar producto
        if(producto.getActivo() == null || !producto.getActivo()){
            producto.setActivo(true);
            producto.setFechaActualizacion(LocalDateTime.now());
            productoRepository.save(producto);
        }else{
            throw new IllegalArgumentException("El producto con ID " + id + " ya está activo.");
        }
    }
}
