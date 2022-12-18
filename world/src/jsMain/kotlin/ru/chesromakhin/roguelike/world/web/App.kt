package ru.chesromakhin.roguelike.world.web

import kotlinx.browser.document
import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.web.generator.generateWorld

fun main() {
  val world: World = generateWorld()
  console.warn(world)

  val root = document.getElementById("root")

  root!!.textContent = "hello world!"

  WorldRenderer(world, root).render()
}