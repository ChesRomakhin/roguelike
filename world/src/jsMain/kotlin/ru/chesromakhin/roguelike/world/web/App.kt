package ru.chesromakhin.roguelike.world.web

import kotlinx.browser.document
import org.w3c.dom.Element
import ru.chesromakhin.roguelike.world.Game
import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.web.generator.generateWorld

fun main() {
  val world: World = generateWorld()
  val game = Game(world)

  val root = document.getElementById("root")!!

  val worldElement = document.createElement("div")
  root.appendChild(worldElement)
  val worldRenderer = WorldRenderer(world, worldElement)
  worldRenderer.render()

  val entitiesElement : Element = document.createElement("div")
  root.appendChild(entitiesElement)
  val entitiesRenderer = EntitiesRenderer(world, entitiesElement)
  entitiesRenderer.render()

  val gameInputs : Element = document.createElement("div")
  root.appendChild(gameInputs)
  val gameInputsRenderer = GameInputsRenderer(game, gameInputs)
  gameInputsRenderer.render()

  game.onCycle {
    worldRenderer.render()
    entitiesRenderer.render()
    gameInputsRenderer.render()
  }

  game.onCommand { command, entity -> console.log("entity[${entity.char}]{${entity.id}} executed command ${command::class.simpleName}") }
}