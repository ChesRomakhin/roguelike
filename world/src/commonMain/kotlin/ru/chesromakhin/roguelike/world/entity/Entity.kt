package ru.chesromakhin.roguelike.world.entity

import ru.chesromakhin.roguelike.world.Location
import ru.chesromakhin.roguelike.world.command.Command
import ru.chesromakhin.roguelike.world.World

abstract class Entity {

  open val char: Char = '?'
  var location: Location = Location(0, 0)

  private val exaust: Int = 0

  abstract fun process(world: World): Command

}