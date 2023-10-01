package ru.chesromakhin.roguelike.world.action

import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.entity.Entity

interface Action {

  fun execute(entity: Entity, world: World)

}