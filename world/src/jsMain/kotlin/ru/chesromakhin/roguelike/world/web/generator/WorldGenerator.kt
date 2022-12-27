package ru.chesromakhin.roguelike.world.web.generator

import ru.chesromakhin.roguelike.world.CellType
import ru.chesromakhin.roguelike.world.Location
import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.entity.WanderingBot
import ru.chesromakhin.roguelike.world.item.Armor
import ru.chesromakhin.roguelike.world.item.ItemEntity
import ru.chesromakhin.roguelike.world.item.Weapon
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

  generateItems(world, 7)

  return world
}

fun generateItems(world: World, itemCount: Int) {
  IntRange(0, itemCount).map {
    val item = if (it % 2 == 0) {
      Armor(it.toString(), it + 1)
    } else {
      Weapon(it.toString(), it + 1)
    }
    val itemEntity = ItemEntity(item)
    itemEntity.location = Location(it + 1, it + 1)
    itemEntity
  }.forEach { world.addEntity(it) }
}