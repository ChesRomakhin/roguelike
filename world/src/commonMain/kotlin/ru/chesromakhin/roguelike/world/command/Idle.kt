package ru.chesromakhin.roguelike.world.command

import ru.chesromakhin.roguelike.world.entity.Entity
import ru.chesromakhin.roguelike.world.World

class Idle : Command() {
  override fun execute(entity: Entity, world: World) {
    //do nothing but increment exhaust by move amount
  }

}