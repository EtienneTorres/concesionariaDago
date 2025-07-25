# concesionariaDago
🚗 Concesionaria CRUD 
Este proyecto consiste en una aplicación de escritorio para la gestión de automóviles en una concesionaria. Permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre vehículos disponibles a la venta, con persistencia en base de datos y respetando el modelo de capas: lógica, persistencia e interfaz gráfica.

✅ Funcionalidades
Alta de autos: cargar nuevos vehículos al sistema.

Baja de autos: eliminar vehículos existentes.

Modificación de autos: actualizar los datos de un vehículo registrado.

Listado de autos: visualización de todos los autos cargados.

📋 Modelo de datos
Clase Automovil con los siguientes atributos:

id

modelo

marca

motor

color

patente

cantidadPuertas

🧱 Arquitectura
Se implementa un modelo de capas bien definido:

Lógica de negocio

Persistencia (JPA/Hibernate)

Interfaz gráfica (Swing)

🛠️ Tecnologías utilizadas
Java

Swing (GUI)

JPA 

Base de datos (MySQL)


🧪 Posibles mejoras futuras
Filtro por marca, modelo o patente

Ordenar resultados por cantidad de puertas

Exportar el catálogo a PDF o Excel

Login de usuario para administración

👨‍💻 Autor
Etienne Torres
📧 etiennedagotorres@gmail.com
