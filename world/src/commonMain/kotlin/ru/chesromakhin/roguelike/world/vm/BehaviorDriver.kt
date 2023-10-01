package ru.chesromakhin.roguelike.world.vm

import ru.chesromakhin.roguelike.world.action.Action
import ru.chesromakhin.roguelike.world.entity.Entity
import ru.chesromakhin.vm.driver.Driver

typealias BehaviorListener =  (action: Action) -> Unit

class BehaviorDriver(val entity: Entity) : Driver {

  companion object {
    const val NAME: String = "world.behavior"
  }

  override val name: String = NAME

  private var commandListeners: List<BehaviorListener> = ArrayList()

  var lastAction: Action? = null
    get() = field

  fun onCommand(listener: BehaviorListener) {
    commandListeners += listener
  }

  fun sendCommand(action: Action) {
    this.lastAction = action
    commandListeners.forEach { it.invoke(action) }
  }

}