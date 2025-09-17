package edu.eci.arsw;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.eci.arsw.model.Blueprint;
import edu.eci.arsw.model.Point;
import edu.eci.arsw.services.BlueprintsServices;

import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        // Usamos configuración basada en anotaciones en lugar de XML
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        BlueprintsServices services = ac.getBean(BlueprintsServices.class);

        // Registrar algunos planos
        Blueprint bp1 = new Blueprint("daniel", "house1",
                new Point[]{new Point(10, 10), new Point(20, 20)});
        Blueprint bp2 = new Blueprint("daniel", "house2",
                new Point[]{new Point(30, 30), new Point(40, 40)});
        Blueprint bp3 = new Blueprint("maria", "garden",
                new Point[]{new Point(5, 5), new Point(15, 15)});

        services.addNewBlueprint(bp1);
        services.addNewBlueprint(bp2);
        services.addNewBlueprint(bp3);

        // Consultar un plano específico
        System.out.println("Plano house1 de Daniel:");
        System.out.println(services.getBlueprint("daniel", "house1"));

        // Consultar planos de un autor
        System.out.println("\nTodos los planos de Daniel:");
        Set<Blueprint> danielBps = services.getBlueprintsByAuthor("daniel");
        danielBps.forEach(System.out::println);

        // Consultar todos los planos
        System.out.println("\nTodos los planos registrados:");
        services.getAllBlueprints().forEach(System.out::println);
    }
}
