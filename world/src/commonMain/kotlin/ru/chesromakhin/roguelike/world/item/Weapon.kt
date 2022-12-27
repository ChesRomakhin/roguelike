package ru.chesromakhin.roguelike.world.item

class Weapon(
  override val id: String,
  var attack: Int = 1
) : Item {

}