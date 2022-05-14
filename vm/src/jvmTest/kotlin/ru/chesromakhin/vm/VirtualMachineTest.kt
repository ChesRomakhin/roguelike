package ru.chesromakhin.vm

import ru.chesromakhin.vm.command.math.MathCommandGroup
import ru.chesromakhin.vm.memory.MemoryDriver
import kotlin.test.Test

internal class VirtualMachineTest {

  @Test
  fun runTestProgram() {
    val vm = VirtualMachine()
    val memoryDriver = MemoryDriver(16, 16)
    memoryDriver.write(0, 5)
    memoryDriver.write(1, 7)
    vm.addDriver(memoryDriver)
    vm.setCommands(MathCommandGroup().getCommandsForGroup(0x01))
    vm.loadProgram(listOf(0x0100_00_01, 0x0100_02_01))
    vm.runForTicks(10)
    println(memoryDriver.read(0))
    println(memoryDriver.read(1))
    println(memoryDriver.read(2))
  }

}