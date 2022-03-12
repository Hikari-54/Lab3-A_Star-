package com.hikari;

import java.util.Objects;

/**
 * Этот класс представляет конкретную точку на 2D карте.
 * Координаты - целочисленные значения.
 **/
public class Location
{
    /** X координата конкретной точки. **/
    public int xCoord;

    /** Y координата конкретной точки. **/
    public int yCoord;

    /** Переопределение метода equals. **/
    @Override
    public boolean equals(Object o) {
        /** Строка ниже сравнивает ссылки двух сравниваемых объектов
         * если ссылки равны (указывают на один и тот же участок памяти),
         * то они обе ссылаются на один и тот же объект **/
        if (this == o) return true;
        /** <o == null> - проверяет не является ли вторая ссылка пустой (ни на что не ссылается) **/
        /** <getClass() != o.getClass()> - сравнивает классы двух объектов.
         * Если они не равны, то не равны и сами объекты **/
        if (o == null || getClass() != o.getClass()) return false;
        /** Здесь объект <o> базового класса (Object) преобразуется к подклассу (Location) **/
        Location location = (Location) o;
        /** Поскольку мы сравниваем только примитивные типы данных (int), то нам достаточно оператора == **/
        return xCoord == location.xCoord && yCoord == location.yCoord;
        /** Если координаты X,Y попарно равны, то вернется true. **/
    }

    /** Переопределение метода hashCode.
     * Эти два метода (equals, hashCode) ОБЯЗАТЕЛЬНО переопределяются вместе!
     * Чтобы их формальные контракты(свойства) выполнялись корректно,
     * тк они частично связаны друг с другом **/
    @Override
    public int hashCode() {
        return Objects.hash(xCoord, yCoord);
    }

    /** Этот конструктор инициализации.
     * Он создает конкретную точку с заданными целочисленными координатами по X и Y **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Конструктор по-умолчанию. Создает точку с нулевыми координатами **/
    public Location()
    {
        this(0, 0);
    }
}