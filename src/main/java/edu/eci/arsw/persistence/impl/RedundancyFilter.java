package edu.eci.arsw.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import edu.eci.arsw.model.Blueprint;
import edu.eci.arsw.model.BlueprintFilter;
import edu.eci.arsw.model.Point;

public class RedundancyFilter implements BlueprintFilter {

    @Override
    public Blueprint applyFilter(Blueprint bp) {
        List<Point> points = bp.getPoints();
        List<Point> filtered = new ArrayList<>();

        if (!points.isEmpty()) {
            filtered.add(points.get(0));
            for (int i = 1; i < points.size(); i++) {
                if (!points.get(i).equals(points.get(i - 1))) {
                    filtered.add(points.get(i));
                }
            }
        }

        return new Blueprint(bp.getAuthor(), bp.getName(), filtered.toArray(new Point[0]));
    }
}
