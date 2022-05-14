package ru.chesromakhin.vm.command.math

import ru.chesromakhin.vm.command.Command
import ru.chesromakhin.vm.command.CommandGroup

class MathCommandGroup : CommandGroup {
  override val commands: Map<Int, Command>
    get() = mapOf(
      0x00 to AddCommand(),
      0x01 to SubCommand()
    )
}