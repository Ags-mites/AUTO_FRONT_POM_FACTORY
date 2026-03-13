# QA Frontend POM

Proyecto de automatización de pruebas E2E para frontend usando el patrón **Page Object Model (POM)** con **Serenity BDD** y **Cucumber**.

## Tecnologías

- Java 17
- Gradle
- Serenity BDD
- Cucumber
- JUnit 5

## Prerrequisitos

- JDK 17 instalado
- Git
- Docker y Docker Compose

## Preparación del entorno

Antes de ejecutar las pruebas, necesitas levantar el entorno del MVP:

1. Clona el repositorio del MVP:

```bash
git clone https://github.com/ElyRiven/sofkianos-mvp
```

2. Levanta los servicios:

```bash
cd sofkianos-mvp
docker compose up -d
```

## Ejecución de pruebas

Desde la raíz del proyecto:

### Linux / macOS

```bash
./gradlew clean test aggregate
```

### Windows (PowerShell)

```powershell
.\gradlew.bat clean test aggregate
```

### Ejecutar un runner específico

```bash
./gradlew test --tests "pom_pattern.runners.KudosTestRunner"
```

## Configuración

Las URLs se configuran en:

- `src/test/resources/serenity.conf`

| Propiedad | Valor por defecto |
|-----------|-------------------|
| webdriver.base.url | http://localhost:5173 |
| api.producer.base.url | http://localhost:8082 |
| api.consumer.base.url | http://localhost:8081 |

## Ver reporte

El reporte detallado de pruebas se genera automáticamente al finalizar la ejecución del comando anterior.

Para visualizar el reporte, abre el archivo `index.html` ubicado en la ruta `target/site/serenity/` en tu navegador de preferencia.

### Comandos para abrir el reporte rápidamente

**Linux:**
```bash
xdg-open target/site/serenity/index.html
```

**macOS:**
```bash
open target/site/serenity/index.html
```

**Windows (PowerShell):**
```powershell
Start-Process "target/site/serenity/index.html"
```
