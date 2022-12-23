package ru.chesromakhin.roguelike.world.web.generator

import ru.chesromakhin.roguelike.world.CellType
import ru.chesromakhin.roguelike.world.Location
import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.entity.WanderingBot
import kotlin.js.Date

fun generateWorld(): World {
  val world = World()

  world.cells.forEach {
    it.first().type = CellType.WALL
    it.last().type = CellType.WALL
  }
  world.cells.first().forEach { it.type = CellType.WALL }
  world.cells.last().forEach { it.type = CellType.WALL }

  val wanderingBot = WanderingBot(Date.now().toString(), 10)
  wanderingBot.location = Location(1,2)
  world.addEntity(wanderingBot)

  val wanderingBot2 = WanderingBot(Date.now().toString(), 10)
  wanderingBot2.location = Location(6,5)
  wanderingBot2.speed = 4
  wanderingBot2.char = 'F'
  world.addEntity(wanderingBot2)

  return world
}