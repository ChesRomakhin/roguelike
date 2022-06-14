package ru.chesromakhin.vm.command.system

import ru.chesromakhin.vm.command.Command
import ru.chesromakhin.vm.command.CommandGroup

class SystemCommandGroup : CommandGroup {
  override val commands: Map<Int, Command>
    get() = mapOf(
      0x00 to NoopCommand(),
      0x01 to HaltCommand(),
    )
}