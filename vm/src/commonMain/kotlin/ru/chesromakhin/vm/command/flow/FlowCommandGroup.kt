package ru.chesromakhin.vm.command.flow

import ru.chesromakhin.vm.command.Command
import ru.chesromakhin.vm.command.CommandGroup
import ru.chesromakhin.vm.command.math.AddCommand
import ru.chesromakhin.vm.command.math.SubCommand

class FlowCommandGroup: CommandGroup {

    override val commands: Map<Int, Command>
      get() = mapOf(
        0x00 to AddCommand(),
        0x01 to SubCommand()
      )
}