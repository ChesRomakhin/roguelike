package ru.chesromakhin.roguelike.world.command

import ru.chesromakhin.roguelike.world.Location

enum class Direction(val delta: Location) {

  UP(Location(0, 1)),
  RIGHT(Location(1, 0)),
  BOTTOM(Location(0, -1)),
  LEFT(Location(-1, 0)),

}
