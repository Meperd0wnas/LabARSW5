package edu.eci.arsw.blueprints.model;


import org.springframework.stereotype.Component;

@Component
public class NoFilter implements BlueprintFilter {

    @Override
    public Blueprint applyFilter(Blueprint bp) {
        return bp; // no hace nada, solo devuelve el blueprint tal cual
    }
}
