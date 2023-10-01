package ru.chesromakhin.roguelike.world.action

import ru.chesromakhin.roguelike.world.entity.Entity
import ru.chesromakhin.roguelike.world.World

class Idle : Action {

  override fun execute(entity: Entity, world: World) {
    //do nothing but increment exhaust by move amount
    entity.exhaust = entity.actionExhaustion
  }

}