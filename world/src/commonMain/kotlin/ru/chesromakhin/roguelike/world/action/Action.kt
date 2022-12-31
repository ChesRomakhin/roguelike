package ru.chesromakhin.roguelike.world.action

import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.entity.Entity

abstract class Action(open val exhaustion: Int) {

  abstract fun execute(entity: Entity, world: World)

}