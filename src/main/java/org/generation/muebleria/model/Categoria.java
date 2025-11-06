package org.generation.muebleria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="categorias")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;
    @Column(name = "nombre_categoria", nullable = false, length = 100)
    private String nombreCategoria;
    @Column(name = "activo", columnDefinition = "TINYINT(1)")
    private Boolean activo = true;

    //relacion uno -> muchos (Productos)
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Productos> productos;

    //relacion que se apunta a si misma (para categorias anidadas)
    @ManyToOne
    @JoinColumn(name = "id_categoria_padre", nullable = false)
    @JsonIgnore
    private Categoria CategoriaPadre;

}
