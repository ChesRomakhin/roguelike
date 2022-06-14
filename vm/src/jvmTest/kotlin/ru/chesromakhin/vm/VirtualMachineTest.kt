package ru.chesromakhin.vm

import ru.chesromakhin.vm.command.flow.FlowCommandGroup
import ru.chesromakhin.vm.command.math.MathCommandGroup
import ru.chesromakhin.vm.command.system.SystemCommandGroup
import ru.chesromakhin.vm.memory.MemoryDriver
import kotlin.test.Test
import kotlin.test.assertEquals

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

  @Test
  fun runTestProgramCycle() {
    val vm = VirtualMachine()
    val memoryDriver = MemoryDriver(16, 16)
    memoryDriver.write(0, 10) //i
    memoryDriver.write(1, 0) //a
    memoryDriver.write(2, 10) //b
    vm.addDriver(memoryDriver)
    vm.setCommands(SystemCommandGroup().getCommandsForGroup(0x01))
    vm.setCommands(MathCommandGroup().getCommandsForGroup(0x01))
    vm.setCommands(FlowCommandGroup().getCommandsForGroup(0x02))
    vm.loadProgram(listOf(
      0x0210_00_04, //if (i != 0) continue cycle else goto end
      0x0100_01_02, // a += b
      0x0103_00_00, // i = i - 1
      0x0201_00_03, // go back for 3 commands
      0x0001_00_00, // halt
    ))
    vm.runForTicks(1000)

    println(memoryDriver.read(0))
    println(memoryDriver.read(1))
    println(memoryDriver.read(2))

    assertEquals(0, memoryDriver.read(0), "i == 0")
    assertEquals(100, memoryDriver.read(1), "a == 100")
    assertEquals(10, memoryDriver.read(2), "b was not modified")
  }

}