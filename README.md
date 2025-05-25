# 📚 NextBook

**NextBook** es una aplicación web desarrollada con Java y Spring Boot para la gestión de libros, usuarios y préstamos en bibliotecas. Está diseñada como parte de un proyecto educativo y se despliega en la nube con Render.com.

---

## 🚀 Tecnologías utilizadas

- Java 21
- Spring Boot 3.4.5
- Spring MVC + Spring Security
- Spring Data JPA + PostgreSQL
- Thymeleaf + Thymeleaf Layout Dialect
- Bootstrap 5 (interfaz adaptativa)
- Render.com (despliegue)

---

## 🧪 Funcionalidades principales

- Registro e inicio de sesión de usuarios
- Roles diferenciados: Lector y Administrador
- CRUD de:
  - Usuarios
  - Libros
  - Categorías
  - Préstamos
  - Devoluciones
  - Sanciones
- Generación de informes (resumenes de préstamos, sanciones, etc.)
- Gestión de errores y validaciones
- Layout común y navegación con fragmentos Thymeleaf

---

## ⚙️ Configuración del despliegue en Render

### Build Command
```bash
./mvnw clean package
```

### Start Command
```bash
java -jar target/nextbook-0.0.1-SNAPSHOT.jar
```

### Variables de entorno necesarias (Render.com)
| Variable         | Descripción                      |
|------------------|----------------------------------|
| `DATABASE_URL`   | URL JDBC de la base de datos     |
| `DB_USERNAME`    | Usuario de PostgreSQL            |
| `DB_PASSWORD`    | Contraseña de PostgreSQL         |

**Ejemplo de configuración en `application.properties`:**
```properties
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

---

## 📂 Estructura del proyecto

```
nextbook/
├── src/
│   ├── main/
│   │   ├── java/com/nextbook/
│   │   │   ├── modelo/
│   │   │   ├── repositorio/
│   │   │   ├── servicio/
│   │   │   ├── controlador/
│   │   │   └── config/
│   │   └── resources/
│   │       ├── templates/
│   │       │   ├── usuarios/
│   │       │   ├── libros/
│   │       │   ├── categorias/
│   │       │   ├── prestamos/
│   │       │   ├── devoluciones/
│   │       │   ├── sanciones/
│   │       │   ├── login.html
│   │       │   └── layout.html
│   │       └── static/
│   │           └── img/
│   │               └── logo.png
├── pom.xml
└── README.md
```

---

## 🌍 Producción

Una vez desplegado correctamente, el proyecto estará disponible en una URL pública como:
```
https://nextbook.onrender.com
```

---

## 👤 Autor

**Jorge Durán Librero**

Proyecto integrado para el ciclo de Desarrollo de Aplicaciones Web (DAW).
