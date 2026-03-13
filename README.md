# QA Frontend POM - Pruebas Automatizadas

Proyecto de automatización de pruebas E2E funcionales para frontend usando el patrón **Page Object Model (POM)**.

Este proyecto está construido con:
- Java
- Gradle
- Cucumber
- Serenity BDD
- JUnit

## Requisitos previos

- Java 17 (o versión compatible con el proyecto)
- Docker y Docker Compose
- Git

## Preparación del entorno

1. Clonar este repositorio.
2. Clonar también el repositorio necesario para el entorno de pruebas:

```bash
git clone https://github.com/ElyRiven/sofkianos-mvp
```

3. Entrar al proyecto clonado (`sofkianos-mvp`) y levantar los servicios con Docker:

```bash
docker compose up -d
```

Cuando los servicios estén arriba, ya puedes continuar con las pruebas desde este proyecto.

## Ejecución de pruebas

Desde la raíz de este proyecto (`qa-frontend-pom`), ejecutar:

```bash
./gradlew clean test
```

Si deseas ejecutar por runner, puedes usar:

```bash
./gradlew test --tests "pom_pattern.runners.KudosTestRunner"
```

Opcionalmente, para generar/consultar reportes de Serenity:

```bash
./gradlew reports
```

Los resultados y reportes se generan en carpetas como `target/site/serenity` y `build/reports`.

## Configuración de URLs

Las URLs del frontend y servicios API se configuran en:

- `src/test/resources/serenity.conf`

Propiedades principales:

- `webdriver.base.url`: URL del frontend (por defecto `http://localhost:5173`)
- `api.producer.base.url`: URL API producer (por defecto `http://localhost:8082`)
- `api.consumer.base.url`: URL API consumer (por defecto `http://localhost:8081`)

Si necesitas otro entorno, cambia estos valores en `serenity.conf` antes de ejecutar las pruebas.
