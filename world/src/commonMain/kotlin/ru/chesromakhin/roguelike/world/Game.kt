package ru.chesromakhin.roguelike.world

import ru.chesromakhin.roguelike.world.action.Action
import ru.chesromakhin.roguelike.world.entity.Entity

typealias GameActionListener = (entity: Entity, action: Action) -> Unit
typealias CycleListener = () -> Unit

class Game(val world: World) {

  private var listeners: List<CycleListener> = ArrayList()
  private var commandListeners: List<GameActionListener> = ArrayList()

  fun cycle() {
    val entities = world.entities
    for (entity in entities) {
      if (entity.exhaust > 0) {
        entity.exhaust--
        continue
      }

      if (entity.exhaust <= 0) {
        val command = entity.process(world)
        command.execute(entity, world)
        commandListeners.forEach { it.invoke(entity, command) }
      }
    }

    listeners.forEach { it.invoke() }
  }

  fun onCycle(listener: CycleListener) {
    this.listeners += listener
  }

  fun onCommand(listener: GameActionListener) {
    this.commandListeners += listener
  }

}