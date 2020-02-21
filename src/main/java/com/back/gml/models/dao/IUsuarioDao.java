package com.back.gml.models.dao;

import com.back.gml.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface que se extienede de la Interface CrudRepository con parametros<ClaseEntidad, TipoDato id>
 */
public interface IUsuarioDao  extends CrudRepository<Usuario, Long> {
}
