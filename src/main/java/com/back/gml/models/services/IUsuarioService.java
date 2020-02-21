package com.back.gml.models.services;

import com.back.gml.models.entity.Usuario;

import java.util.List;

/**
 * Interface con los Metodos del CRUD
 */
public interface IUsuarioService {

    public List<Usuario> findAll(); // listar todos

    public Usuario findById(Long id); // listar por id

    public Usuario save(Usuario usuario); // guardar usuario

    public void delete(Long id); // eliminar por id
}
