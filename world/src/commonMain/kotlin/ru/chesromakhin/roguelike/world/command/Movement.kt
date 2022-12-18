package ru.chesromakhin.roguelike.world.command

import ru.chesromakhin.roguelike.world.entity.Entity
import ru.chesromakhin.roguelike.world.World

class Movement(
  val direction: MovementDirection
): Command() {

  override fun execute(entity: Entity, world: World) {
    
  }


}