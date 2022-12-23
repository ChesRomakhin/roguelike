package ru.chesromakhin.roguelike.world.command

import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.entity.Entity
import ru.chesromakhin.roguelike.world.entity.component.HealthComponent

class Attack(
  private val direction: Direction,
  private val damage: Int,
  exhaustion: Int,
) : Command(exhaustion) {

  override fun execute(entity: Entity, world: World) {
    entity.exaust = exhaustion

    val location = entity.location + direction.delta
    val victim = world.getEntity(location) ?: return
    val healthComponent = victim.getComponent(HealthComponent::class) ?: return

    healthComponent.damage(damage)
  }

}