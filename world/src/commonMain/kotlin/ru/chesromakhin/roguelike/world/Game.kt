package ru.chesromakhin.roguelike.world

class Game(val world: World) {

  var listeners: List<() -> Any> = ArrayList()

  fun cycle() {
    var entities = world.entities
    for (entity in entities) {
      if (entity.exaust > 0) {
        entity.exaust--
        continue
      }

      if (entity.exaust <= 0) {
        val command = entity.process(world)
        command.execute(entity, world)
      }
    }

    listeners.forEach { it.invoke() }
  }

  fun onCycle(listener: () -> Any) {
    this.listeners += listener
  }

}