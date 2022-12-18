package ru.chesromakhin.roguelike.world.command

import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.entity.Entity

abstract class Command(open val exhaustion: Int) {

  abstract fun execute(entity: Entity, world: World)

}