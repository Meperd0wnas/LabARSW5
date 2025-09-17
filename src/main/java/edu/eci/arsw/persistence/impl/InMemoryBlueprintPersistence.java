/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persistence.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import edu.eci.arsw.model.Blueprint;
import edu.eci.arsw.persistence.BlueprintNotFoundException;
import edu.eci.arsw.persistence.BlueprintPersistenceException;
import edu.eci.arsw.persistence.BlueprintsPersistence;

import java.util.HashSet;
import java.util.Set;

@Repository
public class InMemoryBlueprintPersistence implements BlueprintsPersistence {

    private final Map<Tuple<String,String>, Blueprint> blueprints = new HashMap<>();

    @Override
    public void saveBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        Tuple<String,String> key = new Tuple<>(bp.getAuthor(), bp.getName());
        if (blueprints.containsKey(key)) {
            throw new BlueprintPersistenceException("El plano ya existe: " + key);
        }
        blueprints.put(key, bp);
    }

    @Override
    public Blueprint getBlueprint(String author, String name) throws BlueprintNotFoundException {
        Tuple<String,String> key = new Tuple<>(author, name);
        Blueprint bp = blueprints.get(key);
        if (bp == null) {
            throw new BlueprintNotFoundException("No se encontró el plano " + name + " del autor " + author);
        }
        return bp;
    }

    @Override
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException {
        Set<Blueprint> result = new HashSet<>();
        for (Tuple<String,String> key : blueprints.keySet()) {
            if (key.getElem1().equals(author)) {
                result.add(blueprints.get(key));
            }
        }
        if (result.isEmpty()) {
            throw new BlueprintNotFoundException("No se encontraron planos del autor " + author);
        }
        return result;
    }

    @Override
    public Set<Blueprint> getAllBlueprints() {
        return new HashSet<>(blueprints.values());
    }
}

