package ru.chesromakhin.roguelike.world.entity.component

import ru.chesromakhin.roguelike.world.entity.Entity

class Passable : Component {

  override val name: String = "passable"
  override var entity: Entity? = null

}