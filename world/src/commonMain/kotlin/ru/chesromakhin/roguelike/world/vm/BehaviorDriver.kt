package ru.chesromakhin.roguelike.world.vm

import ru.chesromakhin.roguelike.world.CommandListener
import ru.chesromakhin.roguelike.world.action.Action
import ru.chesromakhin.roguelike.world.entity.Entity
import ru.chesromakhin.vm.driver.Driver

class BehaviorDriver: Driver {

  override val name: String = "world.behaviour"

  private var commandListeners: List<CommandListener> = ArrayList()

  var lastAction: Action? = null
    get() = field

  fun onCommand(listener: CommandListener) {
    commandListeners += listener
  }

  fun sendCommand(action: Action, entity: Entity) {
    this.lastAction = action
    commandListeners.forEach { it.invoke(action, entity) }
  }

}