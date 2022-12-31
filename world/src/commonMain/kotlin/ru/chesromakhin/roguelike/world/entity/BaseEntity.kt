package ru.chesromakhin.roguelike.world.entity

import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.action.Action
import ru.chesromakhin.roguelike.world.action.Idle

class BaseEntity(id: String): Entity(id) {

  override fun process(world: World): Action {
    return components.map { it.process(this, world) }.firstOrNull() ?: Idle(1)
  }

}