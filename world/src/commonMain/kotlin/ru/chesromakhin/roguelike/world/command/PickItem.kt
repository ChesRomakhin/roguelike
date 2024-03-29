package ru.chesromakhin.roguelike.world.command

import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.entity.Entity
import ru.chesromakhin.roguelike.world.entity.component.Inventory
import ru.chesromakhin.roguelike.world.item.Armor
import ru.chesromakhin.roguelike.world.item.ItemComponent
import ru.chesromakhin.roguelike.world.item.ItemEntity
import ru.chesromakhin.roguelike.world.item.Weapon

class PickItem: Command(1) {

  override fun execute(entity: Entity, world: World) {
    entity.exhaust += this.exhaustion

    val itemEntity = (world.getEntity(entity.location, ItemComponent::class) ?: return) as ItemEntity
    val item = itemEntity.getComponent(ItemComponent::class)!!.item

    val inventory = entity.getComponent(Inventory::class)!!
    when (item) {
      is Armor -> inventory.armor = item
      is Weapon -> inventory.weapon = item
      else -> return
    }

    world.destroyEntity(itemEntity)
  }

}