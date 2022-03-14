package com.hikari;

import java.util.HashMap;

/**
 * Этот класс хранит базовое состояние, необходимое алгоритму А* для расчета пути по карте.
 * Это состояние включает коллекцию "Открытых путевых точек" и другую коллекцию "Закрытых путевых точек".
 * К тому же здесь содержатся базовые операции, которые необходимы для работы алгоритма А*
 * по расчету кратчайшего пути.
 **/
public class AStarState
{
    /** Это ссылка на карту, по которой перемещается алгоритм А*. **/
    private Map2D map;

    /** Я проинициализировал две хэш-мапы, одну для открытых вершин, другую для закрытых.
     * Ключом служит <Location>(местоположение вершины) , а значением <Waypoint>(сама вершина) **/

    private HashMap<Location, Waypoint> openWaypoints = new HashMap<>();
    private HashMap<Location, Waypoint> closedWaypoints = new HashMap<>();

    /**
     * Инициализация нового объекта состояния для работы А*.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /** Возвращает карту, по которой перемещается алгоритм A*. **/
    public Map2D getMap()
    {
        return map;
    }

    /**
     * Этот метод сканирует все Открытые вершины и возвращает путевую точку с минимальной общей ценой перемещения.
     * Если Открытых верших нет, этот метод вернет <code>null</code>
     **/
    public Waypoint getMinOpenWaypoint()
    {
        /** Если доступных открытых вершин нет - вернет null. **/
        if (numOpenWaypoints() == 0) {
            return null;
        }

        Waypoint minWaypoint = null;
        float min = Float.MAX_VALUE;
        /** Перебирает все открытые вершины и ищет ту, у которой минимальная цена перемещения. **/
        for (Waypoint waypoint : openWaypoints.values()) {
            float cost = waypoint.getTotalCost();
            if (cost < min) {
                min = cost;
                minWaypoint = waypoint;
            }
        }
        return minWaypoint;
    }

    /**
     * Этот метод добавляет путевую точку (или потенциально заменяет уже существующую
     * путевую точку) в коллекцию "Открытых путевых точек".
     * Если этой путевой точки еще нет в коллекции "Открытых путевых точек", то он просто добавит её.
     * Однако если в этом месте расположения уже существует путевая точка, то новая точка
     * заменяет старую только в том случае, если значение "предыдущей стоимости"
     * новой точки меньше, чем значение "предыдущей стоимости" новой точки.
     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        Waypoint openWP = openWaypoints.get(newWP.loc);
        /** Добавляет новую путевую точку только в том случае, если существующая вершина хуже новой.
         * Либо если еще нет вершины с данным расположением **/
        if (openWP == null || newWP.getPreviousCost() < openWP.getPreviousCost()) {
            openWaypoints.put(newWP.loc, newWP);
            return true;
        }
        return false;
    }


    /** Возвращает текущее кол-во открытых путевых точек. **/
    public int numOpenWaypoints()
    {
        return openWaypoints.size();
    }


    /**
     * Этот метод перемещает путевую точку в Указанной локации
     * из открытого списка в закрытый список
     **/
    public void closeWaypoint(Location loc)
    {
        /** Удаляет вершину с указанным ключом из открытых вершин. **/
        Waypoint waypoint = openWaypoints.remove(loc);
        if (openWaypoints != null) {
            /** Переносит его(добавляет) в коллекцию закрытых вершин. **/
            closedWaypoints.put(loc, waypoint);
        }
    }

    /**
     * Возвращает true, если коллекция закрытых путевых точек содержит
     * путевую точку для указанного местоположения.
     **/
    public boolean isLocationClosed(Location loc)
    {
        /** Метод containsKey() ищет заданный ключ (loc) в коллекции закрытых путевых вершин.
         * Если он есть - true, если нет - false **/
        return closedWaypoints.containsKey(loc);
    }
}
