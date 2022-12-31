package ru.chesromakhin.roguelike.world.item

import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.action.Action
import ru.chesromakhin.roguelike.world.action.Idle
import ru.chesromakhin.roguelike.world.entity.Entity
import ru.chesromakhin.roguelike.world.entity.component.Passable

class ItemEntity(
  item: Item
) : Entity(id = item.id) {

  init {
    this.components = listOf(ItemComponent(item), Passable())
  }

  override var char: Char = item::class.simpleName?.lowercase()?.first() ?: 'i'

  override var exhaust = 2
    set(value) {
      //items will not move for now
      field = 2
    }

  override fun process(world: World): Action {
    return Idle(100)
  }

}