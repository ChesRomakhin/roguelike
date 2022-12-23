package ru.chesromakhin.roguelike.world.command

import ru.chesromakhin.roguelike.world.CellType
import ru.chesromakhin.roguelike.world.entity.Entity
import ru.chesromakhin.roguelike.world.World

class Movement(
  private val direction: Direction,
  exhaustion: Int
): Command(exhaustion) {

  override fun execute(entity: Entity, world: World) {
    val location = entity.location
    val newLocation = direction.delta + location

    if (world.cells[newLocation.x][newLocation.y].type == CellType.FLOOR) {
      val e = world.getEntity(newLocation)
      if (e == null) {
        entity.location = newLocation
      }
    }

    entity.exaust = exhaustion
  }


}