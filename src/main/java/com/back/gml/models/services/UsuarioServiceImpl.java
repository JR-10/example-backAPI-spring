package com.back.gml.models.services;

import com.back.gml.models.dao.IUsuarioDao;
import com.back.gml.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase Service: que implementa la Interface IusuarioService con los metodos del CRUD
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService {

    // Injeccion de dependencia
    @Autowired // injectar el usuariodao
    private IUsuarioDao usuarioDao;

    /**
     * Metodo para listar los Usuarios
     * @return
     */
    @Override
    @Transactional(readOnly = true) // consulta solo lectura
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    /**
     * Metodo para listar Usuario por Id
     * @param id
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }


    /**
     * Metodo para guardar Usuarios
     * @param usuario
     * @return
     */
    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }


    /**
     * Metodo para eliminar Usuario por Id
     * @param id
     */
    @Override
    @Transactional
    public void delete(Long id) {
        usuarioDao.deleteById(id);
    }
}
