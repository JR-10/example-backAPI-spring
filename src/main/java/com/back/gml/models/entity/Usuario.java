    package com.back.gml.models.entity;


    import javax.persistence.*;
    import java.io.Serializable;
    import java.util.Date;

    /**
     * Esta Clase mapea los campos de la tabla en la BD
     * Clase de tipo Entity
     */
    @Entity
    @Table(name="usuarios")
    public class Usuario implements Serializable {

        // identificar id como llave primaria y como se genera(strategia)
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY )
        private Long id;

        private String nombres;
        private String apellidos;
        private String email;
        private String cargo;
        private String empresa;
        private String direccion;

        @Column(name = "detalle_dir")
        private String detalleDir;

        private String pais;
        private String ciudad;

        @Column(name = "create_at") // nombre del campo en la BD
        @Temporal(TemporalType.DATE)
        private Date createAt; // nombre del atributo en la clase


        // Fecha automatica
        @PrePersist
        public void prePersist(){
            createAt = new Date();
        }

        // Geters & Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombres() {
            return nombres;
        }

        public void setNombres(String nombres) {
            this.nombres = nombres;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        public String getEmpresa() {
            return empresa;
        }

        public void setEmpresa(String empresa) {
            this.empresa = empresa;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getDetalleDir() {
            return detalleDir;
        }

        public void setDetalleDir(String detalleDir) {
            this.detalleDir = detalleDir;
        }

        public String getPais() {
            return pais;
        }

        public void setPais(String pais) {
            this.pais = pais;
        }

        public String getCiudad() {
            return ciudad;
        }

        public void setCiudad(String ciudad) {
            this.ciudad = ciudad;
        }

        public Date getCreateAt() {
            return createAt;
        }

        public void setCreateAt(Date createAt) {
            this.createAt = createAt;
        }

        // serial version Id (atributo estatito)
        private static final long serialVersionUID = 1L;

    }

    /**
     * clase DAO o Repository = su funcion es acceder y hacer consultas a la BD
     *
     * clase Service = puede contener a las clases y dentro de sus metodos podrian colabiorar o interatuar varios datos en una sola transaccion
     *
     * SpringDataJPA = implemetamos una interface CrudRepository que tiene los metodos basicos de un CRUD
     * */