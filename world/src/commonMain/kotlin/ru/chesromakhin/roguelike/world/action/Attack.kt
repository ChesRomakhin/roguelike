package ru.chesromakhin.roguelike.world.action

import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.entity.Entity
import ru.chesromakhin.roguelike.world.entity.component.AttackComponent
import ru.chesromakhin.roguelike.world.entity.component.DefenceComponent
import ru.chesromakhin.roguelike.world.entity.component.HealthComponent

class Attack(
  private val direction: Direction,
) : Action {

  override fun execute(entity: Entity, world: World) {
    entity.exhaust = entity.actionExhaustion

    val attack = entity.getComponent(AttackComponent::class)?.attack ?: return

    val location = entity.location + direction.delta
    val target = world.getEntity(location, HealthComponent::class) ?: return
    val targetHealth = target.getComponent(HealthComponent::class) ?: return
    val targetDefence = target.getComponent(DefenceComponent::class)?.defence ?: 0

    val damage = if (targetDefence >= attack) {
      0
    } else {
      attack - targetDefence
    }

    if (damage > 0) {
      targetHealth.damage(damage)
    }
  }

}