## API de Tickets

### Descripción
Esta API REST proporciona funcionalidades para gestionar tickets, incluyendo creación, lectura, actualización y eliminación. Además, permite realizar consultas paginadas y filtradas.

### Base Path
http://localhost:8013/tiquetera-api/

### Tecnologías
* **Backend:** Java 17, Spring Boot
* **Base de datos:** PostgreSQL
* **Seguridad:** API keys y tokens

### Endpoints

#### Autenticación
Para acceder a los endpoints, es necesario incluir en el header de la solicitud las siguientes cabeceras:
* **X-API-Key:** T1QU3T3R4
* **X-API-Token:** T0K3N

#### Tickets
* **GET /tickets**
  * Devuelve una lista paginada de todos los tickets.
  * **Parámetros de consulta:**
    * `page`: Número de página (opcional, por defecto 1)
    * `size`: Tamaño de página (opcional, por defecto 10)
    * `filter`: Filtro de búsqueda (opcional, por ejemplo, `status=abierto`)

* **POST /tickets**
  * Crea un nuevo ticket.
  * **Cuerpo de la solicitud:** JSON con los datos del ticket (por ejemplo, título, descripción, estado).

* **GET /tickets/{id}**
  * Obtiene un ticket específico por su ID.

* **PUT /tickets/{id}**
  * Actualiza un ticket específico.
  * **Cuerpo de la solicitud:** JSON con los nuevos datos del ticket.

* **DELETE /tickets/{id}**
  * Elimina un ticket específico.

### Ejemplo de solicitud
```json
// Crear un nuevo ticket
POST http://localhost:8013/tiquetera-api/tickets
Content-Type: application/json

{
  "title": "Mi primer ticket",
  "description": "Descripción detallada del problema",
  "status": "open"
}
