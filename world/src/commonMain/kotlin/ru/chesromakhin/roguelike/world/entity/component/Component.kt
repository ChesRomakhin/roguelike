package ru.chesromakhin.roguelike.world.entity.component

import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.command.Command
import ru.chesromakhin.roguelike.world.entity.Entity

interface Component {

  val name: String

  fun process(entity: Entity, world: World): Command? {
    return null
  }

}