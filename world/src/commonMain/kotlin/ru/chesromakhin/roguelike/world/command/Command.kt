package ru.chesromakhin.roguelike.world.command

import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.entity.Entity

abstract class Command {

  abstract fun execute(entity: Entity, world: World)

}