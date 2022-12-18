package ru.chesromakhin.roguelike.world

import ru.chesromakhin.roguelike.world.entity.Entity

class World {

  var cells: Array<Array<Cell>> = Array(10) { i -> Array(10) { j -> Cell(i, j) } }
  var entities: List<Entity> = ArrayList()

  fun addEntity(entity: Entity) {
    entities += entity
  }

}