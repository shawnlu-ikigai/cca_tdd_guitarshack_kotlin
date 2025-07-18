package com.guitarshack

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WarehouseTest {
  lateinit var warehouse: Warehouse
  @BeforeEach
  fun init() {
    val initialStock = Guitars.values().associateWith { 100 }
    warehouse = Warehouse(HashMap(initialStock))
  }

  @Test
  fun `check stock`() {
  assertEquals(100, warehouse.getStock(Guitars.BEAST))
  }

  @Test
  fun `deduct stock` () {
    warehouse.deductStock(Guitars.ELECTRIC_DREAM, 50)
    assertEquals(50, warehouse.getStock(Guitars.ELECTRIC_DREAM))
  }

  @Test
  fun `add stock` () {
    warehouse.addStock(Guitars.BEAST, 100)
    assertEquals(200, warehouse.getStock(Guitars.BEAST))
  }
}