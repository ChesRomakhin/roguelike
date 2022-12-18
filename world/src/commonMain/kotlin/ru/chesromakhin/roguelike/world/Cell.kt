package ru.chesromakhin.roguelike.world

class Cell(private val x: Int, private val y: Int) {

  var type: CellType = CellType.FLOOR

}