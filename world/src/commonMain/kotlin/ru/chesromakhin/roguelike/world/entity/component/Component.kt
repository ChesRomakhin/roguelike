package ru.chesromakhin.roguelike.world.entity.component

import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.action.Action
import ru.chesromakhin.roguelike.world.entity.Entity

interface Component {

  val name: String

  var entity: Entity?

  fun process(world: World): Action? {
    return null
  }

}