package ru.chesromakhin.roguelike.world.item

import ru.chesromakhin.roguelike.world.entity.component.Component

class ItemComponent(
  val item: Item
): Component {
  override val name: String = "item"
}