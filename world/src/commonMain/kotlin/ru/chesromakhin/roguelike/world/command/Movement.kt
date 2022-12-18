package ru.chesromakhin.roguelike.world.command

import ru.chesromakhin.roguelike.world.CellType
import ru.chesromakhin.roguelike.world.Location
import ru.chesromakhin.roguelike.world.entity.Entity
import ru.chesromakhin.roguelike.world.World

class Movement(
  private val direction: MovementDirection,
  exhaustion: Int
): Command(exhaustion) {

  override fun execute(entity: Entity, world: World) {
    val location = entity.location
    val newLocation = direction.delta + location

    if (world.cells[newLocation.x][newLocation.y].type == CellType.FLOOR) {
      if (world.entities.all { it.location != newLocation }) {
        entity.location = newLocation
      }
    }

    entity.exaust = exhaustion
  }


}