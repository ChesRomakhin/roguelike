package ru.chesromakhin.roguelike.world.entity

import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.command.Command
import ru.chesromakhin.roguelike.world.command.Movement
import ru.chesromakhin.roguelike.world.command.MovementDirection
import kotlin.random.Random

class WanderingBot(id: String) : Entity(id) {

  override var char: Char = 'W'
  var speed: Int = 2

  private var random: Random = Random(id.hashCode())

  override fun process(world: World): Command {
    return Movement(this.getRandomDirection(), this.getMoveExhaustion())
  }

  fun setRandomSeed(seed: Int) {
    random = Random(seed)
  }

  private fun getRandomDirection(): MovementDirection {
    val movementDirections = MovementDirection.values()
    return movementDirections[random.nextInt(movementDirections.size)]
  }

  private fun getMoveExhaustion(): Int {
    return speed
  }

}