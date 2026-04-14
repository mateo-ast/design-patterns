# Flujo de Trabajo y Control de Versiones

Para garantizar la estabilidad del código y evitar conflictos, este repositorio utiliza un flujo de trabajo basado en **Pull Requests (PR)**. 

La rama principal (`main`) está protegida. Ningún desarrollador puede enviar código (*push*) directamente a esta rama. Toda nueva implementación debe realizarse en una rama aislada y someterse a revisión antes de ser integrada.

## 1. Sincronización Inicial
Antes de comenzar a trabajar en un nuevo patrón, es obligatorio sincronizar el repositorio local con la versión más reciente del servidor para evitar conflictos de historial.

```bash
git checkout main
git pull origin main
```

## 2. Creación de la Rama de Desarrollo
Cree una nueva rama a partir de `main`. El nombre de la rama debe ser exactamente el nombre del patrón a implementar, escrito en formato `kebab-case` (minúsculas separadas por guiones).

```bash
# Ejemplo para el patrón Singleton
git checkout -b singleton
```

## 3. Desarrollo y Registro de Cambios (Commits)
Implemente el código respetando las directrices de desarrollo (interfaz, nomenclatura y empaquetado). Una vez finalizado y probado localmente, registre los cambios. 

Los mensajes de commit deben ser claros y descriptivos.

```bash
git add .
git commit -m "Implementa el patrón Singleton y su prueba en consola"
```

## 4. Subida al Repositorio Remoto
Envíe su rama local al servidor de GitHub. El modificador `-u` es necesario la primera vez para establecer el vínculo entre su rama local y la remota.

```bash
git push -u origin <nombre-de-la-rama>
```

## 5. Creación del Pull Request (Revisión de Código)
La integración del código a la rama principal se gestiona exclusivamente a través de la interfaz web de GitHub:

1. Ingrese a la página del repositorio en GitHub.
2. Localice el aviso de su rama subida recientemente y haga clic en **Compare & pull request**.
3. Verifique que la rama base sea `main` y la rama a comparar sea la suya.
4. Asigne a un compañero de equipo como **Reviewer** (Revisor) en el panel lateral derecho.
5. Haga clic en **Create pull request**.

## 6. Aprobación y Fusión (Merge)
El revisor asignado recibirá una notificación. Su responsabilidad es:
1. Revisar los cambios en la pestaña **Files changed**.
2. Solicitar correcciones mediante comentarios si el código no compila o no sigue las convenciones arquitectónicas del proyecto.
3. Si el código es correcto, aprobar los cambios (*Approve*).
4. Ejecutar la fusión haciendo clic en **Merge pull request**.

Una vez que el código se ha fusionado exitosamente en `main`, la rama individual debe ser eliminada desde la plataforma web para mantener el repositorio limpio.
