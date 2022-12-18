package ru.chesromakhin.roguelike.world.entity

import ru.chesromakhin.roguelike.world.command.Command
import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.command.Idle

class WanderingBot : Entity() {

  override val char: Char = 'W'

  override fun process(world: World): Command {
    return Idle()
  }

}