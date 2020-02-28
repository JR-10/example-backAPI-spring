package com.back.gml.controllers;

import com.back.gml.models.entity.Usuario;
import com.back.gml.models.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase Controlador
 */
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UsuarioRestController {

    @Autowired
    private IUsuarioService usuarioService; // importamos la interface IUsuarioService


    // Estructura del metodo
    // @tipo de metodo
    // modificadorAcceso

    /**
     * Metodo Listar Usuarios
     * @return
     */
    @GetMapping("/usuarios")
    public List<Usuario> index(){
        return usuarioService.findAll();
    }

    /**
     * Metodo listar usuario por Id
     * @param id
     * @return
     */
    @GetMapping("/usuarios/{id}")
    public Usuario show(@PathVariable Long id){
        return usuarioService.findById(id);
    }

    /**
     * Metodo crear Usuario
     * @param usuario
     * @return
     */
    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED) // Retorna el estatus 201 de creado
    public Usuario create(@RequestBody Usuario usuario){ //@RequestBody => formato json
        return usuarioService.save(usuario);
    }


    /**
     * Metodo Actualizar Usuario
     * @param usuario
     * @param id
     * @return
     */
    @PutMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id){

        // buscar usuario
        Usuario usuarioActual = usuarioService.findById(id);

        // setear los nuevos valores
        usuarioActual.setNombres(usuario.getNombres());
        usuarioActual.setApellidos(usuario.getApellidos());
        usuarioActual.setEmail(usuario.getEmail());
        usuarioActual.setCargo(usuario.getCargo());
        usuarioActual.setEmpresa(usuario.getEmpresa());
        usuarioActual.setDireccion(usuario.getDireccion());
        usuarioActual.setDetalleDir(usuario.getDetalleDir());
        usuarioActual.setPais(usuario.getPais());
        usuarioActual.setCiudad(usuario.getCiudad());

        return usuarioService.save(usuarioActual);
    }


    /**
     * Metodo Eliminar Usuario
     * @param id
     */
    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        usuarioService.delete(id);
    }

}
