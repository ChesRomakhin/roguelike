package ru.chesromakhin.roguelike.world.entity

import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.command.Attack
import ru.chesromakhin.roguelike.world.command.Command
import ru.chesromakhin.roguelike.world.command.Direction
import ru.chesromakhin.roguelike.world.command.Movement
import ru.chesromakhin.roguelike.world.entity.component.HealthComponent
import ru.chesromakhin.roguelike.world.entity.component.Inventory
import kotlin.random.Random

class WanderingBot(id: String, health: Int) : Entity(id) {

  init {
    this.addComponent(HealthComponent(health))
    this.addComponent(Inventory())
  }

  override var char: Char = 'W'
  var speed: Int = 2

  private var random: Random = Random(id.hashCode())

  override fun process(world: World): Command {
    val attackDirection = Direction.values().find { world.getEntity(location + it.delta, HealthComponent::class) != null }

    if (attackDirection != null && random.nextBoolean()) {
      return Attack(attackDirection, this.getMoveExhaustion())
    }

    return Movement(this.getRandomDirection(), this.getMoveExhaustion())
  }

  fun setSeed(seed: Int) {
    random = Random(seed)
  }

  private fun getRandomDirection(): Direction {
    val directions = Direction.values()
    return directions[random.nextInt(directions.size)]
  }

  private fun getMoveExhaustion(): Int {
    return speed
  }

}