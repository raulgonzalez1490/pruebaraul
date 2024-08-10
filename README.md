# Proyecto prueba de Raúl González Trinidad

Instrucciones para ejecutar el proyecto en un ambiente local 

## Requisitos previos 

- **Git** - Para el repositorio de código
- **Java** - Versión 8
- **PostgreSQL** - Versión 16
- **Maven** - Para la gestión de dependencias
- **Postman** - Para la probar la API

En **pgAdmin** crear la base de datos desde un editor (QueryTool) con la siguiente estructura donde el **OWNER** debe corresponder al usuario, posteriormente confirmar su creación: 

```sql
CREATE DATABASE pruebaraul
    WITH
    OWNER = {{USUARIO}}
    ENCODING = 'UTF8'
    LOCALE_PROVIDER = 'libc'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
```

## Instalación y ejecución 

Para iniciar el proyecto en un ambiente local es necesario clonar el proyecto desde GitHub 

```bash
# Clonar el repositorio
git clone https://github.com/raulgonzalez1490/pruebaraul.git

# Navegar al directorio del proyecto
cd pruebaraul

# Configurar conexión a base de datos 
Dentro del proyecto editar el archivo application.properties y agregar los datos del usuario (user & password)

# Compilar el proyecto y descargar dependencias
mvn clean install
```

Para ejecuar el proyecto abrir una consola en la raíz del proyecto y ejecutar el siguiente comando:

```bash 
mvn spring-boot:run
```

## Pruebas 
El proyecto incluye Swaager para ver la definición de la API de empleados, para visualizarla ingresar a: http://localhost:8080/swagger-ui/#/empleado-controller

En la raíz del proyecto se adjunta la colección de Postman(v2.1) la cual se debe importar para visualizar los métodos creados.

