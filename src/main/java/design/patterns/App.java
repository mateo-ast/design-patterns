package design.patterns;

public class App {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java design.patterns.App <nombre-del-patron>");
            System.out.println("Ejemplo: java design.patterns.App chain-of-responsibility");
            return;
        }

        String input = args[0];
        String className = toPascalCase(input);
        
        String[] categories = {"behavioral", "creational", "structural"};
        boolean executed = false;

        for (String category : categories) {
            try {
                String packageName = "design.patterns." + category + "." + input.toLowerCase().replace("-", "");
                String fullPath = packageName + "." + className;
                
                Class<?> clazz = Class.forName(fullPath);
                
                if (DesignPattern.class.isAssignableFrom(clazz)) {
                    
                    DesignPattern pattern = (DesignPattern) clazz.getDeclaredConstructor().newInstance();
                    
                    System.out.println("--- Executing: " + className + " (" + category + ") ---");
                    
                    pattern.run();
                    
                    executed = true;
                    break;
                } else {
                    System.err.println("La clase " + className + " fue encontrada, pero no implementa DesignPattern.");
                }
                
            } catch (ClassNotFoundException e) {
                continue;
            } catch (Exception e) {
                System.err.println("Error al instanciar el patrón: " + e.getMessage());
                e.printStackTrace();
                return;
            }
        }

        if (!executed) {
            System.out.println("No se pudo encontrar el patrón: " + className);
        }
    }

    private static String toPascalCase(String input) {
        StringBuilder result = new StringBuilder();
        for (String part : input.split("-")) {
            if (!part.isEmpty()) {
                result.append(Character.toUpperCase(part.charAt(0)))
                      .append(part.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }
}