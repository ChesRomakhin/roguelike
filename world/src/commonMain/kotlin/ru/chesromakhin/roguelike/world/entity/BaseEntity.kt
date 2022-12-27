package ru.chesromakhin.roguelike.world.entity

import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.command.Command
import ru.chesromakhin.roguelike.world.command.Idle

class BaseEntity(id: String): Entity(id) {

  override fun process(world: World): Command {
    return components.map { it.process(this, world) }.firstOrNull() ?: Idle(1)
  }

}