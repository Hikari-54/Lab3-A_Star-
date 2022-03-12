package com.hikari;

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
        // TODO:  Implement.
        return null;
    }

    /**
     *
     * This method adds a waypoint to (or potentially updates a waypoint already
     * in) the "open waypoints" collection.  If there is not already an open
     * waypoint at the new waypoint's location then the new waypoint is simply
     * added to the collection.  However, if there is already a waypoint at the
     * new waypoint's location, the new waypoint replaces the old one <em>only
     * if</em> the new waypoint's "previous cost" value is less than the current
     * waypoint's "previous cost" value.
     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        // TODO:  Implement.
        return false;
    }


    /** Returns the current number of open waypoints. **/
    public int numOpenWaypoints()
    {
        // TODO:  Implement.
        return 0;
    }


    /**
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     **/
    public void closeWaypoint(Location loc)
    {
        // TODO:  Implement.
    }

    /**
     * Returns true if the collection of closed waypoints contains a waypoint
     * for the specified location.
     **/
    public boolean isLocationClosed(Location loc)
    {
        // TODO:  Implement.
        return false;
    }
}
