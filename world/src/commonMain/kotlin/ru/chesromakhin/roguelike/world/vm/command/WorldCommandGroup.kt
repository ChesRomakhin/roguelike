package ru.chesromakhin.roguelike.world.vm.command

import ru.chesromakhin.vm.command.Command
import ru.chesromakhin.vm.command.CommandGroup
import ru.chesromakhin.vm.command.system.NoopCommand

class WorldCommandGroup: CommandGroup {
  override val commands: Map<Int, Command> = mapOf<Int, Command>(
    0x00 to NoopCommand(),
  )
}