# CRUD Backend - Codesa

Este proyecto representa el backend de una aplicación CRUD de estudiantes y profesores, construido con **Spring Boot**. Implementa prácticas modernas como DTOs, paginación, validación, logs y estructura en capas (controlador-servicio-repositorio).

## 🛠 Tecnologías utilizadas

- Java 17
- Spring Boot 3+
- Spring Data JPA
- H2 Database (modo memoria)
- ModelMapper
- Lombok
- Spring Security (si se implementa)
- Spring Cloud Gateway (si se extiende)
- SLF4J (Logs)

## 🚀 ¿Cómo ejecutar el proyecto?

### 1. Clona el repositorio

```bash
git clone https://github.com/TU_USUARIO/crud-backend-codesa.git
```

### 2. Ejecuta el proyecto

Desde el IDE o la terminal:

```bash
./mvnw spring-boot:run
```

### 3. Acceder a la consola H2

```
http://localhost:8080/h2-console
```

- JDBC URL: **jdbc:h2:mem:codesadb**
- Usuario: **santiagocodesa**
- Contraseña: **457codesa**

## 📄 Endpoints principales

- `GET /api/estudiantes`
- `GET /api/profesores`
- `POST /api/estudiantes`
- `PUT /api/estudiantes/{id}`
- `DELETE /api/estudiantes/{id}`
- *(similar para profesores)*

## 🧪 Carga de datos de prueba

Hay un script **'carga_estudiantes_profesores.sql'** que permite insertar múltiples registros de ejemplo.


---

## 📂 Estructura del proyecto

```
├── controller/
├── dto/
├── entity/
├── repository/
├── service/
│   ├── impl/
├── exception/
├── config/
```

---

## 😎 Autor

Desarrollado por Santiago Angulo. Proyecto Spring Boot para  la prueba técnica Codesa, "Sistema de Registro Escolar".
