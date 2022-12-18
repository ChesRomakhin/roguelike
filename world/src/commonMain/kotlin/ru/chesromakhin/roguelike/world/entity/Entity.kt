package ru.chesromakhin.roguelike.world.entity

import ru.chesromakhin.roguelike.world.Location
import ru.chesromakhin.roguelike.world.command.Command
import ru.chesromakhin.roguelike.world.World

abstract class Entity(val id: String) {

  open var char: Char = '?'
  var location: Location = Location(0, 0)

  var exaust: Int = 0

  abstract fun process(world: World): Command

}