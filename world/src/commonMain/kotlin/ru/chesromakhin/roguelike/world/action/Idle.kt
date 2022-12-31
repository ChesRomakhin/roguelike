package ru.chesromakhin.roguelike.world.action

import ru.chesromakhin.roguelike.world.entity.Entity
import ru.chesromakhin.roguelike.world.World

class Idle(exhaustion: Int) : Action(exhaustion) {
  override fun execute(entity: Entity, world: World) {
    //do nothing but increment exhaust by move amount
    entity.exhaust = exhaustion
  }

}