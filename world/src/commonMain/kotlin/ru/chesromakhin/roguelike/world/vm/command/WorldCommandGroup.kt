package ru.chesromakhin.roguelike.world.vm.command

import ru.chesromakhin.roguelike.world.action.Idle
import ru.chesromakhin.vm.command.Command
import ru.chesromakhin.vm.command.CommandGroup

class WorldCommandGroup: CommandGroup {
  override val commands: Map<Int, Command> = mapOf(
    0x00 to Idle(),

  )
}