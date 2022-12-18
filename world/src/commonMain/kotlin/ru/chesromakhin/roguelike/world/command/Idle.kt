package ru.chesromakhin.roguelike.world.command

import ru.chesromakhin.roguelike.world.entity.Entity
import ru.chesromakhin.roguelike.world.World

class Idle(exhaustion: Int) : Command(exhaustion) {
  override fun execute(entity: Entity, world: World) {
    //do nothing but increment exhaust by move amount
    entity.exaust = exhaustion
  }

}