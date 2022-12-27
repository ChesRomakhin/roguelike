package ru.chesromakhin.roguelike.world

import ru.chesromakhin.roguelike.world.entity.Entity
import ru.chesromakhin.roguelike.world.entity.component.Component
import kotlin.reflect.KClass

class World {

  var cells: Array<Array<Cell>> = Array(10) { i -> Array(10) { j -> Cell(i, j) } }
  var entities: List<Entity> = ArrayList()

  fun addEntity(entity: Entity) {
    entities += entity
  }

  fun getEntity(location: Location): Entity? {
    return entities.find { it.location == location }
  }

  fun getEntity(location: Location, componentClass: KClass<out Component>): Entity? {
    return entities.find { it.location == location && it.hasComponent(componentClass) }
  }

}