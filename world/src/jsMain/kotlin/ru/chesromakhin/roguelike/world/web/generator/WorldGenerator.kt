package ru.chesromakhin.roguelike.world.web.generator

import ru.chesromakhin.roguelike.world.CellType
import ru.chesromakhin.roguelike.world.Location
import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.entity.WanderingBot

fun generateWorld(): World {
  val world = World()

  world.cells.forEach {
    it.first().type = CellType.WALL
    it.last().type = CellType.WALL
  }
  world.cells.first().forEach { it.type = CellType.WALL }
  world.cells.last().forEach { it.type = CellType.WALL }

  val wanderingBot = WanderingBot()
  wanderingBot.location = Location(1,2)
  world.addEntity(wanderingBot)

  return world
}