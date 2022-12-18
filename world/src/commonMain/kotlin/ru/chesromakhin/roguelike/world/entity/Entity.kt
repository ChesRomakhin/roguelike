package ru.chesromakhin.roguelike.world.entity

import ru.chesromakhin.roguelike.world.Location
import ru.chesromakhin.roguelike.world.command.Command
import ru.chesromakhin.roguelike.world.World
import kotlin.reflect.KClass

abstract class Entity(val id: String) {

  open var char: Char = '?'
  var location: Location = Location(0, 0)

  var exaust: Int = 0

  private var components: List<Component> = ArrayList()

  abstract fun process(world: World): Command

  fun addComponent(component: Component) {
    this.components += component
  }

  fun hasComponent(componentClass: KClass<out Component>): Boolean {
    return this.components.any {
      componentClass.isInstance(it)
    }
  }

}