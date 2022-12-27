package ru.chesromakhin.roguelike.world.command

import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.entity.Entity
import ru.chesromakhin.roguelike.world.entity.component.AttackComponent
import ru.chesromakhin.roguelike.world.entity.component.DefenceComponent
import ru.chesromakhin.roguelike.world.entity.component.HealthComponent

class Attack(
  private val direction: Direction,
  exhaustion: Int,
) : Command(exhaustion) {

  override fun execute(entity: Entity, world: World) {
    entity.exhaust = exhaustion

    val attack = entity.getComponent(AttackComponent::class)?.attack ?: return

    val location = entity.location + direction.delta
    val victim = world.getEntity(location, HealthComponent::class) ?: return
    val healthComponent = victim.getComponent(HealthComponent::class) ?: return
    val defence = victim.getComponent(DefenceComponent::class)?.defence ?: 0

    val damage = if (defence >= attack) {
      0
    } else {
      attack - defence
    }

    if (damage > 0) {
      healthComponent.damage(damage)
    }
  }

}