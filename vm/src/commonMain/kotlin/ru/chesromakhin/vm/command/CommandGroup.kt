package ru.chesromakhin.vm.command

interface CommandGroup {

  val commands: Map<Int, Command>

  fun getCommandsForGroup(group: Int): Map<Int, Command> {
    return commands.map { it.key.and(0xFF)
      .or(
        group shl 8 and 0xFF00
      )
      .and(0xFFFF) to it.value }.toMap()
  }

}