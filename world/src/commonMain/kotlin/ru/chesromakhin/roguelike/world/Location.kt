package ru.chesromakhin.roguelike.world

data class Location(val x: Int, val y: Int) {

  operator fun plus(location: Location): Location {
    return Location(x + location.x, y + location.y)
  }

  operator fun minus(location: Location): Location {
    return Location(x - location.x, y - location.y)
  }

  operator fun unaryMinus(): Location {
    return Location(-x, -y)
  }

}