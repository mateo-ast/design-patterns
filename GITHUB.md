Flujo de Trabajo

**1. Revisar las asignaciones y crear la rama** `🌐 En GitHub`
* Diríjanse a la pestaña de **Issues** en el repositorio y abran la tarea asignada con el nombre de su patrón.
* En la barra lateral derecha, bajo la sección "Development", hagan clic en **"Create a branch"**.
* Dejen las opciones por defecto y hagan clic en **"Create branch"**. GitHub generará y vinculará la rama automáticamente (ej: `3-singleton`).

**2. Actualizar el repositorio local y bajar la rama** `💻 En VS Code (Terminal)`
* Antes de comenzar a programar, asegúrense de actualizar la rama principal y luego descargar la rama que acaban de crear:
  ```bash
  git checkout main
  git pull origin main
  git fetch origin
  git checkout nombre-de-la-rama
  ```

**3. Desarrollo y Commits** `💻 En VS Code`
* Escriban el código y realicen los commits necesarios a medida que avanzan (`git add .` y `git commit -m "mensaje descriptivo"`).
* ⚠️ **IMPORTANTE:** No modifiquen la carpeta ni la clase que llevan el nombre del patrón para no romper la lógica de ejecución.

**4. Subir la rama al servidor** `💻 En VS Code (Terminal)`
* Cuando el código del patrón esté terminado y probado, suban sus cambios a GitHub:
  ```bash
  git push origin nombre-de-la-rama
  ```

**5. Abrir el Pull Request (PR)** `🌐 En GitHub`
* Ingresen a la página del repositorio en GitHub. Verán un botón que indica **"Compare & pull request"**. Hagan clic allí.
* Creen el PR y notifiquen al equipo para que otro integrante pueda revisarlo y hacer la integración (merge) a `main`.
* 🛑 **Regla clave:** Solo un integrante que no haya hecho el PR puede aprobarlo.

Una vez que su código sea aprobado e integrado, vuelvan al **Paso 1** para comenzar con el siguiente patrón asignado.
