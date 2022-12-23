package ru.chesromakhin.roguelike.world

import ru.chesromakhin.roguelike.world.command.Command
import ru.chesromakhin.roguelike.world.entity.Entity

typealias CommandListener = (command: Command, entity: Entity) -> Unit
typealias CycleListener = () -> Unit

class Game(val world: World) {

  private var listeners: List<CycleListener> = ArrayList()
  private var commandListeners: List<CommandListener> = ArrayList()

  fun cycle() {
    val entities = world.entities
    for (entity in entities) {
      if (entity.exaust > 0) {
        entity.exaust--
        continue
      }

      if (entity.exaust <= 0) {
        val command = entity.process(world)
        command.execute(entity, world)
        commandListeners.forEach { it.invoke(command, entity) }
      }
    }

    listeners.forEach { it.invoke() }
  }

  fun onCycle(listener: CycleListener) {
    this.listeners += listener
  }

  fun onCommand(listener: CommandListener) {
    this.commandListeners += listener
  }

}