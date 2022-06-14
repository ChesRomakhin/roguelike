package ru.chesromakhin.vm.command.flow

import ru.chesromakhin.vm.command.Command
import ru.chesromakhin.vm.command.CommandGroup

class FlowCommandGroup: CommandGroup {

    override val commands: Map<Int, Command>
      get() = mapOf(
        0x00 to GoToCommand(),
        0x01 to GoBackCommand(),
        0x10 to IfEqualsZeroCommand(),
        0x11 to IfGreaterZeroCommand(),
        0x12 to IfLessZeroCommand(),
        0x13 to IfEqualsCommand(),
        0x14 to IfGreaterCommand(),
        0x15 to IfLessCommand(),
      )
}