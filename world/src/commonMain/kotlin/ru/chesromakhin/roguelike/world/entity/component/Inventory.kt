package ru.chesromakhin.roguelike.world.entity.component

import ru.chesromakhin.roguelike.world.entity.Entity
import ru.chesromakhin.roguelike.world.item.Armor
import ru.chesromakhin.roguelike.world.item.Item
import ru.chesromakhin.roguelike.world.item.Weapon

class Inventory: Component, AttackComponent, DefenceComponent {
  override val name: String = "inventory"

  override var entity: Entity? = null

  var armor: Armor? = null
  var weapon: Weapon? = null

  var bag: List<Item> = listOf()

  override val attack: Int
    get() = this.weapon?.attack ?: 1

  override val defence: Int
    get() = this.armor?.defence ?: 0

}