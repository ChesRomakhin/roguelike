package ru.chesromakhin.roguelike.world.entity

import ru.chesromakhin.roguelike.world.Location
import ru.chesromakhin.roguelike.world.action.Action
import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.entity.component.Component
import kotlin.reflect.KClass

abstract class Entity(val id: String) {

  open var char: String = "?"
  var location: Location = Location(0, 0)

  open var actionExhaustion: Int = 1
  open var exhaust: Int = 0

  protected var components: List<Component> = ArrayList()

  abstract fun process(world: World): Action

  fun addComponent(component: Component) {
    component.entity = this
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