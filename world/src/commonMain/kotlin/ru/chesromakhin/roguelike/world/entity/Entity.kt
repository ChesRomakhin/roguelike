package ru.chesromakhin.roguelike.world.entity

import ru.chesromakhin.roguelike.world.Location
import ru.chesromakhin.roguelike.world.command.Command
import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.entity.component.Component
import kotlin.reflect.KClass

abstract class Entity(val id: String) {

  open var char: Char = '?'
  var location: Location = Location(0, 0)

  open var exhaust: Int = 0

  protected var components: List<Component> = ArrayList()

  abstract fun process(world: World): Command

  fun addComponent(component: Component) {
    this.components += component
  }

  fun hasComponent(componentClass: KClass<out Component>): Boolean {
    return this.components.any {
      componentClass.isInstance(it)
    }
  }

  @Suppress("UNCHECKED_CAST")
  fun <T: Component> getComponent(componentClass: KClass<T>): T? {
    return this.components.find { componentClass.isInstance(it) } as T?
  }

}